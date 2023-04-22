package kr.ac.hallym.mobileproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileproject.databinding.FragmentOneBinding
import kr.ac.hallym.mobileproject.databinding.FragmentThreeBinding
import kr.ac.hallym.mobileproject.databinding.FragmentTwoBinding

// INFO 3페이지 액티비티
class ThreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentThreeBinding.inflate(inflater, container, false)

        var tfArray2 = mutableListOf<FgContents2>(
            FgContents2(R.drawable.contact_5, "1.서비스 경험의 Point ↑","다양한 서비스에 대해 고객에 대한 Pain Point를 다양한 방법으로 분석하여 어느 분야에든 완성도 높은 솔루션 제공하도록 노력하겠습니다."),
            FgContents2(R.drawable.contact_7, "2. 넓은 시각에 빗대어 보는 Design Sensity ↑","보이는게 다가 아닌 새로운 UI패턴, 트랜드에 민감하게 반응하여 혁신적이고, 돋보적인 디자인을 만들 수 있도록 기회의 장에 바로 도전하겠습니다."),
            FgContents2(R.drawable.contact_9, "3. 종합적 능력을 통한 Branding","다양한 경험과 학습을 통해 자신만의 세계를 구축하여 이를 통한 나만의 브랜드(World)를 설계하는 것이 목표입니다.")
        )


        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter4(tfArray2)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration3(activity as Context))

        return binding.root
    }
}