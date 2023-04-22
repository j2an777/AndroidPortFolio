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
import kr.ac.hallym.mobileproject.databinding.ItemFragment3Binding

// INFO 3번째 페이지 액티비티 연결
class MyAdapter4(val fragmentsArray2: MutableList<FgContents2>): RecyclerView.Adapter<MyAdapter4.ViewHolder4>() {
    inner class ViewHolder4(val binding: ItemFragment3Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : FgContents2){
            binding.imageView.setImageResource(content.image)
            binding.titleText.text = content.title
            binding.detailText.text = content.detail

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter4.ViewHolder4 {
        return ViewHolder4(
            ItemFragment3Binding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter4.ViewHolder4, position: Int) {
        holder.bind(fragmentsArray2[position])
    }

    override fun getItemCount(): Int {
        return fragmentsArray2?.size
    }
}

class MyDecoration4(val context: Context): RecyclerView.ItemDecoration() {
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