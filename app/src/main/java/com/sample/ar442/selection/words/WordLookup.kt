package com.sample.ar442.selection.words

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import com.sample.ar442.selection.ViewHolderWithDetails
import com.sample.ar442.selection.models.Word

class WordLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Word>() {

    override fun getItemDetails(e: MotionEvent) = recyclerView.findChildViewUnder(e.x, e.y)
            ?.let {
                (recyclerView.getChildViewHolder(it) as? ViewHolderWithDetails<Word>)?.getItemDetail()
            }

}