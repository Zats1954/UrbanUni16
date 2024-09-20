package ru.zatsoft.phoneshop1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.phoneshop1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolBar: Toolbar
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.toolbarMain
        setSupportActionBar(toolBar)
        title = " "
        binding.btnExit.setOnClickListener {
            System.exit(0)
        }
        binding.rbMoscow.setOnClickListener {
            intent = Intent(this, Moscow::class.java)
            startActivity(intent)
        }
        binding.rbPeterburg.setOnClickListener {
            intent = Intent(this, Peterburg::class.java)
            startActivity(intent)
        }
    }
}