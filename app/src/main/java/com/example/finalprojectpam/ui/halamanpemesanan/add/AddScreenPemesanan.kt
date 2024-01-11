package com.example.finalprojectpam.ui.halamanpemesanan.add

import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.halamanpemesanan.detail.DestinasiDetailPemesanan.pemesananId

object DestinasiAddAlatMusik : DestinasiNavigasi {
    override val route = "Add_Pemesanan"
    override val titleRes = "Add Pemesanan"
    const val alatMusikId = "itemId"
    val routeWithArgs = "$route/{$pemesananId}"
}