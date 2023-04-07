package ru.mirea.shumikhin.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dateInMillis = System.currentTimeMillis()
        val format = "yyyy-MM-dd HH:mm:ss"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        val dateString = sdf.format(Date(dateInMillis))
        button = findViewById(R.id.btnToSecond)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity ,SecondActivity::class.java)
            intent.putExtra("date", dateString)
            startActivity(intent)
        }
    }
}