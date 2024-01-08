package com.example.finalprojectpam.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val repositoriPelanggan: RepositoriPelanggan
    val repositoriAlatmusik: RepositoriAlatmusik
}

class KontainerPemesanan: AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val repositoriPelanggan: RepositoriPelanggan by lazy {
        PelangganRepositoryImpl(firestore)
    }
    override val repositoriAlatmusik: RepositoriAlatmusik by lazy {
        AlatMusikRepositoryImpl(firestore)
    }
}