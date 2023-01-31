package com.marangoz.hepsiburada.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.model.Products

class HomePageAdapter(val mContext: Context) :
    RecyclerView.Adapter<HomePageAdapter.ViewHolderClass>() {

    var productsList : List<Products> = listOf()

    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val priceText: TextView
        val nameText: TextView
        val photoView: ImageView
        val sepetButton: CardView

        init {
            priceText = view.findViewById(R.id.priceText)
            nameText = view.findViewById(R.id.nameText)
            photoView = view.findViewById(R.id.photoView)
            sepetButton = view.findViewById(R.id.sepetButton)
        }

    }

    fun setList(list: List<Products>) {
        productsList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design = LayoutInflater.from(mContext).inflate(R.layout.adapter_design, parent, false)
        return ViewHolderClass(design)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val product = productsList[position]

        holder.photoView.setImageResource(product.products_photo)
        holder.nameText.setText(product.products_name)
        holder.priceText.setText(product.products_price)
        holder.sepetButton.setOnClickListener(){

        }


    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}