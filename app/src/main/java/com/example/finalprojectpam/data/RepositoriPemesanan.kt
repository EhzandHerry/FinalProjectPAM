package com.example.finalprojectpam.data

import android.content.ContentValues
import android.util.Log
import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.model.Pelanggan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface RepositoriPelanggan {
    fun getAll(): Flow<List<Pelanggan>>
    suspend fun save(pelanggan: Pelanggan): String
    suspend fun update(pelanggan: Pelanggan)
    suspend fun delete(pelangganId: String)
    fun getPelangganById(pelangganId: String): Flow<Pelanggan>
}

class PelangganRepositoryImpl(private val firestore: FirebaseFirestore) : RepositoriPelanggan {
    override fun getAll(): Flow<List<Pelanggan>> = flow {
        val snapshot = firestore.collection("Pelanggan")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val pelanggan = snapshot.toObjects(Pelanggan::class.java)
        emit(pelanggan)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(pelanggan: Pelanggan): String {
        return try {
            val documentReference = firestore.collection("Pelanggan").add(pelanggan).await()
            // Update the Pelanggan with the Firestore-generated DocumentReference
            firestore.collection("Pelanggan").document(documentReference.id)
                .set(pelanggan.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(pelanggan: Pelanggan) {
        firestore.collection("Pelanggan").document(pelanggan.id).set(pelanggan).await()
    }

    override suspend fun delete(pelangganId: String) {
        firestore.collection("Pelanggan").document(pelangganId).delete().await()
    }

    override fun getPelangganById(pelangganId: String): Flow<Pelanggan> {
        return flow {
            val snapshot = firestore.collection("Pelanggan").document(pelangganId).get().await()
            val pelanggan = snapshot.toObject(Pelanggan::class.java)
            emit(pelanggan!!)
        }.flowOn(Dispatchers.IO)
    }

}

interface RepositoriAlatmusik {
    fun getAll(): Flow<List<AlatMusik>>
    suspend fun save(alatMusik: AlatMusik): String
    suspend fun update(alatMusik: AlatMusik)
    suspend fun delete(alatMusikId: String)
    fun getAlatMusikById(alatMusik: String): Flow<AlatMusik>
}

class AlatMusikRepositoryImpl(private val firestore: FirebaseFirestore) : RepositoriAlatmusik {
    override fun getAll(): Flow<List<AlatMusik>> = flow {
        val snapshot = firestore.collection("AlatMusik")
            .orderBy("namaalat", Query.Direction.ASCENDING)
            .get()
            .await()
        val alatMusik = snapshot.toObjects(AlatMusik::class.java)
        emit(alatMusik)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(alatMusik: AlatMusik): String {
        return try {
            val documentReference = firestore.collection("AlatMusik").add(alatMusik).await()
            // Update the AlatMusik with the Firestore-generated DocumentReference
            firestore.collection("AlatMusik").document(documentReference.id)
                .set(alatMusik.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(alatMusik: AlatMusik) {
        firestore.collection("AlatMusik").document(alatMusik.id).set(alatMusik).await()
    }

    override suspend fun delete(alatMusikId: String) {
        firestore.collection("AlatMusik").document(alatMusikId).delete().await()
    }

    override fun getAlatMusikById(alaMusikId: String): Flow<AlatMusik> {
        return flow {
            val snapshot = firestore.collection("AlatMusik").document(alaMusikId).get().await()
            val alatMusik = snapshot.toObject(AlatMusik::class.java)
            emit(alatMusik!!)
        }.flowOn(Dispatchers.IO)
    }

}