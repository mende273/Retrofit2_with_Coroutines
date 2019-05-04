package com.jumrukovski.coroutines_demo.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.canoralabs.screenshotsorganizer.core.base.BaseBindingAdapter
import com.jumrukovski.coroutines_demo.R
import com.jumrukovski.coroutines_demo.adapter.ItemAdapter
import com.jumrukovski.coroutines_demo.base.BaseActivity
import com.jumrukovski.coroutines_demo.data.model.ApiResponse
import com.jumrukovski.coroutines_demo.data.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityVM>() {

    @Inject
    lateinit var itemsAdapter: ItemAdapter

    override fun getViewModel(): Class<MainActivityVM> = MainActivityVM::class.java

    private val itemClickListener = object : BaseBindingAdapter.ItemClickListener<Item> {
        override fun onClick(item: Item, p: Int, sharedViews: Array<View>) {
            showToastMessage(item.toString())
        }
    }

    private val topRatedObserver =
        Observer<ApiResponse<List<Item>>> { response ->
            replaceData(response.results)
        }

    private val mostPopularObserver =
        Observer<ApiResponse<List<Item>>> { response ->
            replaceData(response.results)
        }

    private fun replaceData(items: List<Item>) {
        itemsAdapter.clear()
        itemsAdapter.addItems(items)
    }

    private fun initAdapter() {
        items.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemsAdapter
        }

        itemsAdapter.setItemClickListener(itemClickListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        initAdapter()
        setListeners()
    }

    private fun setListeners() {
        btnTopRated.setOnClickListener {
            viewModel.getTopRatedShows().observe(this, topRatedObserver)
        }
        btnMostPopular.setOnClickListener {
            viewModel.getMostPopularShows().observe(this, mostPopularObserver)
        }
    }
}
