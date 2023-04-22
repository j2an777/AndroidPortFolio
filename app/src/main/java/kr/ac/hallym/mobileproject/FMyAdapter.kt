package kr.ac.hallym.mobileproject

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.ReportRecyclerviewBinding

// 자유게시판 시작 화면 연결
class MyViewHolder(val binding: ReportRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)
class FMyAdapter (val contents: MutableList<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ReportRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = contents!![position]
    }

    override fun getItemCount(): Int {
        return contents?.size ?: 0
    }
}
