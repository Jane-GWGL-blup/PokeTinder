package com.caceres.poketinder.data.model

import com.caceres.poketinder.domain.model.Abilities
import com.caceres.poketinder.domain.model.PokemonDetail
import com.caceres.poketinder.domain.model.Stats
import com.caceres.poketinder.domain.model.Types
import com.google.gson.annotations.SerializedName
//Ejercicio
data class PokemonDetailModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val base_experience: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("stats") val stats: List<Stats>,
    @SerializedName("types") val types: List<Types>,
    @SerializedName("abilities") val abilities: List<Abilities>
        ){
    fun toDomain() = PokemonDetail(
        id=id,
        name=name,
        base_experience=base_experience,
        height=height,
        weight=weight,
        stats=stats,
        types=types,
        abilities=abilities
    )
    /*data class Stats(
        val base_stat: Int,
        val stat:Stat
    ){
        data class Stat(
            val name: String
        )
    }

    data class Types(
        val type: Type
    ){
        data class Type(
            val name:String
        )
    }

    data class Abilities(
        val ability: Ability
    ){
        data class Ability(
            val name:String
        )
    }*/

}
