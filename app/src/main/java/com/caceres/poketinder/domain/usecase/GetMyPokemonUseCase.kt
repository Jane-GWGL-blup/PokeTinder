package com.caceres.poketinder.domain.usecase

import com.caceres.poketinder.data.PokemonRepository
import com.caceres.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}