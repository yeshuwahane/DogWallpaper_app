package com.alien.animals.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alien.animals.api.DogApi
import com.alien.animals.model.DogImageListModel
import com.alien.animals.model.RandomImageListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    val randomImageListLiveData: MutableLiveData<RandomImageListModel> = MutableLiveData()

    val dogImageListLiveData:MutableLiveData<DogImageListModel> = MutableLiveData()


    fun getRandomDogImages() {
        DogApi().getRandomImages().enqueue(object : Callback<RandomImageListModel> {
            override fun onResponse(call: Call<RandomImageListModel>, response: Response<RandomImageListModel>) {
                Log.d("alien", "Success ${response.body()}")
                randomImageListLiveData.value = response.body()
            }

            override fun onFailure(call: Call<RandomImageListModel>, t: Throwable) {
                Log.d("alien", "Failed ${t.stackTrace}")
            }

        })
    }

    fun getHuskies(){
        DogApi().getHuskiesImages().enqueue(object :Callback<DogImageListModel>{
            override fun onResponse(call: Call<DogImageListModel>, response: Response<DogImageListModel>) {
                Log.d("alien", "Success ${response.body()}")
                dogImageListLiveData.value = response.body()

            }

            override fun onFailure(call: Call<DogImageListModel>, t: Throwable) {
                Log.d("alien", "Failed ${t.stackTrace}")
            }

        })
    }
}