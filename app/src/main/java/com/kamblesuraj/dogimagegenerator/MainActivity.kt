package com.kamblesuraj.dogimagegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kamblesuraj.dogimagegenerator.databinding.ActivityMainBinding
import com.kamblesuraj.dogimagegenerator.presentation.HistoryActivity
import com.kamblesuraj.dogimagegenerator.presentation.ImageGenerateActivity
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root)
        binding.btnGenerate.setOnClickListener {
            Intent(this, ImageGenerateActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnHistory.setOnClickListener {
            Intent(this, HistoryActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}