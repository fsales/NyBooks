package br.com.nybooks.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nybooks.data.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks()
    }

    fun createFakeBooks() = listOf<Book>(
        Book(title = "Texte", author = "Fábio"),
        Book(title = "Texte2", author = "Fábio")
    )
}