package com.caceres.poketinder.domain.usecase

import com.caceres.poketinder.data.PokemonRepository
import com.caceres.poketinder.domain.model.Pokemon
import javax.inject.Inject

//Sem13
class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun  invoke():List<Pokemon>{
        //Sem13
        val myPokemonList = repository.getMyPokemonsFromDatabase()
        //Sem13
        val allPokemon = repository.getAllPokemonFromApi()
        //Sem13
        val myPokemonListIds = myPokemonList.map{it.idPokemon}

        return allPokemon.filter { it.getPokemonId() !in myPokemonListIds }
    }
}