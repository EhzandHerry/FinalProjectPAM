package com.example.finalprojectpam.model

data class Pemesanan(
    val id: String,
    val nama: String,
    val nohp: String,
    val alamat: String
){
    constructor(): this("","","","")
}

data class AlatMusik(
    val id: String,
    val namaalat: String,
    val harga: String,
    val jenis: String
){
    constructor(): this("","","","")
}
