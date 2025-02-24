package com.example.portfolio.Adapter

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.portfolio.Activity.ProfileActivity
import com.example.portfolio.Domain.OngoingDomain
import com.example.portfolio.R
import com.example.portfolio.databinding.ViewholderOngoingBinding

class OnGoingAdapter (private val items : List <OngoingDomain>) : RecyclerView.Adapter<OnGoingAdapter.ViewHolder>() {

    var selectedPosition = RecyclerView.NO_POSITION

   inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {


       val binding = ViewholderOngoingBinding.bind(itemView)


       fun setTextColor (colorRes:Int) {
           binding.titleTxt.setTextColor(itemView.context.getColor(colorRes))
           binding.progressTxt .setTextColor(itemView.context.getColor(colorRes))
           binding.percentTxt.setTextColor(itemView.context.getColor(colorRes))
           binding.dateTxt.setTextColor(itemView.context.getColor(colorRes))
           binding.pic.setColorFilter(ContextCompat.getColor(itemView.context, colorRes),
               PorterDuff.Mode.SRC_IN)
           binding.progressBar.progressTintList = ColorStateList.valueOf(
               ContextCompat.getColor(itemView.context, colorRes))


       }


       fun selectColor () {
               binding.layout.setBackgroundResource(R.drawable.dark_bg)
               setTextColor(R.color.white)
           }

       fun resetColor () {
               binding.layout.setBackgroundResource(R.drawable.light_purple_background)
               setTextColor(R.color.dark_purple)
           }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_ongoing, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = items [position]
        holder.binding.titleTxt.text = item.title
        holder.binding.dateTxt.text = item.data
        holder.binding.percentTxt.text = "${item.progressPercente}%"


        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            item.picPath, "drawable", holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context).load(drawableResourceId).into(holder.binding.pic)

        holder.binding.progressBar.progress = item.progressPercente

        if (selectedPosition == position){
            holder.selectColor()
        } else {
            holder.resetColor()
        }
        
        holder.binding.layout.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)

        }
    }
}
