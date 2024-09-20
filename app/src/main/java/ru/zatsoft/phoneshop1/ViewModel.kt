package ru.zatsoft.phoneshop1

import androidx.lifecycle.ViewModel
import kotlin.math.min

class ViewModel : ViewModel() {

    val listModels: List<String> = listOf(
        "Xiaomi Redmi 13C 6GB",
        "Apple iPhone 6 Space Grey 128GB",
        "Motorola Moto G54 5G 12GB",
        "POCO X6 PRO 5G 12GB",
        "Sony Xperia 10 VI 5G 8GB"
    )
    private val _listPhones:  MutableList<Phone> = mutableListOf()
    val listPhones: List<Phone>
        get() = _listPhones

    fun add(phone: Phone) {
        _listPhones.add(phone)
    }

    fun soldCount(): Int {
        var count = 0
       _listPhones.forEach {count +=  it.sells   }
        return count
    }

    fun loadPhones(listPrices: List<Double?>) {
        val maxIndex = min(listPrices.size, listModels.size)
//  Заполняем прайслист только моделями с заданной ценой
        for (i in 0..maxIndex - 1) {
            listPrices?.get(i)?.let{
            _listPhones.add(Phone(listModels[i], it))}
        }
    }
}