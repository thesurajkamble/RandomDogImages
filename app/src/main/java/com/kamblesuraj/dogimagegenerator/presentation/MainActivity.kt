package com.kamblesuraj.dogimagegenerator.presentation

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kamblesuraj.dogimagegenerator.R
import com.kamblesuraj.dogimagegenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnGenerate.setOnClickListener {
            Intent(this, ImageGenerateActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}