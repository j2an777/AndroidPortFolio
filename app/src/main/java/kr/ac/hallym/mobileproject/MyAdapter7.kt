package kr.ac.hallym.mobileproject


import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.ItemResume2Binding
import kr.ac.hallym.mobileproject.databinding.ItemResume3Binding

// RESUME 3번째 페이지 액티비티 연결
class MyAdapter7(val ReThreefragmentsArray: MutableList<Recontents3>): RecyclerView.Adapter<MyAdapter7.ViewHolder7>() {
    inner class ViewHolder7(val binding: ItemResume3Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : Recontents3){
            binding.imageView.setImageResource(content.image)
            binding.titleText.text = content.title
            binding.toolText.text = content.tool
            binding.detailText.text = content.detail

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter7.ViewHolder7 {
        return ViewHolder7(
            ItemResume3Binding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter7.ViewHolder7, position: Int) {
        holder.bind(ReThreefragmentsArray[position])
    }

    override fun getItemCount(): Int {
        return ReThreefragmentsArray?.size
    }
}

class MyDecoration7(val context: Context): RecyclerView.ItemDecoration() {
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