package com.example.finalprojectpam.ui.halamanpelanggan.detail

import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object DestinasiDetailPelanggan : DestinasiNavigasi {
    override val route = "Detail_Pelanggan"
    override val titleRes = "Detail Pelanggan"
    const val pelangganId = "pelangganId"
    val routeWithArgs = "$route/{$pelangganId}"
}