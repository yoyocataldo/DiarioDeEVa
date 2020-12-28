package com.primer.pokemonos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.primer.pokemonos.databinding.ItemListPokemonBinding

class PokeAdapter: RecyclerView.Adapter<PokeAdapter.PokemonVH>() {

    var listaPokemones=Pokedex().pokelist
    class PokemonVH(val biding:ItemListPokemonBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(pokemon: Pokemon) {
biding.pokeNombres.text=pokemon.name
            biding.tvid.text=pokemon.id
            biding.tvtipo.text=pokemon.type.toString()
val context=biding.root.context
            Glide.with(context)
                .load(pokemon.img)
                .into(biding.ivpokemon)

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
    fun updatePokeList(type:String) {

        listaPokemones= Pokedex().getListaFiltrada(type)
        notifyDataSetChanged()

    }
    fun allPokemones() {

        listaPokemones= Pokedex().pokelist
        notifyDataSetChanged()

    }
}