package com.alien.animals.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alien.animals.R
import com.alien.animals.model.BreedListModel
import com.alien.animals.view.ImageListActivity

class ListRvAdapter(val context : Context): RecyclerView.Adapter<ListRvAdapter.MyViewholder>() {

    val mainContext = context
    var data: List<String> = arrayListOf()
    fun setBreedList(data: List<String>){
        this.data = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.breed_list_layout,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.breedName.text = data[position]
        holder.breedCard.setOnClickListener {
            val intent = Intent(mainContext,ImageListActivity::class.java)
            intent.putExtra("dog",data[position])
            Log.d("alien",data[position])
            mainContext.startActivity(intent)
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