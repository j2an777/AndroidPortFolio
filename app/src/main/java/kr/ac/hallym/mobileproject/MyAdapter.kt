package kr.ac.hallym.mobileproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileproject.databinding.CardLayoutBinding
import kr.ac.hallym.mobileproject.databinding.ItemRecyclerviewBinding

// MAIN 선택 카드뷰 액티비티 연결
class MyAdapter(val contentsArray: MutableList<Contents>, val onClick: (Contents) -> (Unit)): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content: Contents){
            binding.titleText.text = content.title
            binding.imageView.setImageResource(content.image)
            binding.detailText.text = content.detail

            binding.root.setOnClickListener {
                onClick(content)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contentsArray[position])
    }

    override fun getItemCount(): Int {
        return contentsArray?.size
    }


}