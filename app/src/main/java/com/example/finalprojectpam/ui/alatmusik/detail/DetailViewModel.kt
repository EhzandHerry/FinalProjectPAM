package com.example.finalprojectpam.ui.alatmusik.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.finalprojectpam.data.RepositoriAlatmusik

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriAlatmusik: RepositoriAlatmusik
) : ViewModel() {}