package kr.ac.hallym.mobileproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import kr.ac.hallym.mobileproject.databinding.ActivitySplashBinding
import kotlin.random.Random

// 메인 전 스플래쉬 액티비티
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val splashImage = binding.splashImage as LottieAnimationView
        splashImage.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, CardViewActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000L + Random.nextLong(3000))
    }
}