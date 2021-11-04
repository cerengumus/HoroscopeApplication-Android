package com.cerengumus.horoscopeapp

import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var context: Context,val listener : (DataModel) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var dataList = emptyList<DataModel>()


    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView


        init {
            image = itemView.findViewById(R.id.imageView)
            title = itemView.findViewById(R.id.zodiacName)




        }
        fun bindView(DATA: DataModel, listener: (DataModel) -> Unit) {
            image.setImageResource(DATA.image)
            title.text = DATA.zodiacName
            itemView.setOnClickListener { listener(DATA) }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.horoscope_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.zodiacName


        holder.image.setImageResource(data.image)
        holder.image.maxWidth = 150
        holder.bindView(data,listener)




    }


    override fun getItemCount(): Int {
        return dataList.size
    }
}