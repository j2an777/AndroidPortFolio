package kr.ac.hallym.mobileproject

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.FragmentReOneBinding

// RESUME의 1번째 페이지
class ReOneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReOneBinding.inflate(inflater, container, false)

        var R1Array = mutableListOf<Recontents1>(
            Recontents1(R.drawable.html, "Html"),
            Recontents1(R.drawable.css, "Css"),
            Recontents1(R.drawable.javascript, "Javascript"),
            Recontents1(R.drawable.jquery, "Jquery"),
            Recontents1(R.drawable.atom, "React"),
            Recontents1(R.drawable.java, "Java"),
            Recontents1(R.drawable.python, "Python"),
            Recontents1(R.drawable.android, "AndroidStudio"),
            Recontents1(R.drawable.figma, "Figma"),
            Recontents1(R.drawable.canvas, "MiriCanvas"),
            Recontents1(R.drawable.sql, "MySql")
        )


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter5(R1Array)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(MyDecoration(this))

        return binding.root
    }
}

class MyDecoration(val context: ReOneFragment): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.contact_10),
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