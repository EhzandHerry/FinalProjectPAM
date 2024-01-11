package com.example.finalprojectpam.ui.halamanutama

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    onPelangganClicked:()-> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Your existing content goes here

            Text(

                text = stringResource(id = R.string.menu),
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(bottom = 200.dp, top = 50.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    Color.DarkGray
                ),
                onClick = onAlatMusikClicked,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .width(10.dp)
            ) {
                Text(
                    text = "Alat Musik",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    Color.DarkGray
                ),
                onClick =  onPelangganClicked ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .width(10.dp)
            ) {
                Text(
                    text = "Pelanggan",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}
