package com.alien.animals.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.alien.animals.databinding.ActivityMainBinding
import com.alien.animals.view.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getHomeImage()
        mainViewModel.homeDogImage.observe(this, Observer {it->
            binding.homeDogImage.load(it.message)
            val url = it.message
            binding.homeDogImage.setOnClickListener {
                val intent = Intent(this,WallpaperActivity::class.java)
                intent.putExtra("url",url)
                startActivity(intent)
            }
        })

        binding.btnRandomImages.setOnClickListener {
            val intent = Intent(this,ImageListActivity::class.java)
            intent.putExtra("dog","random")
            startActivity(intent)

        }

        binding.btnHuskieButton.setOnClickListener {
            val intent = Intent(this,ImageListActivity::class.java)
            intent.putExtra("dog","huskies")
            startActivity(intent)

        }

        binding.btnBreedList.setOnClickListener {
            val intent = Intent(this,BreedsActivity::class.java)
            startActivity(intent)
        }


    }
}