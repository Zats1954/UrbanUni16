package ru.zatsoft.phoneshop1

import android.os.Bundle
import android.widget.Button


class Peterburg: NextActivity(R.layout.activity_peterburg) {
    override fun getPrices() = listOf(
        155.00,
        127.00,
        185.90,
        368.18,
        399.00
    )

    private var isRepaired = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btnRepair = findViewById<Button>(R.id.btnRepair)
        btnRepair.setOnClickListener {
            if(!isRepaired){
                val dialog = MyDialog()
                isRepaired = true
                dialog.show(supportFragmentManager,"custom")
            }
        }
    }

}