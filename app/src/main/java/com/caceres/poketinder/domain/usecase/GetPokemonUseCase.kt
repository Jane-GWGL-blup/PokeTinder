package com.caceres.poketinder.domain.usecase

import com.caceres.poketinder.data.PokemonRepository
import com.caceres.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun  invoke():List<Pokemon>{
        return repository.getAllPokemonFromApi()
    }
}