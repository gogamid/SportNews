package com.example.sportsnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.R
import com.example.sportsnews.model.News

class ItemAdapter(
  private val context: Context,
  private val dataset: List<News>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

  class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.findViewById(R.id.imageView)
    val title: TextView = view.findViewById(R.id.title_tv)
    val content: TextView = view.findViewById(R.id.content_tv)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.sports_item, parent, false)

    return ItemViewHolder(adapterLayout)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = dataset[position]
    holder.imageView.setImageResource(item.imageId)
    holder.title.text = item.title
    holder.content.text = item.content
  }

  override fun getItemCount() = dataset.size
}