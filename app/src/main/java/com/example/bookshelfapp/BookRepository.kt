package com.yourappname.bookshelf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BookRepository(private val api: GoogleBooksApi) {

    private val _books = MutableLiveData<List<BookItem>>()
    val books: LiveData<List<BookItem>> get() = _books

    suspend fun fetchBooks(query: String) {
        val response = api.getBooks(query)
        if (response.isSuccessful) {
            _books.postValue(response.body()?.items ?: emptyList())
        }
    }
}
