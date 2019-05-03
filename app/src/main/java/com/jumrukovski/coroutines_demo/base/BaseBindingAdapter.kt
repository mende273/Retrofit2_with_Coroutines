package com.canoralabs.screenshotsorganizer.core.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jumrukovski.coroutines_demo.base.BaseBindingViewHolder
import java.util.*

abstract class BaseBindingAdapter<I> : RecyclerView.Adapter<BaseBindingViewHolder>(),
    BaseBindingViewHolder.ClickListener {

    protected var items: MutableList<I> = ArrayList()
    private lateinit var itemClickListener: ItemClickListener<I>

    override fun onViewClick(position: Int, sharedViews: Array<View>) {
        itemClickListener.onClick(items[position], position, sharedViews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = bind(inflater, parent, viewType)
        return BaseBindingViewHolder(binding, this)
    }

    protected abstract fun bind(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewDataBinding

    override fun getItemCount(): Int = items.size

    fun setItemsInAdapter(items: MutableList<I>) {
        this.items = items
        notifyDataSetChanged()
    }

    @JvmOverloads
    fun addItem(item: I, position: Int = items.size) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    @JvmOverloads
    fun addItems(itemsToAdd: List<I>, position: Int = items.size) {
        items.addAll(position, itemsToAdd)
        notifyItemRangeInserted(position, itemsToAdd.size)
    }

    fun updateItem(position: Int, item: I) {
        items[position] = item
        notifyItemChanged(position)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear() {
        val size = items.size
        if (size > 0) {
            items.clear()
            notifyItemRangeRemoved(0, size)
        }
    }

    fun setItemClickListener(itemClickListener: ItemClickListener<I>) {
        this.itemClickListener = itemClickListener
    }

    interface ItemClickListener<I> {
        fun onClick(item: I, position: Int, sharedViews: Array<View>)
    }
}