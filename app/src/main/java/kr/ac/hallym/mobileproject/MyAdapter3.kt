package kr.ac.hallym.mobileproject

import kr.ac.hallym.mobileproject.databinding.ItemFragment2Binding
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

// INFO 2번째 페이지 액티비티 연결
class MyAdapter3(val fragmentsArray: MutableList<FgContents2>): RecyclerView.Adapter<MyAdapter3.ViewHolder3>() {
    inner class ViewHolder3(val binding: ItemFragment2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : FgContents2){
            binding.imageView.setImageResource(content.image)
            binding.titleText.text = content.title
            binding.detailText.text = content.detail

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter3.ViewHolder3 {
        return ViewHolder3(
            ItemFragment2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        holder.bind(fragmentsArray[position])
    }

    override fun getItemCount(): Int {
        return fragmentsArray?.size
    }
}

class MyDecoration3(val context: Context): RecyclerView.ItemDecoration() {
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