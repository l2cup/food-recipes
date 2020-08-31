package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
