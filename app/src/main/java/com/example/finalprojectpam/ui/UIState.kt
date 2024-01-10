package com.example.finalprojectpam.ui

import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.model.Pemesanan


data class HomeUIStatePemesanan(
    val listPemesanan: List<Pemesanan> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateAlatMusik(
    val listAlatMusik: List<AlatMusik> = listOf(),
    val dataLength: Int = 0
)

data class AddUIStatePemesanan(
    val addEventPemesanan: AddEventPemesanan= AddEventPemesanan(),
)
data class AddUIStateAlatMusik(
    val addEventAlatMusik: AddEventAlatMusik = AddEventAlatMusik(),
)


data class AddEventPemesanan(
    val id: String="",
    val nama: String="",
    val nohp: String="",
    val alamat: String=""
)
data class AddEventAlatMusik(
    val id: String = "",
    val namaalat: String = "",
    val harga: String = "",
    val jenis: String = ""
)


fun AddEventPemesanan.toPemesanan()= Pemesanan(
    id = id,
    nama = nama,
    nohp = nohp,
    alamat = alamat
)
fun AddEventAlatMusik.toAlatMusik()= AlatMusik(
    id = id,
    namaalat=namaalat,
    harga=harga,
    jenis=jenis
)


data class  DetailUIStatePemesanan(
    val addEventPemesanan: AddEventPemesanan= AddEventPemesanan(),
)
data class  DetailUIStateAlatMusik(
    val addEventAlatMusik: AddEventAlatMusik= AddEventAlatMusik(),
)

fun Pemesanan.toDetailPemesanan():AddEventPemesanan=
    AddEventPemesanan(
        id = id,
        nama = nama,
        nohp = nohp,
        alamat = alamat)
fun AlatMusik.toDetailAlatMusik():AddEventAlatMusik=
    AddEventAlatMusik(
        id = id,
        namaalat=namaalat,
        harga=harga,
        jenis=jenis
    )


fun Pemesanan.toUIStatePemesanan(): AddUIStatePemesanan = AddUIStatePemesanan(
    addEventPemesanan = this.toDetailPemesanan()
)
fun AlatMusik.toUIStateAlatMusik(): AddUIStateAlatMusik = AddUIStateAlatMusik(
    addEventAlatMusik = this.toDetailAlatMusik()
)




