package com.example.finalprojectpam.ui.halamanalatmusik.home

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.model.AlatMusik
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.AddUIStateAlatMusik
import com.example.finalprojectpam.ui.AlatMusikTopAppBar
import com.example.finalprojectpam.ui.HomeUIStateAlatMusik
import com.example.finalprojectpam.ui.PemesananTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel
import com.example.finalprojectpam.ui.halamanalatmusik.detail.DestinasiDetailAlatMusik

object DestinasiHomeAlatMusik : DestinasiNavigasi {
    override val route = "Home AlatMusik"
    override val titleRes = "HomeAlatMusik"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreenAlatMusik(
    navigateToItemEntryAlatMusik: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickAlatMusik: (String) -> Unit = {},
    viewModel: HomeViewModelAlatMusik = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
//            AlatMusikTopAppBar(
//                title = "Alat musik",
//                canNavigateBack = false,
//                scrollBehavior = scrollBehavior
//            )
            AlatMusikTopAppBar(
                title = DestinasiHomeAlatMusik.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntryAlatMusik,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
    ) { innerPadding ->
        val uiStateAlatMusik by viewModel.homeUIStateAlatMusik.collectAsState()
        BodyHome(
            itemAlatMusik = uiStateAlatMusik.listAlatMusik,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onOrderClick = onDetailClickAlatMusik
        )
    }
}
@Composable
fun BodyHome(
    itemAlatMusik: List<AlatMusik>,
    modifier: Modifier = Modifier,
    onOrderClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemAlatMusik.isEmpty()) {
            Text(
                text = "Tidak ada data Alat Musik",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListAlatMusik(
                itemAlatMusik = itemAlatMusik,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onOrderClick(it.id) }
            )
        }
    }
}
@Composable
fun ListAlatMusik(
    itemAlatMusik: List<AlatMusik>,
    modifier: Modifier = Modifier,
    onItemClick: (AlatMusik) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemAlatMusik, key = { it.id }) { alatMusik ->
            DataAlatMusik(
                alatMusik = alatMusik,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(alatMusik) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}


  @Composable
fun DataAlatMusik(
    alatMusik: AlatMusik,
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
                    text = alatMusik.namaalat,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,

                )
                Text(
                    text = alatMusik.jenis,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = alatMusik.harga,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription =null )


        }
    }
}

/**
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.ui.AlatMusikTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel

data class AlatMusik(
    val id: String,
    val namaalat: String,
    val jenis: String,
    val harga: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAlatMusik(
    navigateToItemEntryAlatMusik: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickAlatMusik: (String) -> Unit = {},
    viewModel: HomeViewModelAlatMusik = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AlatMusikTopAppBar(
                title = "Alat musik",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntryAlatMusik,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
    ) { innerPadding ->
        val uiStateAlatMusik by viewModel.homeUIStateAlatMusik.collectAsState()
        BodyHome(
            itemAlatMusik = uiStateAlatMusik.listAlatMusik,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onOrderClick = onDetailClickAlatMusik
        )
    }
}

@Composable
fun BodyHome(
    itemAlatMusik: List<AlatMusik>,
    modifier: Modifier = Modifier,
    onOrderClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemAlatMusik.isEmpty()) {
            Text(
                text = "Tidak ada data Alat Musik",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListAlatMusik(
                itemAlatMusik = itemAlatMusik,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onOrderClick(it.id) }
            )
        }
    }
}

@Composable
fun ListAlatMusik(
    itemAlatMusik: List<AlatMusik>,
    modifier: Modifier = Modifier,
    onItemClick: (AlatMusik) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(itemAlatMusik, key = { it.id }) { alatMusik ->
            DataAlatMusik(
                alatMusik = alatMusik,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(alatMusik) },
                onDelete = {
                    HomeViewModelAlatMusik.onDeleteItem(alatMusik.id)
                    // Tambahkan logika penghapusan di sini
                    // Misalnya, panggil fungsi onDeleteItem pada ViewModel
                    // viewModel.onDeleteItem(alatMusik.id)
                    // atau sumber data yang sesuai
                    // dataSource.deleteItem(alatMusik.id)
                }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataAlatMusik(
    alatMusik: AlatMusik,
    onDelete: () -> Unit,
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = alatMusik.namaalat,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                )
                Text(
                    text = alatMusik.jenis,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = alatMusik.harga,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = onDelete,
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.error)
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Delete")
                }
            }
        }
    }
}
 */
