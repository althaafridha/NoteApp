package com.althaafridha.noteapp.ui.detail

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.althaafridha.noteapp.R
import com.althaafridha.noteapp.databinding.FragmentDetailBinding
import com.althaafridha.noteapp.ui.NotesViewModel
import com.althaafridha.noteapp.utils.ExtentionFunctions.setActionBar

class DetailFragment : Fragment() {

	private var _binding: FragmentDetailBinding? = null
	private val binding get() = _binding as FragmentDetailBinding

	private val args by navArgs<DetailFragmentArgs>()

	private val detailViewModel by viewModels<NotesViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		_binding = FragmentDetailBinding.inflate(layoutInflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setHasOptionsMenu(true)

		binding.toolbarDetail.setActionBar(requireActivity())
		binding.detailArgs = args

		Log.d("detail_title", args.notes.title)
	}

	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.menu_detail, menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when(item.itemId){
			R.id.menu_edit -> {
				val action = DetailFragmentDirections.actionDetailFragmentToUpdateFragment(args.notes)
				findNavController().navigate(action)
			}
			R.id.menu_delete -> confirmDeleteNote()
		}
		return super.onOptionsItemSelected(item)
	}

	private fun confirmDeleteNote() {
		AlertDialog.Builder(context)
			.setTitle("Delete '${args.notes.title}'?")
			.setMessage("Are you sure want to remove this note?")
			.setPositiveButton("Yes"){ _, _ ->
				detailViewModel.deleteNote(args.notes)
				Toast.makeText(context, "Succesfully deleted note", Toast.LENGTH_SHORT).show()
				findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
			}
			.setNegativeButton("No"){ _, _ -> }
			/**
			 * buat button di paling kiri
			 *
			 *  .setNeutralButton("Cancel"){ _, _ ->}
			 */
			.show()
	}


	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}