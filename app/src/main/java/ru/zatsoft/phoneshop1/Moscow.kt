package ru.zatsoft.phoneshop1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.zatsoft.phoneshop1.databinding.ActivityMoscowBinding

class Moscow : AppCompatActivity() {
    private lateinit var binding: ActivityMoscowBinding
    private var listPrices = listOf(
        149.00,
        null,
        169.90,
        349.18,
        425.00,
        null
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ViewModel::class.java]
        binding = ActivityMoscowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillLayout(viewModel)
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