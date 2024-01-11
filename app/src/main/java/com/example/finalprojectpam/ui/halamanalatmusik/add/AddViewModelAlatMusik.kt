package com.example.finalprojectpam.ui.halamanalatmusik.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalprojectpam.data.RepositoriAlatmusik
import com.example.finalprojectpam.ui.AddEventAlatMusik
import com.example.finalprojectpam.ui.AddUIStateAlatMusik
import com.example.finalprojectpam.ui.toAlatMusik

class AddAlatMusikViewModel(private val repositoriAlatMusik: RepositoriAlatmusik): ViewModel(){
    var addUIStateAlatMusik by mutableStateOf(AddUIStateAlatMusik())
        private set
    fun updateAddUIStateAlatMusik(addEventAlatMusik: AddEventAlatMusik) {
        addUIStateAlatMusik = AddUIStateAlatMusik(addEventAlatMusik = addEventAlatMusik)
    }
    suspend fun addAlatMusik() {
        repositoriAlatMusik.save(addUIStateAlatMusik.addEventAlatMusik.toAlatMusik())
    }
}