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

// RESUME의 2번째 페이지
class ReTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReTwoBinding.inflate(inflater, container, false)

        var R2Array = mutableListOf<Recontents2>(
            Recontents2(R.drawable.project1, "Graphics활용한 미니게임", "Html, Css, JavaScript", "Javascript를 이용해 Graphics 구현하여 미니 공포게임을 간단하게 제작"),
            Recontents2(R.drawable.project2, "춘천 시장 종합 사이트 제작", "Html, Css, JavaScript,Express", "교내 웹 개발 해커톤(8시간) 대회로 춘천 시장들을 홍보 및 새로운 서비스 제작 위해 종합 사이트 구현"),
            Recontents2(R.drawable.project3, "'Re Aerang'행사 기념SW전시회 사이트 제작", "Html, Css, JavaScript, Jquery, Node.js, MongoDB ETC", "동아리 '씨애랑'에서 30주년 기념 행사로 부원들의 전시회 작품을 사이트로 전시 가능하도록 사이트 제작 각 작품에 좋아요 및 댓글 등 여러 기능 구현"),
            Recontents2(R.drawable.project4, "디지털인문예술 전시회 관련 서비스 구현 및 사이트 제작", "Figma, CreatorLinkSite", "교내 디지털인문예술전공 주관 전시회로 도서관에 대한 학생들의 Needs 분석과 경험에 의한 Pain Point 분석으로 새로운 서비스 Ideation 및 전시용 사이트 제작"),
            Recontents2(R.drawable.project5, "포트폴리오 사이트 제작", "Html, Css, JavaScript, Jquery", "기본 Html 웹 역량으로 자신의 포트폴리오 사이트를 제작")
        )


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter6(R2Array)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(ReMyDecoration2(this))

        return binding.root
    }
}

class ReMyDecoration2(val context: ReTwoFragment): RecyclerView.ItemDecoration() {
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