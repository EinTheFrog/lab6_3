package com.example.lab6_3

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.lab6_3.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = MainViewModel()
        if (binding.imgView.drawable == null) {
            viewModel.loadImageFromNet()
        }

        viewModel.bitmapData.observe(this) { value ->
            if (value != null) {
                binding.imgView.setImageBitmap(value)
            }
        }
    }
}