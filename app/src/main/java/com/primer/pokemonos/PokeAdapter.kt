package com.primer.pokemonos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.primer.pokemonos.databinding.ItemListPokemonBinding

class PokeAdapter: RecyclerView.Adapter<PokeAdapter.PokemonVH>() {

    val listaPokemones=Pokedex().pokelist
    class PokemonVH(val biding:ItemListPokemonBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(pokemon: Pokemon) {
biding.pokeNombres.text=pokemon.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        val biding= ItemListPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonVH(biding)

    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
       val pokemon=listaPokemones.get(position)
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return listaPokemones.size

    }
}