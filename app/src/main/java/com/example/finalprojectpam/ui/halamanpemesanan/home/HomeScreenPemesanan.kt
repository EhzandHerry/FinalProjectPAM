package com.example.finalprojectpam.ui.halamanpemesanan.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.PenyediaViewModel


object DestinasiHomePemesanan : DestinasiNavigasi {
    override val route = "Home Pemesanan"
    override val titleRes = "Pemesanan"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreenPemesanan(
    navigateToItemEntryPemesanan: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickPemesanan: (String) -> Unit = {},
    viewModel: HomeViewModelPemesanan = viewModel(factory = PenyediaViewModel.Factory)
) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            PemesananTopAppBar(title = "Pemesanan", canNavigateBack = false, scrollBehavior = scrollBehavior)
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = navigateToItemEntryPemesanan,
//                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = ""
//                )
//            }
//        }
//    ) { innerPadding ->
//        val uiStatePemesanan by viewModel.homeUIStatePemesanan.collectAsState()
//        BodyHome(
//            itemPemesanan = uiStatePemesanan.listPemesanan,
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize(),
//
//            onOrderClick = onDetailClickPemesanan
//        )
//    }
}
//@Composable
//fun BodyHome(
//    itemPemesanan: List<Pemesanan>,
//    modifier: Modifier = Modifier,
//    onOrderClick: (String) -> Unit = {}
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier
//    ) {
//        if (itemPemesanan.isEmpty()) {
//            Text(
//                text = "Tidak ada data Alat Musik",
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.titleLarge
//            )
//        } else {
//            ListPemesanan(
//                itemPemesanan = itemPemesanan,
//                modifier = Modifier
//                    .padding(horizontal = 8.dp),
//                onItemClick = { onOrderClick(it.id) }
//            )
//        }
//    }
//}
//@Composable
//fun ListPemesanan(
//    itemAlatMusik: List<Pemesanan>,
//    modifier: Modifier = Modifier,
//    onItemClick: (AlatMusik) -> Unit
//) {
//    LazyColumn(
//        modifier = modifier
//    ) {
//        this.items(itemAlatMusik, key = { it.id }) { pemesanan ->
//            DataPemesanan(
//                pemesanan = pemesanan,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { onItemClick(pemesanan) }
//            )
//            Spacer(modifier = Modifier.padding(8.dp))
//        }
//    }
//}
//
//@Composable
//fun DataPemesanan(
//    pemesanan: Pemesanan,
//    modifier: Modifier = Modifier
//) {
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(12.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(
//                    text = pemesanan.nama,
//                    style = MaterialTheme.typography.titleLarge,
//                )
//                Spacer(Modifier.weight(1f))
//                Icon(
//                    imageVector = Icons.Default.Phone,
//                    contentDescription = null,
//                )
//                Text(
//                    text = pemesanan.nohp,
//                    style = MaterialTheme.typography.titleMedium
//                )
//            }
//            Text(
//                text = pemesanan.alamat,
//                style = MaterialTheme.typography.titleMedium
//            )
//        }
//    }
//}