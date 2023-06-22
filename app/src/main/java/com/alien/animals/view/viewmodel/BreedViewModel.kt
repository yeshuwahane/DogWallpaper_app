package com.alien.animals.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alien.animals.api.DogApi
import com.alien.animals.model.BreedListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreedViewModel:ViewModel() {
    var breedListLiveData: MutableLiveData<BreedListModel> = MutableLiveData()

    fun getBreedList(){
        DogApi().getBreedList().enqueue(object :Callback<BreedListModel>{
            override fun onResponse(call: Call<BreedListModel>, response: Response<BreedListModel>) {
                Log.d("alien","Success ${response.body()}")
                breedListLiveData.value = response.body()
            }

            override fun onFailure(call: Call<BreedListModel>, t: Throwable) {
                Log.d("alien","Failed ${t.message}")
            }

        })
    }
}