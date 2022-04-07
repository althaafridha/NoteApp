package com.althaafridha.noteapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.noteapp.data.local.entity.Notes
import com.althaafridha.noteapp.databinding.RowItemNotesBinding

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

	var listNotes = ArrayList<Notes>()

	inner class MyViewHolder(val binding: RowItemNotesBinding) :
		RecyclerView.ViewHolder(binding.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
		RowItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)


	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val data = listNotes[position]
		holder.binding.apply {
			mNotes = data
			executePendingBindings()
		}
	}

	override fun getItemCount(): Int = listNotes.size

	fun setData(data: List<Notes>?) {
		if (data == null) return
		val diffCalback = DiffCallback(listNotes, data)
		val diffResult = DiffUtil.calculateDiff(diffCalback)
		listNotes.clear()
		listNotes.addAll(data)
		diffResult.dispatchUpdatesTo(this)
	}
}