package com.althaafridha.noteapp.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.althaafridha.noteapp.MainActivity
import com.althaafridha.noteapp.R

class SplashScreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)
		supportActionBar?.hide()

		Handler(Looper.getMainLooper()).postDelayed({
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
		}, 2000)
	}
}