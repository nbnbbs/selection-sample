package com.sample.ar442.selection.words

import androidx.recyclerview.selection.ItemKeyProvider
import com.sample.ar442.selection.models.Word

class WordKeyProvider(
        private val items: List<Word>
) : ItemKeyProvider<Word>(ItemKeyProvider.SCOPE_CACHED) {

    override fun getKey(position: Int) = items.getOrNull(position)

    override fun getPosition(key: Word) = items.indexOf(key)

}