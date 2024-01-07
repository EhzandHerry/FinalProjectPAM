package com.example.finalprojectpam.data

interface AppContainer {
    val RepositoriPemesanan: RepositoriPemesanan
}

class KontainerPemesanan : AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val kontakRepository: KontakRepository by lazy {
        KontakRepositoryImpl(firestore)
    }
}