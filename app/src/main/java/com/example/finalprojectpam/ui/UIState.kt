package com.example.finalprojectpam.ui

import com.example.finalprojectpam.model.Pemesanan

data class AddUIState(
    val addEvent: AddEvent= AddEvent(),
)

data class AddEvent(
    val id: String="",
    val nama: String="",
    val nohp: String="",
    val alamat: String="",
    val harga: String="",
    val jumlah: String="",
    val alat: String=""
)

fun AddEvent.toPemesanan()= Pemesanan(
    id = id,
    nama = nama,
    nohp = nohp,
    alamat = alamat,
    harga = harga,
    jumlah= jumlah,
    alat= alat
)

data class  DetailUIState(
    val addEvent: AddEvent = AddEvent()
)

fun Pemesanan.toDetailPemesanan():AddEvent=
    AddEvent(
        id = id,
        nama = nama,
        nohp = nohp,
        alamat = alamat,
        harga = harga,
        jumlah= jumlah,
        alat= alat
    )

fun Pemesanan.toUIStatePemesanan(): AddUIState = AddUIState(
    addEvent = this
        .toDetailPemesanan()
)

data class HomeUIState(
    val listPemesanan: List<Pemesanan> = listOf(),
    val dataLength: Int = 0
)


