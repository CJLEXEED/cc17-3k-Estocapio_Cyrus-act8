package com.yourappname.bookshelf

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BookRepository) : ViewModel() {

    val books: LiveData<List<BookItem>> = repository.books

    fun loadBooks(query: String) {
        viewModelScope.launch {
            repository.fetchBooks(query)
        }
    }
}
