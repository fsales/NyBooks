package br.com.nybooks.data

import br.com.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NytServices {

    @GET("lists.json")
    fun getBooks(
        @Query(value = "api-key") apiKey: String = "ihYMCo0wSptVfY1gQn9NatthTyRWqFIT        ",
        @Query(value = "list") list: String = "hardcover-fiction"

    ): Call<BookBodyResponse>
}