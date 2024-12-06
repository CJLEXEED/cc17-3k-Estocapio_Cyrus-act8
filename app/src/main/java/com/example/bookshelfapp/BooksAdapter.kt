package com.yourappname.bookshelf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yourappname.bookshelf.databinding.ItemBookBinding

class BooksAdapter(private var books: List<BookItem>) :
    RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: BookItem) {
            binding.titleTextView.text = book.volumeInfo.title
            val thumbnail = book.volumeInfo.imageLinks?.thumbnail
            if (thumbnail != null) {
                Picasso.get().load(thumbnail).into(binding.thumbnailImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}
