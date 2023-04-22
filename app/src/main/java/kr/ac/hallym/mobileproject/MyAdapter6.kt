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

// RESUME 2번째 페이지 액티비티 연결
class MyAdapter6(val ReTwofragmentsArray: MutableList<Recontents2>): RecyclerView.Adapter<MyAdapter6.ViewHolder6>() {
    inner class ViewHolder6(val binding: ItemResume2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : Recontents2){
            binding.imageView.setImageResource(content.image)
            binding.titleText.text = content.title
            binding.toolText.text = content.tool
            binding.detailText.text = content.detail

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter6.ViewHolder6 {
        return ViewHolder6(
            ItemResume2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter6.ViewHolder6, position: Int) {
        holder.bind(ReTwofragmentsArray[position])
    }

    override fun getItemCount(): Int {
        return ReTwofragmentsArray?.size
    }
}

class MyDecoration6(val context: Context): RecyclerView.ItemDecoration() {
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