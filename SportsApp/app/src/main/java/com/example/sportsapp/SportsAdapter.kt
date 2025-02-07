package com.example.sportsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class SportsAdapter(val sportList:ArrayList<SportModel>)
    :RecyclerView.Adapter<SportsAdapter.MyViewHolder>(){
        inner class MyViewHolder(itemView: View)
            :RecyclerView.ViewHolder(itemView){
            lateinit var itemImg:ImageView
            lateinit var itemTitle:TextView

            init {
                itemImg=itemView.findViewById(R.id.imageCardView)
                itemTitle=itemView.findViewById(R.id.titleCard)

                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "You clicked ${sportList[adapterPosition].title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemImg.setImageResource(sportList[position].sportImg)
        holder.itemTitle.setText(sportList[position].title)
    }
}