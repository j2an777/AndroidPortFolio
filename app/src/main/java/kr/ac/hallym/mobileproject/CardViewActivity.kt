package kr.ac.hallym.mobileproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileproject.databinding.ActivityCardViewBinding

// MAIN 선택 카드뷰 액티비티
class CardViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_card_view)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var ctArray = mutableListOf<Contents>(
            Contents(R.drawable.me5, "My Info","Show? Click"),
            Contents(R.drawable.resume, "My Resume","More? Click"),
            Contents(R.drawable.diary, "Free Board","Want? Click")
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(ctArray) { content ->
            if (content.image === R.drawable.me5) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (content.image === R.drawable.resume) {
                val intent = Intent(this, ResumeActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (content.image === R.drawable.diary) {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }
}