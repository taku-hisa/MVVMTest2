package com.example.mvvmtest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest2.DI.ViewModelFactory
import com.example.mvvmtest2.Epoxy.ItemPagedListController
import com.example.mvvmtest2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also { binding ->
            val controller = ItemPagedListController()
            binding.epoxyRecyclerView.adapter = controller.adapter


            val layoutManager = LinearLayoutManager(applicationContext).apply { orientation = RecyclerView.VERTICAL }
            binding.epoxyRecyclerView.layoutManager = layoutManager

            val viewModel = ViewModelFactory.mainViewModel
            binding.viewModel = viewModel
            viewModel.entities.observe(this, Observer { controller.submitList(it) })
        }
    }
}