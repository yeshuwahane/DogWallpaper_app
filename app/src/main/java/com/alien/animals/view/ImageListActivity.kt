package com.alien.animals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alien.animals.adapter.ImageRvAdapter
import com.alien.animals.databinding.ActivityImageListBinding
import com.alien.animals.view.viewmodel.ListViewModel

class ImageListActivity: AppCompatActivity() {
    lateinit var binding: ActivityImageListBinding
    lateinit var imageRvAdapter: ImageRvAdapter
    lateinit var listViewModel: ListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val dogType = intent.getStringExtra("dog")
        Log.d("alien",dogType.toString())

        imageRvAdapter = ImageRvAdapter(this)
        binding.rvImageRvList.adapter = imageRvAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.rvImageRvList.layoutManager = layoutManager

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)


        when (dogType.toString()) {
            "huskies" -> {
                husky()
            }
            "beagle" -> {
                beagle()
            }
            "akita" -> {
                akita()
            }
            else -> {
                randomDogs()
            }
        }


    }

    fun husky(){
        listViewModel.getHuskies()
        listViewModel.dogImageListLiveData.observe(this, Observer {it->
            imageRvAdapter.setDogImages(it.message)
        })
    }

    fun beagle(){
        listViewModel.getBeagleImages()
        listViewModel.dogImageListLiveData.observe(this, Observer {
            imageRvAdapter.setDogImages(it.message)
        })
    }

    fun akita(){
        listViewModel.getAkitaImages()
        listViewModel.dogImageListLiveData.observe(this, Observer {
            imageRvAdapter.setDogImages(it.message)
        })
    }

    fun randomDogs(){
        listViewModel.getRandomDogImages()
        listViewModel.randomImageListLiveData.observe(this, Observer {it->
            imageRvAdapter.setDogImages(it.message)
        })
    }

}