package kr.ac.hallym.mobileproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileproject.databinding.FragmentOneBinding

//INFO 1번째 페이지 액티비티
class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)

        val contents = mutableListOf<String>("2018.02 -> 한림대학교 컴퓨터공학과 입학",
            "2018.03 -> IT 학술동아리 '씨애랑' 입부",
            "2018.10 -> '씨애랑' SW전시회 참가",
            "2018.12 -> 'AJ네트웍스' 단기직원(2개월)",
            "2020.03 -> 군 입대(육군 병장'보급행정' 만기전역)",
            "2022.08 -> '장비지원센터' 근로생",
            "2022.10 -> 교내 웹 개발 해커톤 대회 참가",
            "2022.11 -> '씨애랑' SW전시회 참가",
            "2022.11 -> 교내 '플랫폼 디자인 취창업 프로그램' 참가",
            "2022.12 -> 디지털인문예술전공 주관 전시 공모전 '대상' 수상",
            "2022.12 -> 교내 창업동아리 'COU'팀 입부(Front - Vue.js)")


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter2(contents)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration2(activity as Context))

        return binding.root
    }
}