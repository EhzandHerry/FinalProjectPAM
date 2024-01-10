package com.example.finalprojectpam.ui.halamanalatmusik.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.example.finalprojectpam.ui.AddEventAlatMusik
import com.example.finalprojectpam.ui.AddUIStateAlatMusik
import com.example.finalprojectpam.ui.AlatMusikTopAppBar
import com.example.finalprojectpam.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiAddAlatMusik : DestinasiNavigasi {
    override val route = "Add AlatMusik"
    override val titleRes = "AddAlatMusik"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlatMusikScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addAlatMusikViewModel: AddAlatMusikViewModel = viewModel(factory = PenyediaViewModel.Factory),

    ) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AlatMusikTopAppBar(
                title = DestinasiAddAlatMusik.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->

        EntryBody(
            addUIStateAlatMusik = addAlatMusikViewModel.addUIStateAlatMusik,
            onAlatMusikValueChange = addAlatMusikViewModel::updateAddUIStateAlatMusik,
            onSaveClick = {
                coroutineScope.launch {
                    addAlatMusikViewModel.addAlatMusik()
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

@Composable
fun EntryBody(
    addUIStateAlatMusik: AddUIStateAlatMusik,
    onAlatMusikValueChange: (AddEventAlatMusik) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInput(
            addEventAlatMusik = addUIStateAlatMusik.addEventAlatMusik,
            onValueChange = onAlatMusikValueChange,
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
    addEventAlatMusik: AddEventAlatMusik,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventAlatMusik) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventAlatMusik.namaalat,
            onValueChange = { onValueChange(addEventAlatMusik.copy(namaalat = it)) },
            label = { Text("Nama Alat Musik") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventAlatMusik.jenis,
            onValueChange = { onValueChange(addEventAlatMusik.copy(jenis = it)) },
            label = { Text("Jenis Alat Musik") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventAlatMusik.harga,
            onValueChange = { onValueChange(addEventAlatMusik.copy(harga = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Harga Alat Musik") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

    }
}


