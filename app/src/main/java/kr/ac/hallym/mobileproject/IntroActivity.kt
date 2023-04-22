package kr.ac.hallym.mobileproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView

import com.bumptech.glide.Glide
import kr.ac.hallym.mobileproject.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = findViewById<ImageView>(R.id.startImage)

        Glide.with(this).load(R.drawable.giphy_black).into(imageView)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                val intent = Intent(this, SplashActivity::class.java)
                startActivity(intent)
                finish()
            }
            MotionEvent.ACTION_UP -> {
                val intent = Intent(this, SplashActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onTouchEvent(event)
    }
}