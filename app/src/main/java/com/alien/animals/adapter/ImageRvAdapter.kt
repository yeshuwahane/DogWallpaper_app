package com.alien.animals.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alien.animals.R
import com.alien.animals.model.RandomImageListModel
import com.alien.animals.view.WallpaperActivity

class ImageRvAdapter(val context : Context): RecyclerView.Adapter<ImageRvAdapter.MyViewholder>() {


    val mainContext = context
    var data: List<String> = arrayListOf()
    fun setDogImages(data: List<String>){
        this.data = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.image_list_itemview,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.dogImage.load(data[position])
        holder.dogImage.setOnClickListener {
//            Toast.makeText(mainContext, "Image ${data[position]}", Toast.LENGTH_SHORT).show()
            val intent = Intent(mainContext,WallpaperActivity::class.java)
            intent.putExtra("url",data[position])
            mainContext.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return  data.size
    }

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var dogImage = itemView.findViewById<ImageView>(R.id.iv_dogImage)

    }
}