package com.example.finalprojectpam.ui

import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.model.Pelanggan


data class HomeUIStatePelanggan(
    val listPelanggan: List<Pelanggan> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateAlatMusik(
    val listAlatMusik: List<AlatMusik> = listOf(),
    val dataLength: Int = 0
)

data class AddUIStatePelanggan(
    val addEventPelanggan: AddEventPelanggan= AddEventPelanggan(),
)
data class AddUIStateAlatMusik(
    val addEventAlatMusik: AddEventAlatMusik = AddEventAlatMusik(),
)


data class AddEventPelanggan(
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


fun AddEventPelanggan.toPelanggan()= Pelanggan(
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


data class  DetailUIStatePelanggan(
    val addEventPelanggan: AddEventPelanggan= AddEventPelanggan(),
)
data class  DetailUIStateAlatMusik(
    val addEventAlatMusik: AddEventAlatMusik= AddEventAlatMusik(),
)

fun Pelanggan.toDetailPelanggan():AddEventPelanggan=
    AddEventPelanggan(
        id = id,
        nama = nama,
        nohp = nohp,
        alamat = alamat
    )
fun AlatMusik.toDetailAlatMusik():AddEventAlatMusik=
    AddEventAlatMusik(
        id = id,
        namaalat=namaalat,
        harga=harga,
        jenis=jenis
    )


fun Pelanggan.toUIStatePelanggan(): AddUIStatePelanggan = AddUIStatePelanggan(
    addEventPelanggan = this.toDetailPelanggan()
)
fun AlatMusik.toUIStateAlatMusik(): AddUIStateAlatMusik = AddUIStateAlatMusik(
    addEventAlatMusik = this.toDetailAlatMusik()
)




