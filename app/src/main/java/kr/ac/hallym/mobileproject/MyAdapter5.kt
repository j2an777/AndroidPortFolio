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
import kr.ac.hallym.mobileproject.databinding.ItemResume1Binding

// RESUME 1번째 페이지 액티비티 연결
class MyAdapter5(val ReOnefragmentsArray: MutableList<Recontents1>): RecyclerView.Adapter<MyAdapter5.ViewHolder5>() {
    inner class ViewHolder5(val binding: ItemResume1Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : Recontents1){
            binding.imageView.setImageResource(content.image)
            binding.titleText.text = content.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter5.ViewHolder5 {
        return ViewHolder5(
            ItemResume1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter5.ViewHolder5, position: Int) {
        holder.bind(ReOnefragmentsArray[position])
    }

    override fun getItemCount(): Int {
        return ReOnefragmentsArray?.size
    }
}

class MyDecoration5(val context: Context): RecyclerView.ItemDecoration() {
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