package com.example.finalprojectpam.data

import android.content.ContentValues
import android.util.Log
import com.example.finalprojectpam.model.Pemesananan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface RepositoriPemesanan {
    fun getAll(): Flow<List<Pemesananan>>
    suspend fun save(Pemesananan: Pemesananan): String
    suspend fun update(Pemesananan: Pemesananan)
    suspend fun delete(PemesanananId: String)
    fun getPemesanananById(PemesanananId: String): Flow<Pemesananan>
}

class PemesanananRepositoryImpl(private val firestore: FirebaseFirestore) : RepositoriPemesanan {
    override fun getAll(): Flow<List<Pemesananan>> = flow {
        val snapshot = firestore.collection("Pemesananan")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val Pemesananan = snapshot.toObjects(Pemesananan::class.java)
        emit(Pemesananan)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(Pemesananan: Pemesananan): String {
        return try {
            val documentReference = firestore.collection("Pemesananan").add(Pemesananan).await()
            // Update the Pemesananan with the Firestore-generated DocumentReference
            firestore.collection("Pemesananan").document(documentReference.id)
                .set(Pemesananan.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(Pemesananan: Pemesananan) {
        firestore.collection("Pemesananan").document(Pemesananan.id).set(Pemesananan).await()
    }

    override suspend fun delete(PemesanananId: String) {
        firestore.collection("Pemesananan").document(PemesanananId).delete().await()
    }

    override fun getPemesanananById(PemesanananId: String): Flow<Pemesananan> {
        return flow {
            val snapshot = firestore.collection("Pemesananan").document(PemesanananId).get().await()
            val Pemesananan = snapshot.toObject(Pemesananan::class.java)
            emit(Pemesananan!!)
        }.flowOn(Dispatchers.IO)
    }

}