package com.alien.animals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alien.animals.R
import com.alien.animals.model.BreedListModel
import com.alien.animals.model.Message

class ListRvAdapter(val context : Context): RecyclerView.Adapter<ListRvAdapter.MyViewholder>() {

    val mainContext = context
    var data: List<BreedListModel> = arrayListOf()
    fun setDogBreed(data: List<BreedListModel>){
        this.data = listOf(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.breed_list_layout,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.breedName.text = data[position].toString()
        holder.breedCard.setOnClickListener {
            Toast.makeText(mainContext, "Button", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var breedName = itemView.findViewById<TextView>(R.id.tv_breedName)
        var breedCard = itemView.findViewById<CardView>(R.id.cv_breedList)


    }
}