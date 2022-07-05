package com.example.twowaydatabindingdemo.retrofitApicode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twowaydatabindingdemo.model.Movie
import com.example.twowaydatabindingdemo.repository.MainRepository
import retrofit2.Call
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : retrofit2.Callback<List<Movie>> {
           override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }
          override  fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}