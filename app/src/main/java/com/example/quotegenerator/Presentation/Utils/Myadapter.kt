package com.example.quotegenerator.Presentation.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotegenerator.R
import com.google.android.material.imageview.ShapeableImageView

class Myadapter(private val newsList:ArrayList<NewsInfo>): RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun onItemSetClickListener(listener: onItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
         holder.titleImage.setImageResource(currentItem.titleImage)
        holder.titleHeading.text = currentItem.titleHeadline
    }
    class MyViewHolder(itemView:View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val titleImage:ShapeableImageView = itemView.findViewById(R.id.titleImage)
        val titleHeading:TextView = itemView.findViewById(R.id.Tvheading)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(position = adapterPosition)
            }
        }
    }
}