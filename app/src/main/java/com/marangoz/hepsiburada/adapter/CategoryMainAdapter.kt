package com.marangoz.hepsiburada.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.model.CategoryMain
import java.util.logging.Handler

class CategoryMainAdapter(val mContext: Context
                            ,private val adapterPosition : (Int) -> Unit
                            ,private val categorySub : (Int) -> Unit):
    RecyclerView.Adapter<CategoryMainAdapter.ViewHolderClass>() {

    var categoryMainList: List<CategoryMain> = listOf()

    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val mainCard: CardView
        val cardImage: ImageView
        val mainText: TextView
        val colorCard: CardView


        init {
            mainCard = view.findViewById(R.id.mainCard)
            cardImage = view.findViewById(R.id.cardImage)
            mainText = view.findViewById(R.id.mainText)
            colorCard = view.findViewById(R.id.colorCard)

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CategoryMain>) {
        categoryMainList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.main_category_design, parent, false)

        return ViewHolderClass(design)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val categoryMain = categoryMainList[position]

        holder.mainText.text = categoryMain.categoryName
        holder.cardImage.setImageResource(categoryMain.categoryPhoto)

        if (categoryMain.isSelected) {
            holder.colorCard.visibility = View.VISIBLE
            holder.mainText.setTextColor(ContextCompat.getColor(mContext, R.color.orange))
        } else {
            holder.colorCard.visibility = View.INVISIBLE
            holder.mainText.setTextColor(ContextCompat.getColor(mContext, R.color.blacklow))
        }

        holder.mainCard.setOnClickListener {
            categoryMainList.forEachIndexed { index, categoryMain ->
                if (index != position && categoryMain.isSelected) {
                    categoryMain.isSelected = false
                    notifyItemChanged(index)
                }
            }
            adapterPosition(position)
            categoryMainList[position].isSelected =  true
            notifyItemChanged(position)
            categorySub(categoryMain.categoryMain_id)

        }


    }


    override fun getItemCount(): Int {
        return categoryMainList.size
    }
}