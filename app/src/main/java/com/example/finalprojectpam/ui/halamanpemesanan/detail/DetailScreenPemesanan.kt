package com.example.finalprojectpam.ui.halamanpemesanan.detail

import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object DestinasiDetailPemesanan : DestinasiNavigasi {
    override val route = "Detail_Pemesanan"
    override val titleRes = "Detail Pemesanan"
    const val pemesananId = "pemesananId"
    val routeWithArgs = "$route/{$pemesananId}"
}