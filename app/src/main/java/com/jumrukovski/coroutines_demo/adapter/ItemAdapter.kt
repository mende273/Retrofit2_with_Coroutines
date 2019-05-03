package com.jumrukovski.coroutines_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.canoralabs.screenshotsorganizer.core.base.BaseBindingAdapter
import com.jumrukovski.coroutines_demo.GlideApp
import com.jumrukovski.coroutines_demo.base.BaseBindingViewHolder
import com.jumrukovski.coroutines_demo.data.model.Item
import com.jumrukovski.coroutines_demo.databinding.ItemBinding
import javax.inject.Inject

class ItemAdapter @Inject constructor(private val context: Context) : BaseBindingAdapter<Item>() {

    override fun bind(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewDataBinding =
        ItemBinding.inflate(inflater, parent, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemBinding.inflate(inflater, parent, false)

        return object : BaseBindingViewHolder(itemBinding, this) {
            override fun sharedViews(): Array<View> {
                return arrayOf(itemBinding.title)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        (holder.binding as ItemBinding).apply {
            title.text = items[position].name

            GlideApp.with(context)
                .load("http://image.tmdb.org/t/p/w200" + items[position].poster_path)
                .into(thumb)
        }
    }
}