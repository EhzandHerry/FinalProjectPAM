package com.example.finalprojectpam.ui.halamanalatmusik.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriAlatmusik
import com.example.finalprojectpam.ui.AddEventAlatMusik
import com.example.finalprojectpam.ui.AddUIStateAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.home.AlatMusikUIState
import com.example.finalprojectpam.ui.toAlatMusik
import com.example.finalprojectpam.ui.toUIStateAlatMusik
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModelAlatMusik(
    savedStateHandle: SavedStateHandle,
    private val repositoriAlatmusik: RepositoriAlatmusik
) : ViewModel() {
    var alatMusikUiState by mutableStateOf(AddUIStateAlatMusik())
        private set

    private val alatMusikId: String = checkNotNull(savedStateHandle[EditDestinationAlatmusik.alatMusikId])

    init {
        viewModelScope.launch {
            alatMusikUiState =
                repositoriAlatmusik.getAlatMusikById(alatMusikId)
                    .filterNotNull()
                    .first()
                    .toUIStateAlatMusik()
        }
    }

    fun updateUIStateAlatmusik(addEventAlatMusik: AddEventAlatMusik) {
        alatMusikUiState = alatMusikUiState.copy(addEventAlatMusik = addEventAlatMusik)
    }

    suspend fun updateAlatmusik() {
        repositoriAlatmusik.update(alatMusikUiState.addEventAlatMusik.toAlatMusik())

    }
}