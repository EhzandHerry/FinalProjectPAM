package com.example.finalprojectpam.ui.halamanalatmusik.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object DestinasiDetailAlatMusik : DestinasiNavigasi {
    override val route = "Detail_AlatMusik"
    override val titleRes = "DetailAlatMusik"
    const val alatMusikId = "itemId"
    val routeWithArgs = "$route/{$alatMusikId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenAlatMusik(){}