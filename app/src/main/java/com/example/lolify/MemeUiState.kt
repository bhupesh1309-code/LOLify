package com.example.lolify

import com.example.lolify.data.Meme

sealed class MemeUiState{
    object Loading : MemeUiState()

    data class Success(val meme: Meme) : MemeUiState()

    data class Error(val message: String) : MemeUiState()
}
