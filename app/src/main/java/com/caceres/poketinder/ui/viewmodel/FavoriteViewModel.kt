package com.caceres.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caceres.poketinder.domain.model.MyPokemon
import com.caceres.poketinder.domain.usecase.DeleteAllMyPokemonsUseCase
import com.caceres.poketinder.domain.usecase.GetMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getMyPokemonUseCase: GetMyPokemonUseCase,
    private val deleteAllMyPokemonsUseCase: DeleteAllMyPokemonsUseCase
): ViewModel(){

    val myPokemonList = MutableLiveData<List<MyPokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    //Sem13 modificacion
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonUseCase()
            myPokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }
    //Sem13
    fun deleteAllPokemon(){
        viewModelScope.launch {
            deleteAllMyPokemonsUseCase()
        }
    }
}