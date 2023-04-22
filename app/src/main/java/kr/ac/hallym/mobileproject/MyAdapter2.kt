package kr.ac.hallym.mobileproject

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.ItemRecyclerviewBinding

// INFO 1번째 페이지 액티비티 연결
class MyViewHolder2(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter2(val mainContents: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder2(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder2).binding
        binding.itemData.text = mainContents[position]
    }

    override fun getItemCount(): Int {
        return mainContents.size
    }
}

class MyDecoration2(val context: Context): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1
        outRect.set(10, 10, 10, 0)

        view.setBackgroundColor(Color.parseColor("#000000"))
        ViewCompat.setElevation(view, 20.0f)
    }
}