package com.marangoz.hepsiburada.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.model.CategorySub
import com.marangoz.hepsiburada.model.CategorySubElemans

class NestedSubAdapter(val listSub:List<CategorySubElemans>) : RecyclerView.Adapter<NestedSubAdapter.ViewHolderClass>(){

    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val categorySubImage: ImageView
        val titleText: TextView

        init {
            titleText = view.findViewById(R.id.titleText)
            categorySubImage = view.findViewById(R.id.categorySubImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.main_category_sub_eleman_design, parent, false)
        return ViewHolderClass(design)
    }

    override fun getItemCount(): Int {

       return listSub.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
       val elamans = listSub[position]
        holder.titleText.setText(elamans.categoryElamansName)
        holder.categorySubImage.setImageResource(elamans.categoryElemansPhoto)
    }




}