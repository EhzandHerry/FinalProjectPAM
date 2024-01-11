package com.example.finalprojectpam.ui.halamanpelanggan.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalprojectpam.data.RepositoriPelanggan
import com.example.finalprojectpam.ui.AddEventPelanggan
import com.example.finalprojectpam.ui.AddUIStatePelanggan
import com.example.finalprojectpam.ui.toPelanggan

class AddPelangganViewModel(private val repositoriPelanggan: RepositoriPelanggan): ViewModel(){
    var addUIStatePelanggan by mutableStateOf(AddUIStatePelanggan())
        private set
    fun updateAddUIStatePelanggan(addEventPelanggan: AddEventPelanggan) {
        addUIStatePelanggan = AddUIStatePelanggan(addEventPelanggan = addEventPelanggan)
    }
    suspend fun addPelanggan() {
        repositoriPelanggan.save(addUIStatePelanggan.addEventPelanggan.toPelanggan())
    }
}