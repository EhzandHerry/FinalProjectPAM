package com.example.finalprojectpam.ui.halamanpemesanan.edit

import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object EditDestinationPemesanan : DestinasiNavigasi {
    override val route = "item_Pemesanan"
    override val titleRes ="Edit Alat Musik"
    const val pemesananId = "itemId"
    val routeWithArgs = "${EditDestinationPemesanan.route}/{$pemesananId}"
}