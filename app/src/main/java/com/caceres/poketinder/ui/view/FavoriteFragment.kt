package com.caceres.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.caceres.poketinder.databinding.FragmentFavoriteBinding
import com.caceres.poketinder.domain.model.MyPokemon
import com.caceres.poketinder.ui.adapter.MyPokemonsAdapter
import com.caceres.poketinder.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate)  {

    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy {MyPokemonsAdapter(listMyPokemon)}
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this){
            //Sem13
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
        //Sem13
        binding.floatingActionDelete.setOnClickListener {
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
        }
    }
}