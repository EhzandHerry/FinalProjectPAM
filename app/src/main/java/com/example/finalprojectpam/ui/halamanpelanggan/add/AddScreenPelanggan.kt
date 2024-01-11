package com.example.finalprojectpam.ui.halamanpelanggan.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.AddEventPelanggan
import com.example.finalprojectpam.ui.AddUIStatePelanggan
import com.example.finalprojectpam.ui.PelangganTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiAddPelanggan : DestinasiNavigasi {
    override val route = "Add_Pelanggan"
    override val titleRes = "Tambah Data Pelanggan"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPelangganScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addPelangganViewModel: AddPelangganViewModel = viewModel(factory = PenyediaViewModel.Factory),

    ) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PelangganTopAppBar(
                title = DestinasiAddPelanggan.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
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
            EntryBodyPelanggan(
                addUIStatePelanggan = addPelangganViewModel.addUIStatePelanggan,
                onPelangganValueChange = addPelangganViewModel::updateAddUIStatePelanggan,
                onSaveClick = {
                    coroutineScope.launch {
                        addPelangganViewModel.addPelanggan()
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

@Composable
fun EntryBodyPelanggan(
    addUIStatePelanggan: AddUIStatePelanggan,
    onPelangganValueChange: (AddEventPelanggan) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInput(
            addEventPelanggan = addUIStatePelanggan.addEventPelanggan,
            onValueChange = onPelangganValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    addEventPelanggan: AddEventPelanggan,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventPelanggan) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventPelanggan.nama,
            onValueChange = { onValueChange(addEventPelanggan.copy(nama = it)) },
            label = { Text("Nama Pelanggan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPelanggan.nohp,
            onValueChange = { onValueChange(addEventPelanggan.copy(nohp = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("No Hp") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPelanggan.alamat,
            onValueChange = { onValueChange(addEventPelanggan.copy(alamat = it)) },
            label = { Text(text = "Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPelanggan.alatmusik,
            onValueChange = { onValueChange(addEventPelanggan.copy(alatmusik = it)) },
            label = { Text("Membeli Alat Musik") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

    }
}