package br.com.nybooks.data.response

import br.com.nybooks.data.model.Book
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "description")
    val description: String
){
    fun getBookMode() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}