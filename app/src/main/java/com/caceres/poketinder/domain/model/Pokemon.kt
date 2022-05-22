package com.caceres.poketinder.domain.model

import com.caceres.poketinder.data.model.PokemonModel
import com.caceres.poketinder.util.getIdPokemonFromUrl
import java.io.Serializable

data class Pokemon(
    val name: String,
    val url: String
) : Serializable {
    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

fun PokemonModel.toDomain() = Pokemon(name = name, url = url)