package com.example.finalprojectpam.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.RepositoriPemesanan
import com.example.finalprojectpam.model.Pemesanan
import com.example.finalprojectpam.ui.HomeUIState
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
class HomeViewModel(private val repositoriPemesanan: RepositoriPemesanan) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIState: StateFlow<HomeUIState> = repositoriPemesanan.getAll()
        .filterNotNull()
        .map {
            HomeUIState (listPemesanan = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()

        )
}