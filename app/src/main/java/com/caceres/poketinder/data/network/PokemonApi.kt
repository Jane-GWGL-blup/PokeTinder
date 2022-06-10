package com.caceres.poketinder.data.network

import com.caceres.poketinder.data.model.PokemonDetailModel
import com.caceres.poketinder.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("?Limit=20")
    suspend fun getPokemons() : Response<PokemonListModel>
//Para el ejercicio sem12
    @GET("{pokemon_id}")
    suspend fun getDetailPokemon(
        @Path("pokemon_id") pokemonId: String
    ): Response<PokemonDetailModel>
}