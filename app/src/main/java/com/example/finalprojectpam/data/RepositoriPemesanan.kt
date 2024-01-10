package com.example.finalprojectpam.data

import android.content.ContentValues
import android.util.Log
import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.model.Pemesanan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface RepositoriPemesanan {
    fun getAll(): Flow<List<Pemesanan>>
    suspend fun save(pemesanan: Pemesanan): String
    suspend fun update(pemesanan: Pemesanan)
    suspend fun delete(pemesananId: String)
    fun getPemesananById(pemesananId: String): Flow<Pemesanan>
}

class PemesananRepositoryImpl(private val firestore: FirebaseFirestore) : RepositoriPemesanan {
    override fun getAll(): Flow<List<Pemesanan>> = flow {
        val snapshot = firestore.collection("Pemesanan")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val pemesanan = snapshot.toObjects(Pemesanan::class.java)
        emit(pemesanan)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(pemesanan: Pemesanan): String {
        return try {
            val documentReference = firestore.collection("Pemesanan").add(pemesanan).await()
            // Update the Pemesanan with the Firestore-generated DocumentReference
            firestore.collection("Pemesanan").document(documentReference.id)
                .set(pemesanan.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(pemesanan: Pemesanan) {
        firestore.collection("Pemesanan").document(pemesanan.id).set(pemesanan).await()
    }

    override suspend fun delete(pemesananId: String) {
        firestore.collection("Pemesanan").document(pemesananId).delete().await()
    }

    override fun getPemesananById(pemesananId: String): Flow<Pemesanan> {
        return flow {
            val snapshot = firestore.collection("Pemesanan").document(pemesananId).get().await()
            val pemesanan = snapshot.toObject(Pemesanan::class.java)
            emit(pemesanan!!)
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