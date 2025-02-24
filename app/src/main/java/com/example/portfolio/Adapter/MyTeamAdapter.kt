package com.example.portfolio.Adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.Domain.TeamDomain
import com.example.portfolio.R
import com.example.portfolio.databinding.ViewholderMyTeamBinding
import com.example.portfolio.databinding.ViewholderOngoingBinding

class MyTeamAdapter(private val items: List<TeamDomain>) :RecyclerView.Adapter<MyTeamAdapter.ViewHolder>() {

    var selectedPosition = RecyclerView.NO_POSITION

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ViewholderMyTeamBinding.bind(itemView)

        fun setTextColor(colorRes: Int) {
            binding.titleTxt.setTextColor(itemView.context.getColor(colorRes))
            binding.statusTxt.setTextColor(itemView.context.getColor(colorRes))
            binding.imageView5.setColorFilter(ContextCompat.getColor(itemView.context, colorRes), PorterDuff.Mode.SRC_IN)

        }


        fun setDarkTextColor() {
            binding.constLayout.setBackgroundResource(R.drawable.dark_bg)
            setTextColor(R.color.white)
        }

        fun setLightTextColor() {
            binding.constLayout.setBackgroundResource(R.drawable.light_purple_background)
            setTextColor(R.color.dark_purple)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_my_team, parent, false)

        return ViewHolder(view)


    }


    override fun getItemCount(): Int {
        return items.size

    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.titleTxt.text = item.title
        holder.binding.statusTxt.text = item.status

        if (selectedPosition == position){
            holder.setDarkTextColor()
        } else {
            holder.setLightTextColor()
        }


        holder.binding.constLayout.setOnClickListener{
        val previousPosition = selectedPosition
        selectedPosition = position

        notifyItemChanged(previousPosition)
        notifyItemChanged(selectedPosition)

    }
        }
}