package com.example.finalprojectpam.ui.halamanutama

import androidx.compose.runtime.Composable
import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "Cover"
    override val titleRes = "Pilih"
}

@Composable
fun HalamanHomeCoverScreen(
    onNextButtonClicked: () -> Unit
) {}