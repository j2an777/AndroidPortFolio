package kr.ac.hallym.mobileproject

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Point
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
import kr.ac.hallym.mobileproject.databinding.FragmentReTwoBinding

// RESUME의 3번째 페이지
class ReThreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReTwoBinding.inflate(inflater, container, false)

        var R3Array = mutableListOf<Recontents3>(
            Recontents3(R.drawable.reward, "디지털인문예술 주관 전시회 대상", "'HIBRARY'", "한림대학교 도서관 내 전자정보실 리모델링 관련으로 학생들의 많은 이용을 위한 기존 도서관 Pain Point 분석 및 문제정의로 <br>새로운 서비스 Ideation한 기획서 제작")
        )


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter7(R3Array)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(ReMyDecoration3(this))

        return binding.root
    }
}

class ReMyDecoration3(val context: ReThreeFragment): RecyclerView.ItemDecoration() {
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