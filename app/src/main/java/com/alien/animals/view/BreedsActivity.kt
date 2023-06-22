package com.alien.animals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alien.animals.adapter.ListRvAdapter
import com.alien.animals.databinding.ActivityBreedsBinding
import com.alien.animals.view.viewmodel.BreedViewModel

class BreedsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBreedsBinding
    lateinit var breedViewModel: BreedViewModel
    lateinit var listRvAdapter: ListRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listRvAdapter = ListRvAdapter(this)
        binding.rvBreedList.adapter = listRvAdapter
        val layout = LinearLayoutManager(this)
        binding.rvBreedList.layoutManager = layout

        breedViewModel = ViewModelProvider(this).get(BreedViewModel::class.java)

        breedViewModel.getBreedList()

        breedViewModel.breedListLiveData.observe(this, Observer {it->
            listRvAdapter.setDogBreed(it)
        })
    }
}