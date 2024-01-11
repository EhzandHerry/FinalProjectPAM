package com.example.finalprojectpam.ui.halamanpelanggan.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.model.Pelanggan
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.PelangganTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel

object DestinasiHomePelanggan : DestinasiNavigasi {
    override val route = "Home_Pelanggan"
    override val titleRes = "Home Pelanggan"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreenPelanggan(
    navigateToItemEntryPelanggan: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickPelanggan: (String) -> Unit = {},
    viewModel: HomeViewModelPelanggan = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PelangganTopAppBar(
                title = DestinasiHomePelanggan.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntryPelanggan,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_home),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            val uiStatePelanggan by viewModel.homeUIStatePelanggan.collectAsState()
            BodyHome(
                itemPelanggan = uiStatePelanggan.listPelanggan,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                onOrderClick = onDetailClickPelanggan
            )}

    }
}
@Composable
fun BodyHome(
    itemPelanggan: List<Pelanggan>,
    modifier: Modifier = Modifier,
    onOrderClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPelanggan.isEmpty()) {
            Text(
                color = Color.White,
                text = "Tidak ada data Pelanggan",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPelanggan(
                itemPelanggan = itemPelanggan,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onOrderClick(it.id) }
            )
        }
    }
}
@Composable
fun ListPelanggan(
    itemPelanggan: List<Pelanggan>,
    modifier: Modifier = Modifier,
    onItemClick: (Pelanggan) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemPelanggan, key = { it.id }) { pelanggan ->
            DataPelanggan(
                pelanggan = pelanggan,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(pelanggan) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun DataPelanggan(
    pelanggan: Pelanggan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pelanggan.nama,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = ""
                )
                Text(
                    text = pelanggan.nohp,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
