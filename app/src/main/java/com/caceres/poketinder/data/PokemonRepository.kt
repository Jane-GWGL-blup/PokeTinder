package com.caceres.poketinder.data

import com.caceres.poketinder.data.database.dao.PokemonDao
import com.caceres.poketinder.data.database.entities.MyPokemonEntity
import com.caceres.poketinder.data.model.PokemonDetailModel
import com.caceres.poketinder.data.model.PokemonListModel
import com.caceres.poketinder.data.model.PokemonModel
import com.caceres.poketinder.data.network.PokemonService
import com.caceres.poketinder.domain.model.MyPokemon
import com.caceres.poketinder.domain.model.Pokemon
import com.caceres.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
){
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
    //Ejercicio sem12
    suspend fun getPokemonDetailFromApi(idPokemon: String): PokemonDetailModel{
        return pokemonService.getPokemonById(idPokemon)

    }

    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon>{
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{ it.toDomain()}
    }

    suspend fun insertMyPokemon(myPokemon:MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }
}