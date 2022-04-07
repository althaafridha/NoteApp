package com.althaafridha.noteapp.utils

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.althaafridha.noteapp.MainActivity
import com.althaafridha.noteapp.R
import com.google.android.material.appbar.MaterialToolbar

object ExtentionFunctions {
	fun MaterialToolbar.setActionBar(requireActivity: FragmentActivity) {
		val navController = findNavController()
		val appConfiguration = AppBarConfiguration(navController.graph)
		setupWithNavController(navController, appConfiguration)
		(requireActivity as MainActivity).setSupportActionBar(this)
		navController.addOnDestinationChangedListener { _, destination, _ ->
			when (destination.id) {
				R.id.updateFragment -> this.setNavigationIcon(R.drawable.ic_left_arrow)
				R.id.addFragment -> this.setNavigationIcon(R.drawable.ic_left_arrow)
				R.id.detailFragment -> this.setNavigationIcon(R.drawable.ic_left_arrow)
			}
		}
	}
}