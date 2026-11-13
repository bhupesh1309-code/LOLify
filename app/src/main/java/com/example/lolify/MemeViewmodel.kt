package com.example.lolify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lolify.data.Meme
import com.example.lolify.data.MemeRepository
import com.example.lolify.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MemeViewmodel : ViewModel() {
    private val repository = MemeRepository(
        RetrofitInstance.api
    )
    private val _meme = MutableStateFlow<Meme?>(null)
    val meme: StateFlow<Meme?> = _meme.asStateFlow()

    private val _uiState = MutableStateFlow<MemeUiState>(MemeUiState.Loading)
    val uiState: StateFlow<MemeUiState> = _uiState.asStateFlow()

    fun fetchMeme() {
        viewModelScope.launch {
            _uiState.value = MemeUiState.Loading
            try {
                val result = repository.getRandomMeme()
                _uiState.value = MemeUiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = MemeUiState.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }
}