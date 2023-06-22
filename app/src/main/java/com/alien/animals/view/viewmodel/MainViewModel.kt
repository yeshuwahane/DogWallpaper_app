package com.alien.animals.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alien.animals.api.DogApi
import com.alien.animals.model.HomeDogImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {

    var homeDogImage: MutableLiveData<HomeDogImage> = MutableLiveData()

    fun getHomeImage(){
        DogApi().getHomeImage().enqueue(object :Callback<HomeDogImage>{
            override fun onResponse(call: Call<HomeDogImage>, response: Response<HomeDogImage>) {
                Log.d("alien","Success ${response.body()}")
                homeDogImage.value = response.body()
            }

            override fun onFailure(call: Call<HomeDogImage>, t: Throwable) {
                Log.d("alien","failed ${t.message}")
            }
        })
    }
}