package com.alien.animals.api

import com.alien.animals.model.BreedListModel
import com.alien.animals.model.DogImageListModel
import com.alien.animals.model.HomeDogImage
import com.alien.animals.model.RandomImageListModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo"
private const val HOME_IMAGE_URL = "/api/breeds/image/random"
private const val RANDOM_IMAGES_URL = "/api/breeds/image/random/20"
private const val HUSKIES_URL = "/api/breed/husky/images"
private const val BREED_LIST_URL = "api/breeds/list/all"
interface DogApi {
    companion object{
        operator fun invoke():DogApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DogApi::class.java)
        }
    }

    @GET(HOME_IMAGE_URL)
    fun getHomeImage():Call<HomeDogImage>

    @GET(RANDOM_IMAGES_URL)
    fun getRandomImages():Call<RandomImageListModel>

    @GET(HUSKIES_URL)
    fun getHuskiesImages():Call<DogImageListModel>

    @GET(BREED_LIST_URL)
    fun getBreedList():Call<BreedListModel>

}