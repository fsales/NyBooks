package br.com.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nybooks.data.ApiService
import br.com.nybooks.data.model.Book
import br.com.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {

        ApiService.services.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResult) {

                            val bookDetail = result.bookDetails[0]
                            val book = Book(
                                title = bookDetail.title,
                                author = bookDetail.author,
                                description = bookDetail.description
                            )
                            books.add(book)
                        }
                    }

                    booksLiveData.value = books
                }
            }
        })

    }
}