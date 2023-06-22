package com.alien.animals.view

import android.app.WallpaperManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import coil.load
import com.alien.animals.R
import com.alien.animals.databinding.ActivityWallpaperBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.net.URL

class WallpaperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSetWallpaper.setBackgroundColor(Color.TRANSPARENT)

        val intent = intent
        val url = intent.getStringExtra("url")
        binding.ivWallpaper.load(url)

        binding.btnSetWallpaper.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val inputStream = URL(url).openStream()
                WallpaperManager.getInstance(applicationContext).setStream(inputStream)
            }

            val emoji = "\uD83D\uDC4D\uD83C\uDFFB"

            Toast.makeText(this,"Wallpaper Set $emoji", Toast.LENGTH_SHORT).show()

        }
    }
}