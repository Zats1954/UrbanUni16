package ru.zatsoft.phoneshop1

class Moscow :NextActivity(R.layout.activity_moscow) {
    override fun getPrices() = listOf(
        149.00,
        null,
        169.90,
        349.18,
        425.00,
        null
    )
}