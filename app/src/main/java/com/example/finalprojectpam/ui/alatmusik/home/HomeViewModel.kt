package com.example.finalprojectpam.ui.alatmusik.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriAlatmusik
import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.ui.HomeUIStateAlatMusik
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


sealed class AlatMusikUIState {
    data class Success(val alatMusik: Flow<List<AlatMusik>>) : AlatMusikUIState()
    object Error : AlatMusikUIState()
    object Loading : AlatMusikUIState()
}
class HomeViewModelAlatMusik(private val repositoriAlatmusik: RepositoriAlatmusik) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIStateAlatMusik: StateFlow<HomeUIStateAlatMusik> = repositoriAlatmusik.getAll()
        .filterNotNull()
        .map {
            HomeUIStateAlatMusik (listAlatMusik = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStateAlatMusik()

        )
}