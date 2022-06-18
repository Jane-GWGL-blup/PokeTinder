package com.caceres.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caceres.poketinder.domain.model.Pokemon
import com.caceres.poketinder.domain.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private  val getPokemonsUseCase: GetPokemonsUseCase
    ): ViewModel() {
        val pokemonList = MutableLiveData<List<Pokemon>>()
        val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }
}

