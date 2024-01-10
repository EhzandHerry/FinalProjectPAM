package com.example.finalprojectpam.ui.halamanalatmusik.edit

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object EditDestinationAlatmusik : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes ="Edit Alat Musik"
    const val alatMusikId = "itemId"
    val routeWithArgs = "${EditDestinationAlatmusik.route}/{$alatMusikId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(){}

