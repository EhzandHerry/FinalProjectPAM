package com.example.finalprojectpam.ui.halamanpelanggan.edit

import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object EditDestinationPelanggan : DestinasiNavigasi {
    override val route = "item_Pelanggan"
    override val titleRes ="Edit Pelanggan"
    const val pelangganId = "itemIdPelanggan"
    val routeWithArgs = "${EditDestinationPelanggan.route}/{$pelangganId}"
}