package com.example.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lovecalculator.databinding.ItemBoardingBinding
import com.example.lovecalculator.model.OnBoard
import com.google.gson.annotations.Until

class OnBoardingAdapter(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {


    private val list = arrayListOf(
        OnBoard("", "Have a Good time"),
        OnBoard("", "Cherishing love"),
        OnBoard("", "Have a breakup?"),
        OnBoard("", "Test your love")
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
            binding.ivBoarding.load(onBoard.image)
            binding.tvSkip.setOnClickListener{
                onClick()
            }
        }

    }
}