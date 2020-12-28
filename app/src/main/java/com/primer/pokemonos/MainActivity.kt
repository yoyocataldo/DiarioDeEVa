package com.primer.pokemonos

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.primer.pokemonos.databinding.ActivityMainBinding

/*
Mostrar lista pokemones filtrando por tipo
Necesitamos Spinner de todos los tipos de pokemon
Adapter para mostrar lista filtrada
Recyclerview, Viewbinding
Layouts por mainactivity
Layout item Pokemon

 */

class MainActivity : AppCompatActivity() {
    val pokeAdapter=PokeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvlistapokemones.adapter=pokeAdapter
        binding.rvlistapokemones.layoutManager=LinearLayoutManager(this)

        val spinAdapter= ArrayAdapter(this, R.layout.simple_spinner_item,Pokedex().getType())
        binding.listaSpinner.adapter=spinAdapter
binding.listaSpinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val type=Pokedex().getType().get(position)
        when(type){
            "All"-> pokeAdapter.allPokemones()
            else-> pokeAdapter.updatePokeList(type)
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
/*no implementamos ni una w*/
    }
}
    }
}
