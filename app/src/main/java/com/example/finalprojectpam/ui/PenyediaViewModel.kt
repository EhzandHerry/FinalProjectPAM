package com.example.finalprojectpam.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojectpam.PemesananAplication
import com.example.finalprojectpam.ui.halamanalatmusik.add.AddAlatMusikViewModel
import com.example.finalprojectpam.ui.halamanalatmusik.home.HomeViewModelAlatMusik

fun CreationExtras.aplikasiPemesanan(): PemesananAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PemesananAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

      /**  initializer {
            AddViewModel(aplikasiPemesanan().container.repositoriPemesanan)
        }*/

        initializer {
            HomeViewModelAlatMusik(aplikasiPemesanan().container.repositoriAlatmusik)
        }

        initializer {
            AddAlatMusikViewModel(aplikasiPemesanan().container.repositoriAlatmusik)
        }

        /**initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriPemesanan
            )


        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriPemesanan
            )
        }*/
    }
}