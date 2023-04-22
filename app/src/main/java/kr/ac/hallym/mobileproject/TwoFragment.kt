package kr.ac.hallym.mobileproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileproject.databinding.FragmentOneBinding
import kr.ac.hallym.mobileproject.databinding.FragmentTwoBinding

// INFO 2페이지 액티비티
class TwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTwoBinding.inflate(inflater, container, false)

        var tfArray = mutableListOf<FgContents2>(
            FgContents2(R.drawable.active11, "학술 동아리(씨애랑)","1~3학년 교내 학술동아리로 전시회 2번 진행 했습니다."),
            FgContents2(R.drawable.active9, "밴드부","1~2학년 밴드부 활동 했습니다."),
            FgContents2(R.drawable.active10, "학생회","2학년 빅데이터 학생회 복지국장 활동 했습니다."),
            FgContents2(R.drawable.active12, "해부학 근로","2학년 해부학교실 근로생으로 여러 설치류 관리 및 실험보조 활동 했습니다."),
            FgContents2(R.drawable.active7, "보컬 공연","3학년 교내 보컬 동아리로 버스킹 했습니다."),
            FgContents2(R.drawable.active13, "박물관 근로","3학년 박물관 근로생으로 여러 워드프로세스 업무를 했습니다.")
        )


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter3(tfArray)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration3(activity as Context))

        return binding.root
    }
}