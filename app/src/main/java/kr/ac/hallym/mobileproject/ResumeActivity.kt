package kr.ac.hallym.mobileproject

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.mobileproject.databinding.ActivityResumeBinding

// RESUME 전체 액티비티
class ResumeActivity : AppCompatActivity() {
    lateinit var binding: ActivityResumeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_resume)
        binding = ActivityResumeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents = mutableListOf<String>("Skills", "Projects", "Reward")

        val adapter = MyFragmentPagerAdapter2(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = contents[position]
        }.attach()

        val toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened,
            R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.profile) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (it.itemId == R.id.home_btn) {
                val intent = Intent(this, CardViewActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (it.itemId == R.id.exit) {
                finish()
            }
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

class MyFragmentPagerAdapter2(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(ReOneFragment(), ReTwoFragment(), ReThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}