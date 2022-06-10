package com.caceres.poketinder.domain.usecase

import com.caceres.poketinder.data.PokemonRepository
import com.caceres.poketinder.data.database.entities.toDatabase
import com.caceres.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}