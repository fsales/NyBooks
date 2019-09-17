package br.com.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nybooks.R
import br.com.nybooks.data.ApiService
import br.com.nybooks.data.model.Book
import br.com.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks() {

        ApiService.services.getBooks().enqueue(object : Callback<BookBodyResponse> {


            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResult) {

                                val bookDetail = result.bookDetails[0]
                                books.add(bookDetail.getBookMode())
                            }
                        }

                        booksLiveData.value = books
                        viewFlipperLiveData.value = Pair(VIEW_FLIPE_BOOKS, null)
                    }
                    response.code() == 401 -> viewFlipperLiveData.value =
                        Pair(VIEW_FLIPE_ERROR, R.string.books_error_401)
                    else -> viewFlipperLiveData.value =
                        Pair(VIEW_FLIPE_ERROR, R.string.books_error_400_generic)
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPE_ERROR, R.string.books_error_500_generic)
            }
        })


    }

    companion object {
        private const val VIEW_FLIPE_BOOKS = 1
        private const val VIEW_FLIPE_ERROR = 2
    }
}