package kr.ac.hallym.mobileproject

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.mobileproject.databinding.ActivityMainBinding

// INFO 전체 액티비티
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents = mutableListOf<String>("IT TimeLine", "Activities", "STEP BY STEP")

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = MyFragmentPagerAdapter(this)
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

class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}