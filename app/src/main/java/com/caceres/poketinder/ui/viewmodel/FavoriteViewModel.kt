package com.caceres.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caceres.poketinder.domain.model.MyPokemon
import com.caceres.poketinder.domain.usecase.GetMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getMyPokemonUseCase: GetMyPokemonUseCase
): ViewModel(){

    val myPokemonList = MutableLiveData<List<MyPokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonUseCase()
            if(result.isNotEmpty()){
                myPokemonList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}