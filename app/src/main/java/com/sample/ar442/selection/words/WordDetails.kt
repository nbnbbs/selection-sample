package com.sample.ar442.selection.words

import androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails
import com.sample.ar442.selection.models.Word

class WordDetails(private val adapterPosition: Int, private val selectedKey: Word?) : ItemDetails<Word>() {

    override fun getSelectionKey() = selectedKey

    override fun getPosition() = adapterPosition

}