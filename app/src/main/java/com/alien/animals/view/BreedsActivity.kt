package com.alien.animals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alien.animals.adapter.ListRvAdapter
import com.alien.animals.databinding.ActivityBreedsBinding
import com.alien.animals.model.BreedList
import com.alien.animals.model.BreedListModel
import com.alien.animals.view.viewmodel.BreedViewModel
import java.util.Timer
import kotlin.concurrent.schedule

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

        Toast.makeText(this, "only akita and beagle works", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "will complete soon", Toast.LENGTH_SHORT).show()


        listRvAdapter.setBreedList(BreedList().breeds)
    }
}