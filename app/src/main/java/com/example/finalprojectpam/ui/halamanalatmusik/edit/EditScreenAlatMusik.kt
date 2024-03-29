package com.example.finalprojectpam.ui.halamanalatmusik.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.AlatMusikTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel
import com.example.finalprojectpam.ui.halamanalatmusik.add.EntryBodyAlatMusik
import kotlinx.coroutines.launch

object EditDestinationAlatmusik : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes ="Edit Alat Musik"
    const val alatMusikId = "itemIdAlatMusik"
    val routeWithArgs = "${EditDestinationAlatmusik.route}/{$alatMusikId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenAlatMusik(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModelAlatMusik = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            AlatMusikTopAppBar(
                title =EditDestinationAlatmusik.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            Image(
                painter = painterResource(id = R.drawable.forgambar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            EntryBodyAlatMusik(
                addUIStateAlatMusik = viewModel.alatMusikUiState,
                onAlatMusikValueChange = viewModel::updateUIStateAlatmusik,
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.updateAlatmusik()
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
}

