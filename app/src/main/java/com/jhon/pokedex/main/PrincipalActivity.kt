package com.jhon.pokedex.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jhon.pokedex.databinding.ActivityPrincipalBinding


class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}