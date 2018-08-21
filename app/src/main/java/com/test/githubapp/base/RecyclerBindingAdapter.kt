package com.test.githubapp.base

import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.ref.WeakReference

class RecyclerBindingAdapter<T>(
        private val holderLayout: Int,
        private val variableId: Int,
        val items: ObservableList<T>
) : RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder>() {

    var onItemClickListener: OnItemClickListener<T>? = null
    private val onListChangedCallback =
            WeakReferenceOnListChangedCallback<ObservableList<T>>(this)

    init {
        items.addOnListChangedCallback(onListChangedCallback)
    }

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

    private class WeakReferenceOnListChangedCallback<I : ObservableList<*>> (
            adapter: RecyclerBindingAdapter<*>
    )
        : ObservableList.OnListChangedCallback<I>() {

        private val adapterReference = WeakReference(adapter)

        override fun onChanged(sender: I) {
            adapterReference.get()?.notifyDataSetChanged()
        }

        override fun onItemRangeRemoved(sender: I, positionStart: Int, itemCount: Int) {
            adapterReference.get()?.notifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(sender: I, fromPosition: Int, toPosition: Int, itemCount: Int) {
            adapterReference.get()?.notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemRangeInserted(sender: I, positionStart: Int, itemCount: Int) {
            adapterReference.get()?.notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(sender: I, positionStart: Int, itemCount: Int) {
            adapterReference.get()?.notifyItemRangeChanged(positionStart, itemCount)
        }
    }
}
