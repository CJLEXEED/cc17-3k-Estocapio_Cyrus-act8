package com.yourappname.bookshelf

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String
    ): Response<BookResponse>
}
