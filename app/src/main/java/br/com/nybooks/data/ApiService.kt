package br.com.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiService {

    private fun initRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/books/v3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val services:NytServices = initRetrofit().create(NytServices::class.java)
}