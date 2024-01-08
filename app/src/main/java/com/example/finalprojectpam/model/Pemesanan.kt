package com.example.finalprojectpam.model

data class Pemesanan(
    val id: String,
    val nama: String,
    val nohp: String,
    val alamat: String,
    val harga: String,
    val jumlah: String,
    val alat: String
){
    constructor(): this("","","","","","","")
}
