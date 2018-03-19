package com.sample.ar442.selection.words

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.SelectionTracker
import com.sample.ar442.selection.R
import com.sample.ar442.selection.ViewHolderWithDetails
import com.sample.ar442.selection.models.Word
import com.sample.ar442.selection.words.WordAdapter.WordViewHolder

class WordAdapter(private val items: List<Word>) : RecyclerView.Adapter<WordViewHolder>() {

    lateinit var tracker: SelectionTracker<Word>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder(
            LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_word, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, tracker.isSelected(items[position]))
    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ViewHolderWithDetails<Word> {

        private val text: TextView = itemView.findViewById(R.id.item_word_text)

        override fun getItemDetail() = WordDetails(adapterPosition, items.getOrNull(adapterPosition))

        fun bind(word: Word, isActivated: Boolean) {
            text.text = word.text
            itemView.isActivated = isActivated
        }

    }

}