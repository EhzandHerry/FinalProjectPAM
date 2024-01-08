package com.example.finalprojectpam.ui.alatmusik.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.model.Pemesanan
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.PemesananTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel

object destinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Pemesanan"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
)
    {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PemesananTopAppBar(title = "Pemesanan", canNavigateBack = false, scrollBehavior = scrollBehavior)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        val uiStatePemesanan by viewModel.homeUIState.collectAsState()
        BodyHome(
            itemPemesanan = uiStatePemesanan.listPemesanan,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onOrderClick = onDetailClick
        )
    }
}
@Composable
fun BodyHome(
    itemPemesanan: List<Pemesanan>,
    modifier: Modifier = Modifier,
    onOrderClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPemesanan.isEmpty()) {
            Text(
                text = "Tidak ada data Pesanan",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPemesanan(
                itemPemesanan = itemPemesanan,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onOrderClick(it.id) }
            )
        }
    }
}
@Composable
fun ListPemesanan(
    itemPemesanan: List<Pemesanan>,
    modifier: Modifier = Modifier,
    onItemClick: (Pemesanan) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemPemesanan, key = { it.id }) { pemesanan ->
            DataPemesanan(
                pemesanan = pemesanan,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(pemesanan) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataPemesanan(
    pemesanan: Pemesanan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pemesanan.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = pemesanan.nohp,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = pemesanan.alamat,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}