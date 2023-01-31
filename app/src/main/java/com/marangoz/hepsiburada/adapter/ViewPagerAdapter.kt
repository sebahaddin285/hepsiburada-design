package com.marangoz.hepsiburada.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.marangoz.hepsiburada.R

class ViewPagerAdapter(val images : List<Int>,val mContext: Context) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolderClass>()  {

    inner class ViewPagerViewHolderClass(view: View) : RecyclerView.ViewHolder(view){
        val viewPagerFoto : ImageView
        val counterText : TextView
        init {
            viewPagerFoto = view.findViewById(R.id.viewPagerFoto)
            counterText = view.findViewById(R.id.counterText)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolderClass {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolderClass(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewPagerViewHolderClass, position: Int) {
        val image = images[position]
        holder.viewPagerFoto.setImageResource(image)
        holder.counterText.setText("${position+1}/${images.size}")
    }

    override fun getItemCount(): Int {
        return images.size
    }

}