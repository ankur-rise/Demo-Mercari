package com.mercari.mercaritest.ui.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.mercari.mercaritest.data.models.DataModel


import com.mercari.mercaritest.ui.fragments.DealFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_item.view.*
import android.net.Uri
import com.mercari.mercaritest.R


/**
 * [RecyclerView.Adapter] that can display a deal item and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyItemRecyclerViewAdapter(
    private val mValues: List<DataModel>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        if(item.status?.equals("Sold out") == true) {
            holder.mTvSolout.visibility = View.VISIBLE
        } else {
            holder.mTvSolout.visibility = View.GONE
        }

        holder.mTvComment.text = item.numComments.toString()
        holder.mTvLike.text = item.numLikes.toString()
        holder.mTvPrice.text = item.price.toString().plus("\$")

        if(item.photo!=null && !item.photo!!.isEmpty()) {
            val uri = Uri.parse(item.photo)
            holder.imageView.setImageURI(uri)
        }

        with(holder.mView) {
            tag = item
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTvSolout: TextView = mView.tv_soldout
        val mTvLike: TextView = mView.tv_like
        val mTvComment: TextView = mView.tv_comment
        val mTvPrice: TextView = mView.tv_price
        val imageView:SimpleDraweeView  = mView.iv

        override fun toString(): String {
            return super.toString() + " '" + mTvLike.text + "'"
        }
    }
}
