package com.example.carcards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.carcards.databinding.FragmentGameBinding

class GameRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<FragmentGame> = ArrayList()

    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false)
        )
        return
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){

            is GameViewHolder ->{
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class GameViewHolder constructor(val binding: FragmentGameBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: )
    }

}