package dev.mariorobert.formationviews

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.mariorobert.formationviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener {
            Log.d("MainActivity", binding.name.text.toString())
        }

        binding.clear.setOnClickListener {
            binding.name.setText("")
        }
    }
}
