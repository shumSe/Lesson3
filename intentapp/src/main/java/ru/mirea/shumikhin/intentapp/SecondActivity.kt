package ru.mirea.shumikhin.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var tvDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvDate = findViewById(R.id.tvDate)

        val n: Int = 28*28

        val time = intent.getStringExtra("date")

        tvDate.text = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТAВЛЯЕТ ${n}, а текущее время ${time}"
    }
}