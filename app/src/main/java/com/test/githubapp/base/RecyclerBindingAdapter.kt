package com.test.githubapp.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.AbstractList

open class RecyclerBindingAdapter<T>(
        private val holderLayout: Int,
        private val variableId: Int,
        val items: AbstractList<T>
) : RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder>() {

    var onItemClickListener: OnItemClickListener<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerBindingAdapter.BindingHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(holderLayout, parent, false)
        return BindingHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerBindingAdapter.BindingHolder, position: Int) {
        val item = items[position]
        holder.binding!!.root.setOnClickListener {
            onItemClickListener?.onItemClick(position, item)
        }
        holder.binding.setVariable(variableId, item)
    }

    override fun getItemCount() = items.size

    interface OnItemClickListener<T> {
        fun onItemClick(position: Int, item: T)
    }

    class BindingHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ViewDataBinding? = DataBindingUtil.bind(v)
    }
}
