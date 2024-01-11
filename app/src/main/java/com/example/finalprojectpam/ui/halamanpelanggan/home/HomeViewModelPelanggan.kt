package com.example.finalprojectpam.ui.halamanpelanggan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriPelanggan
import com.example.finalprojectpam.model.Pelanggan
import com.example.finalprojectpam.ui.HomeUIStatePelanggan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


sealed class PelangganUIState {
    data class Success(val pelanggan: Flow<List<Pelanggan>>) : PelangganUIState()
    object Error : PelangganUIState()
    object Loading : PelangganUIState()
}
class HomeViewModelPelanggan(private val repositoriPelanggan: RepositoriPelanggan) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIStatePelanggan: StateFlow<HomeUIStatePelanggan> = repositoriPelanggan.getAll()
        .filterNotNull()
        .map {
            HomeUIStatePelanggan (listPelanggan = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStatePelanggan()

        )
}