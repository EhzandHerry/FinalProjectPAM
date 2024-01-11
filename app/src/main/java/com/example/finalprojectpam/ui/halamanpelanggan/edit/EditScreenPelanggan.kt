package com.example.finalprojectpam.ui.halamanpelanggan.edit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.PelangganTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel
import com.example.finalprojectpam.ui.halamanpelanggan.add.EntryBodyPelanggan
import kotlinx.coroutines.launch

object EditDestinationPelanggan : DestinasiNavigasi {
    override val route = "item_Pelanggan"
    override val titleRes ="Edit Pelanggan"
    const val pelangganId = "itemIdPelanggan"
    val routeWithArgs = "${EditDestinationPelanggan.route}/{$pelangganId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenPelanggan(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModelPelanggan = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            PelangganTopAppBar(
                title = EditDestinationPelanggan.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntryBodyPelanggan(
            addUIStatePelanggan = viewModel.pelangganUiState,
            onPelangganValueChange = viewModel::updateUIStatePelanggan,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updatePelanggan()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

