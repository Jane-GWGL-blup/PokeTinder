package com.caceres.poketinder.data

import com.caceres.poketinder.data.model.PokemonListModel
import com.caceres.poketinder.data.model.PokemonModel
import com.caceres.poketinder.data.network.PokemonService
import com.caceres.poketinder.domain.model.Pokemon
import com.caceres.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
){
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
}