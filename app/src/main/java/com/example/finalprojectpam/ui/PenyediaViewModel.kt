package com.example.finalprojectpam.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojectpam.PemesananAplication
import com.example.finalprojectpam.ui.halamanalatmusik.add.AddAlatMusikViewModel
import com.example.finalprojectpam.ui.halamanalatmusik.detail.DetailAlatMusikViewModel
import com.example.finalprojectpam.ui.halamanalatmusik.edit.EditViewModelAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.home.HomeViewModelAlatMusik
import com.example.finalprojectpam.ui.halamanpelanggan.add.AddPelangganViewModel
import com.example.finalprojectpam.ui.halamanpelanggan.home.HomeViewModelPelanggan

fun CreationExtras.aplikasiPemesanan(): PemesananAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PemesananAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModelAlatMusik(aplikasiPemesanan().container.repositoriAlatmusik)
        }
        initializer {
            AddAlatMusikViewModel(aplikasiPemesanan().container.repositoriAlatmusik)
        }

        initializer {
            DetailAlatMusikViewModel(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriAlatmusik)
        }
        initializer {
            EditViewModelAlatMusik(
                createSavedStateHandle(),
                aplikasiPemesanan().container.repositoriAlatmusik)
        }

        initializer {
            HomeViewModelPelanggan(aplikasiPemesanan().container.repositoriPelanggan)
        }
        initializer {
            AddPelangganViewModel(aplikasiPemesanan().container.repositoriPelanggan)
        }
//
//        initializer {
//            DetailAlatMusikViewModel(
//                createSavedStateHandle(),
//                aplikasiPemesanan().container.repositoriAlatmusik)
//        }
//        initializer {
//            EditViewModelAlatMusik(
//                createSavedStateHandle(),
//                aplikasiPemesanan().container.repositoriAlatmusik)
//        }


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