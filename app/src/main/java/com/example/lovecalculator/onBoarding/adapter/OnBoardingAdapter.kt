package com.example.lovecalculator.onBoarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemBoardingBinding
import com.example.lovecalculator.model.OnBoard
import com.example.lovecalculator.onBoarding.OnBoardingFragment

class OnBoardingAdapter(
    private val onClick: () -> Unit,
    private val context: Context
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {


    private val list = arrayListOf(
        OnBoard(R.raw.love_animation_one, "Have a Good time"),
        OnBoard(R.raw.love_animation_two, "Cherishing love"),
        OnBoard(R.raw.love_animation_three, "Have a breakup?"),
        OnBoard(R.raw.love_animation_four, "Test your love")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.ivBoarding.setAnimation(onBoard.animation!!)
            if (adapterPosition == list.lastIndex) {
                binding.tvSkip.text = context.getString(R.string.next)
            } else binding.tvSkip.text = context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }

    }
}