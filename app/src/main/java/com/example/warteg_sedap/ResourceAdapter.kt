package com.example.warteg_sedap

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ResourceAdapter (val arrayList: ArrayList<ResourceModel>,
                       val context : Context):
    RecyclerView.Adapter<ResourceAdapter.ViewHolder>(){

    class ViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){
        fun bindItems (model : ResourceModel) {
            itemView.judulresource.text = model.nmResource
            itemView.imgresource.setImageResource(model.imgResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return arrayList.size
    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindItems(arrayList[position])
//
//        holder.itemView.setOnClickListener(){
//            val model = arrayList.get(position)
//
//            var gsepatu : String = model.nmsepatu
//            var gImg    : Int    = model.imagesepatu
//
//            val intent = Intent(context, OrderActivity::class.java)
//            intent.putExtra("pSepatu", gsepatu)
//            intent.putExtra("pImg", gImg)
//
//            context.startActivity(intent)
//        }
//    }
}