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
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.portfolio.Activity.EmptyActiv
import com.example.portfolio.Activity.ProfileActivity
import com.example.portfolio.Domain.OngoingDomain
import com.example.portfolio.Domain.TeamDomain
import com.example.portfolio.R
import com.example.portfolio.databinding.ViewholderArchiveBinding
import com.example.portfolio.databinding.ViewholderOngoingBinding

class ArchiveAdapter (private val items : List <String>) : RecyclerView.Adapter<ArchiveAdapter.ViewHolder>() {
   inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
       val binding = ViewholderArchiveBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_archive, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items [position]
        holder.binding.titleTxt.text = item



            holder.binding.constr.setOnClickListener{
                val intent = Intent (holder.itemView.context, EmptyActiv::class.java )
                holder.itemView.context.startActivity(intent)
        }

    }

}