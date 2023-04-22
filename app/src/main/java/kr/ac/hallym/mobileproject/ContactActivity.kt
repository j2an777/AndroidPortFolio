package kr.ac.hallym.mobileproject

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.ActivityContactBinding

// 자유게시판 시작 화면
class ContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    lateinit var adapter : FMyAdapter
    var contents: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_contact)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            it.data!!.getStringExtra("result")?.let {
                contents?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        contents = mutableListOf<String>()

        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB", null)
        cursor.run {
            while(moveToNext()) {
                contents?.add(cursor.getString(1))
            }
        }
        db.close()

        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = FMyAdapter(contents)
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
        binding.mainRecyclerView.addItemDecoration(FrMyDecoration(this))

        val toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened,
            R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView3.setNavigationItemSelectedListener {
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
        menuInflater.inflate(R.menu.menu_rmain, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_main_setting) {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}

class FrMyDecoration(val context: ContactActivity): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.logo),
            0f, 0f,null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,

        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        ViewCompat.setElevation(view, 20.0f)
    }
}