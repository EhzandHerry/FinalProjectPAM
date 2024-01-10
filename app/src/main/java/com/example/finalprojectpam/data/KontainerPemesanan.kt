package com.example.finalprojectpam.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val repositoriPemesanan: RepositoriPemesanan
    val repositoriAlatmusik: RepositoriAlatmusik
}

class KontainerPemesanan: AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val repositoriPemesanan: RepositoriPemesanan by lazy {
        PemesananRepositoryImpl(firestore)
    }
    override val repositoriAlatmusik: RepositoriAlatmusik by lazy {
        AlatMusikRepositoryImpl(firestore)
    }
}