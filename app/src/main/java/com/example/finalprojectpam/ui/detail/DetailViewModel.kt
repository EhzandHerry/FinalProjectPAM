package com.example.finalprojectpam.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.finalprojectpam.data.RepositoriPemesanan

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriPemesanan: RepositoriPemesanan
) : ViewModel() {}