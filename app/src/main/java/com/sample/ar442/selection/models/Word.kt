package com.sample.ar442.selection.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(val id: Int, val text: String) : Parcelable