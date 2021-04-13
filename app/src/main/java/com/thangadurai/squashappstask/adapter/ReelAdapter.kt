package com.thangadurai.squashappstask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thangadurai.squashappstask.R
import com.thangadurai.squashappstask.databinding.LayoutReelsBinding
import com.thangadurai.squashappstask.models.ReelModel

class ReelAdapter(var context: Context, var listOfReels: List<ReelModel>) :
    RecyclerView.Adapter<ReelAdapter.ReelViewHolder>() {

    class ReelViewHolder(val binding: LayoutReelsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelViewHolder {
        return ReelViewHolder(
            LayoutReelsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReelViewHolder, position: Int) {
        holder.binding.ivImage.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.tony_stark
            )
        )
        holder.binding.tvViews.text = listOfReels[position].views
    }

    override fun getItemCount(): Int {
        return listOfReels.size
    }
}