package com.marangoz.hepsiburada.adapter

import android.content.Context
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.model.CategorySub
import com.marangoz.hepsiburada.model.CategorySubElemans

class CategoryMainSubAdapter(var mContext: Context) : RecyclerView.Adapter<CategoryMainSubAdapter.GroupViewHolder>() {
    var list: List<CategorySub> = ArrayList()

    inner class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val childNameText: TextView
        val expendButton: ImageView
        val closeButton: ImageView
        val subRecyclerView : RecyclerView

        init {
            childNameText = view.findViewById(R.id.childNameText)
            expendButton = view.findViewById(R.id.expendButton)
            closeButton = view.findViewById(R.id.closeButton)
            subRecyclerView = view.findViewById(R.id.subRecyclerView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.main_category_sub_desing, parent, false)

        return GroupViewHolder(design)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val categorySub = list[position]
        val categoryElemans = categorySub.categoryElamansList

        holder.childNameText.setText(categorySub.categorySubName)

        if (categorySub.isExpandable){
            holder.childNameText.textSize = 14F
            holder.expendButton.visibility = View.GONE
            holder.closeButton.visibility = View.VISIBLE
            holder.subRecyclerView.visibility = View.VISIBLE
        }
        else{
            holder.childNameText.textSize = 12F
            holder.expendButton.visibility = View.VISIBLE
            holder.closeButton.visibility = View.GONE
            holder.subRecyclerView.visibility = View.GONE
        }

        val adapterr = NestedSubAdapter(categoryElemans)
        holder.subRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        holder.subRecyclerView.setHasFixedSize(true)
        holder.subRecyclerView.adapter = adapterr

        holder.expendButton.setOnClickListener(){
            list.forEachIndexed { index, mainSub ->
                if (index != position && mainSub.isExpandable) {
                    mainSub.isExpandable = false
                    notifyItemChanged(index)
                }
            }
            categorySub.isExpandable = true
            notifyItemChanged(position)
        }
        holder.closeButton.setOnClickListener(){
            categorySub.isExpandable = false
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setLists(newList : List<CategorySub>){
        list = newList
        notifyDataSetChanged()
    }


}