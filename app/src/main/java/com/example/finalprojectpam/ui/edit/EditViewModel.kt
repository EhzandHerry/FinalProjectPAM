package com.example.finalprojectpam.ui.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.finalprojectpam.data.RepositoriPemesanan

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriPemesanan: RepositoriPemesanan
) : ViewModel() {}