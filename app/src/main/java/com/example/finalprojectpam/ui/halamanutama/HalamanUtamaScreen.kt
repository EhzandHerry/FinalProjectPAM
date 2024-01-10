package com.example.finalprojectpam.ui.halamanutama

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigasi.DestinasiNavigasi

object DestinasiMenu : DestinasiNavigasi {
    override val route = "Menu"
    override val titleRes = "Menu Utama"
}

@Composable
fun HalamanUtamaScreen(
    onAlatMusikClicked: () -> Unit,
//    onPemesananClicked:() -> Unit,
){
    Column(

    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = stringResource(id = R.string.menu),
        color = colorResource(id = R.color.orange),
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier.padding(bottom = 100.dp, top = 150.dp)
    )
        Button(
            onClick = onAlatMusikClicked,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .width(10.dp)
        ) {
            Text(
                text="Alat Musik",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace)
        }


    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .width(10.dp)
    ) {
        Text(
            text="Pemesanan",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace)
    }
}
}