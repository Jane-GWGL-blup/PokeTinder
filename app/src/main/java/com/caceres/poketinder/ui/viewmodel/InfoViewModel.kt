package com.caceres.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caceres.poketinder.data.FirebaseRemoteConfigRepository
//Lab14
class InfoViewModel:ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }
    fun getUrlPokemon(): MutableLiveData<String>{
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }

}