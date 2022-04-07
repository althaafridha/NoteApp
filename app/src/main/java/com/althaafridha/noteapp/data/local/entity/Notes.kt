package com.althaafridha.noteapp.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_notes")
@Parcelize
data class Notes (
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	val title : String,
	val desc: String,
	val date : String,
	val priority : Priority
): Parcelable