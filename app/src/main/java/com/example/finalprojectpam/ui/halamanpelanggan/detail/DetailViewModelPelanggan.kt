package com.example.finalprojectpam.ui.halamanpelanggan.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriPelanggan
import com.example.finalprojectpam.ui.DetailUIStatePelanggan
import com.example.finalprojectpam.ui.toDetailPelanggan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailPelangganViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriPelanggan: RepositoriPelanggan
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val pelangganId: String = checkNotNull(savedStateHandle[DestinasiDetailPelanggan.pelangganId])

    val uiState: StateFlow<DetailUIStatePelanggan> =
        repositoriPelanggan.getPelangganById(pelangganId)
            .filterNotNull()
            .map {
                DetailUIStatePelanggan(addEventPelanggan = it.toDetailPelanggan())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStatePelanggan()
            )
    suspend fun deletePelanggan() {
        repositoriPelanggan.delete(pelangganId)
    }
}