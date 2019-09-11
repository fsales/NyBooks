package br.com.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.nybooks.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toobarMain.title =getString(R.string.books_title)
        setSupportActionBar(toobarMain)
    }
}
