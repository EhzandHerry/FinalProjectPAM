package com.example.finalprojectpam.ui.halamanalatmusik.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriAlatmusik
import com.example.finalprojectpam.ui.DetailUIStateAlatMusik
import com.example.finalprojectpam.ui.toDetailAlatMusik
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailAlatMusikViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriAlatmusik: RepositoriAlatmusik
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val alatMusikId: String = checkNotNull(savedStateHandle[DestinasiDetailAlatMusik.alatMusikId])

    val uiState: StateFlow<DetailUIStateAlatMusik> =
        repositoriAlatmusik.getAlatMusikById(alatMusikId)
            .filterNotNull()
            .map {
                DetailUIStateAlatMusik(addEventAlatMusik = it.toDetailAlatMusik())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStateAlatMusik()
            )
    suspend fun deleteAlatMusik() {
        repositoriAlatmusik.delete(alatMusikId)

    }
}