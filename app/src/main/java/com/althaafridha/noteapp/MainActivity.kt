package com.althaafridha.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// menghapus item2 dibawah action bar
		//supportActionBar?.elevation = 0f
	}

	override fun onSupportNavigateUp(): Boolean {
		val navController = findNavController(R.id.nav_host_fragment_container)
		return super.onSupportNavigateUp() || navController.navigateUp()
	}
}