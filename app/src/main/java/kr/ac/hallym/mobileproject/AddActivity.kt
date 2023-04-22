package kr.ac.hallym.mobileproject

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.ActivityAddBinding

// 자유게시판 게시 등록 액티비티
class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar2
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.menu_add_save -> {
            val inputData = binding.addEditView.text.toString()
            val db = DBHelper(this).writableDatabase
            db.execSQL("insert into TODO_TB (todo) values (?)",
                arrayOf<String>(inputData))
            db.close()

            val intent = intent.putExtra("result", binding.addEditView.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
            true
        }
        android.R.id.home -> {
            startActivity(Intent(this, ContactActivity::class.java))
            true
        }
        else -> true
    }
}