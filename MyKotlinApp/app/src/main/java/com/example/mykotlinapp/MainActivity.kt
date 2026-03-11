package com.example.mykotlinapp

import android.os.Bundle
import android.widget.Toast
import android.widget.EditText
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etUserName: EditText = findViewById(R.id.etUserName)
        val etPinNumber: EditText = findViewById(R.id.etPinNumber)
        val btLogin: Button = findViewById(R.id.btLogin)
        val btClear: Button = findViewById(R.id.btClear)

        btLogin.setOnClickListener {
            val checkUserName = "[a-zA-Z]+".toRegex()
            val checkPinNumber = "[0-9]{4}".toRegex()

            if (checkUserName.matches(etUserName.text.toString()) &&
                checkPinNumber.matches(etPinNumber.text.toString())) {

                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Invalid UN / PN", Toast.LENGTH_LONG).show()
            }
        }

        btClear.setOnClickListener {
            etUserName.text.clear()
            etPinNumber.text.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
