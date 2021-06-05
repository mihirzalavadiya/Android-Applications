package com.example.cardflipanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardflipanimation.databinding.ActivitySharedAniationTwoBinding

class SharedAniationTwo : AppCompatActivity() {

    private lateinit var binding: ActivitySharedAniationTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedAniationTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTitle("Shared Animation Two")
    }
}