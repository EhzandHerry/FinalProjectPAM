package com.example.finalprojectpam.ui.halamanpelanggan.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriPelanggan
import com.example.finalprojectpam.ui.AddEventPelanggan
import com.example.finalprojectpam.ui.AddUIStatePelanggan
import com.example.finalprojectpam.ui.toPelanggan
import com.example.finalprojectpam.ui.toUIStatePelanggan
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModelPelanggan(
    savedStateHandle: SavedStateHandle,
    private val repositoriPelanggan: RepositoriPelanggan
) : ViewModel() {
    var pelangganUiState by mutableStateOf(AddUIStatePelanggan())
        private set

    private val pelangganId: String = checkNotNull(savedStateHandle[EditDestinationPelanggan.pelangganId])

    init {
        viewModelScope.launch {
            pelangganUiState =
                repositoriPelanggan.getPelangganById(pelangganId)
                    .filterNotNull()
                    .first()
                    .toUIStatePelanggan()
        }
    }

    fun updateUIStatePelanggan(addEventPelanggan: AddEventPelanggan) {
        pelangganUiState = pelangganUiState.copy(addEventPelanggan = addEventPelanggan)
    }

    suspend fun updatePelanggan() {
        repositoriPelanggan.update(pelangganUiState.addEventPelanggan.toPelanggan())

    }
}