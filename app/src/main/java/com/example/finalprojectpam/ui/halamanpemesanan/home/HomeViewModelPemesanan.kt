package com.example.finalprojectpam.ui.halamanpemesanan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriPemesanan
import com.example.finalprojectpam.model.Pemesanan
import com.example.finalprojectpam.ui.HomeUIStatePemesanan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


sealed class PemesananUIState {
    data class Success(val pemesanan: Flow<List<Pemesanan>>) : PemesananUIState()
    object Error : PemesananUIState()
    object Loading : PemesananUIState()
}
class HomeViewModelPemesanan(private val repositoriPemesanan: RepositoriPemesanan) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIStatePemesanan: StateFlow<HomeUIStatePemesanan> = repositoriPemesanan.getAll()
        .filterNotNull()
        .map {
            HomeUIStatePemesanan (listPemesanan = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStatePemesanan()

        )
}