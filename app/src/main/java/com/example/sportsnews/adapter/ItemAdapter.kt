package com.example.sportsnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.R
import com.example.sportsnews.model.News

class ItemAdapter(
  private val context: Context,
  private val dataset: List<News>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

  class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.findViewById(R.id.imageView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.sports_item, parent, false)

    return ItemViewHolder(adapterLayout)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = dataset[position]
    holder.imageView.setImageResource(item.imageId)
  }

  override fun getItemCount() = dataset.size
}