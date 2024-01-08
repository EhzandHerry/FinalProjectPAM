package com.example.finalprojectpam.ui

import com.example.finalprojectpam.model.Pemesanan
import com.example.finalprojectpam.model.Pemesananan

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


