package com.example.finalprojectpam.ui.halamanutama

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigasi.DestinasiNavigasi


/**
object DestinasiHome : DestinasiNavigasi {
    override val route = "Cover"
    override val titleRes = "Pilih"
}*/


@Preview
@Composable
fun CoverScreen(
  //  onNextButtonClicked: () -> Unit
) {
    val image = painterResource(id = R.drawable.cover)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

    }
}