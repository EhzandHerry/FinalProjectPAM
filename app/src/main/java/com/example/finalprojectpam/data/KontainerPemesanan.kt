package com.example.finalprojectpam.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val repositoriPemesanan: RepositoriPemesanan
}

class KontainerPemesanan: AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val repositoriPemesanan: RepositoriPemesanan by lazy {
        PemesanananRepositoryImpl(firestore)
    }
}