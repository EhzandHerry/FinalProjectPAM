package com.example.finalprojectpam.ui

data class AddUIState(
    val addEvent: AddEvent= AddEvent(),
)

data class AddEvent(
    val id: String="",
    val nama: String="",
    val nohp: String="",
    val alamat: String="",
    val harga: String="",
    val jumlah: String,
    val alat: String=""
)


