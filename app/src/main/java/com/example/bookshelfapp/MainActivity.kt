package com.yourappname.bookshelfapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.yourappname.bookshelf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val booksViewModel: BooksViewModel by viewModels {
        BooksViewModelFactory(BookRepository(RetrofitInstance.api))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BooksAdapter(emptyList())
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        booksViewModel.books.observe(this, Observer { books ->
            (binding.recyclerView.adapter as BooksAdapter).apply {
                notifyDataSetChanged()
            }
        })

        booksViewModel.loadBooks("android development")
    }
}
