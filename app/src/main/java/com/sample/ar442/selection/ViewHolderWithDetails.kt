package com.sample.ar442.selection

import androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails

interface ViewHolderWithDetails<TItem> {

    fun getItemDetail(): ItemDetails<TItem>

}