package com.example.twowaydatabindingdemo.repository

import com.example.twowaydatabindingdemo.retrofitApicode.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}