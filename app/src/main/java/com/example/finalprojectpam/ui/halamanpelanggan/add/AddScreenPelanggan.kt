package com.example.finalprojectpam.ui.halamanpelanggan.add

import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.halamanpelanggan.detail.DestinasiDetailPelanggan.pelangganId

object DestinasiAddPelanggan : DestinasiNavigasi {
    override val route = "Add_Pelanggan"
    override val titleRes = "Add Pelanggan"
    const val pelangganId = "itemId"
    val routeWithArgs = "$route/{$pelangganId}"
}