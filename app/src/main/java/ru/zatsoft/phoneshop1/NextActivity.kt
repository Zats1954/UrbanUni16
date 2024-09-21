package ru.zatsoft.phoneshop1

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

abstract class NextActivity(val layout: Int): AppCompatActivity() {
        var listPrices: List<Double?>

        abstract fun getPrices(): List<Double?>

        init{ listPrices = this.getPrices()
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(layout)
            val viewModel = ViewModelProvider(this)[ViewModel::class.java]

//            fillLayout(viewModel)
//        }
//
//    private fun fillLayout(viewModel: ViewModel) {
            if(viewModel.listPhones.size == 0){
            viewModel.loadPhones(listPrices)}
            val tvSummSells = findViewById<TextView>(R.id.tvSummSells)
            tvSummSells.text = "Всего куплено телефонов - ${viewModel.soldCount()}"
            val listAdapter = ListAdapter(this, R.layout.list_item, viewModel.listPhones)
            listAdapter.notifyDataSetChanged()
            val lvPhones = findViewById<ListView>(R.id.lvPhones)
            lvPhones.adapter = listAdapter
            lvPhones.setOnItemClickListener { _, _, position, _ ->
                viewModel.listPhones.get(position).sells++
                listAdapter.notifyDataSetChanged()
                Toast.makeText(
                    this,
                    "куплен ${viewModel.listPhones.get(position).name}",
                    Toast.LENGTH_LONG
                ).show()
                tvSummSells.text = "Всего куплено телефонов - ${viewModel.soldCount()}"
            }
        }
}