package com.primer.pokemonos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvlistapokemones.adapter=PokeAdapter()
        binding.rvlistapokemones.layoutManager=LinearLayoutManager(this)


    }
}
