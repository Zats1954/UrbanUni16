package ru.zatsoft.phoneshop1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.zatsoft.phoneshop1.databinding.ActivityPeterburgBinding

class Peterburg: AppCompatActivity() {
    private lateinit var binding : ActivityPeterburgBinding
    private var listPrices = listOf(
        155.00,
        127.00,
        185.90,
        368.18,
        399.00
    )
    private var isRepaired = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ViewModel::class.java]
        binding = ActivityPeterburgBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillLayout(viewModel)
        binding.btnRepair.setOnClickListener {
            if(!isRepaired){
                val dialog = MyDialog()
                isRepaired = true
                dialog.show(supportFragmentManager,"custom")
            }
        }
    }

    private fun fillLayout(viewModel: ViewModel) {
        viewModel.loadPhones(listPrices)
        binding.tvSummSells.text = "Всего куплено телефонов - ${viewModel.soldCount()}"
        val listAdapter = ListAdapter(this, R.layout.list_item, viewModel.listPhones)
        listAdapter.notifyDataSetChanged()
        binding.lvPhones.adapter = listAdapter
        binding.lvPhones.setOnItemClickListener { parent, view, position, id ->
            viewModel.listPhones.get(position).sells++
            listAdapter.notifyDataSetChanged()
            Toast.makeText(
                this,
                "куплен ${viewModel.listPhones.get(position).name}",
                Toast.LENGTH_LONG
            ).show()
            binding.tvSummSells.text = "Всего куплено телефонов - ${viewModel.soldCount()}"
        }
    }
}