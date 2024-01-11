package com.example.finalprojectpam.ui.halamanpelanggan.edit

import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object EditDestinationPelanggan : DestinasiNavigasi {
    override val route = "item_Pelanggan"
    override val titleRes ="Edit Alat Musik"
    const val pelangganId = "itemId"
    val routeWithArgs = "${EditDestinationPelanggan.route}/{$pelangganId}"
}