package com.caceres.poketinder.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.caceres.poketinder.R
import com.caceres.poketinder.databinding.ActivityPokemonDetailBinding
import com.caceres.poketinder.ui.viewmodel.PokemonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

//Ejercicio sem12
@AndroidEntryPoint
class PokemonDetailActivity: BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate) {
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonDetailViewModel.isLoading.observe(this) {
            binding.progressBar2.isVisible=it
        }

        pokemonDetailViewModel.pokemonDetailModel.observe(this){
            binding.tvPosition.text=it.id.toString()
            binding.tvName.text = it.name
            binding.tvAltura.text=it.height.toString()
            binding.tvPeso.text=it.weight.toString()
            binding.tvExperienciaBase.text=it.base_experience.toString()
            binding.tvHabilidades.text=it.abilities.toString()
            binding.tvEstadisticas.text=it.stats.toString()
            binding.tvTipo.text=it.types.toString()
            it.stats.forEach{
                Toast.makeText(this,"Stat: $it", Toast.LENGTH_SHORT).show()
            }

        }
        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)

        if(pokemonId != null){
            pokemonDetailViewModel.onCreate(pokemonId!!)
            Toast.makeText(this,"PokemonId: $pokemonId",Toast.LENGTH_SHORT).show()
        }
    }
}