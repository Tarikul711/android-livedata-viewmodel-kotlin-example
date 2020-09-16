package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.adapter

/**
 *Created by tarikul on 16/9/20
 */


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tos.androidlivedataviewmodel.R
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.model.PhotoModel
import kotlinx.android.synthetic.main.item_photo.view.*

/**
 *Created by tarikul on 6/9/20
 */

class PhotoAlbumAdapter(private val photoAlbums: ArrayList<PhotoModel>) :
    RecyclerView.Adapter<PhotoAlbumAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: PhotoModel) {
            itemView.apply {
                tvTitle.text = result.title
                Glide.with(ivImage.context)
                    .load(result.url)
                    .into(ivImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return photoAlbums.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(photoAlbums[position])
    }

    /*  fun addProducts(results: List<Results>) {
          this.products.apply {
              clear()
              addAll(results)
          }
      }*/
}