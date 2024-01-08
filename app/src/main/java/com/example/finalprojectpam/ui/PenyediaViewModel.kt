package com.example.finalprojectpam.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojectpam.PemesananAplication

fun CreationExtras.aplikasiPemesanan(): PemesananAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PemesananAplication)
/**
object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            AddViewModel(aplikasiPemesanan().container.repositoriPemesanan)
        }

        initializer {
            HomeViewModel(aplikasiPemesanan().container.repositoriPemesanan)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriPemesanan
            )
        }

        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriPemesanan
            )
        }
    }
}
*/