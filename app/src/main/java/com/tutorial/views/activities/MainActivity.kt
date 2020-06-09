package com.tutorial.views.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorial.databinding.ActivityMainBinding
import com.tutorial.data.models.MainModel
import com.tutorial.views.adapters.MainAdapter
import com.tutorial.views.adapters.MainAdapterView
import java.util.*

class MainActivity : AppCompatActivity(), MainActivityView, MainAdapterView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    companion object {
        private var list: MutableList<MainModel> = ArrayList()
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainAdapter(list, this)
        binding()
    }

    private fun binding() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))
        binding.recyclerView.adapter = adapter
    }

    override fun onShowLoading() {
    }

    override fun onHideLoading() {
    }

    override fun onResponse(response: MutableList<MainModel>) {
    }

    override fun onFailure(error: Throwable) {
    }

    override fun onClickAdapter(position: Int) {
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
