package ru.mirea.shumikhin.favoritebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    private lateinit var tvDevFavBook: TextView
    private lateinit var inputFavBook: EditText
    private lateinit var btnToBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        tvDevFavBook = findViewById(R.id.tvDevFavBook)
        inputFavBook = findViewById(R.id.editTextFavBook)
        btnToBack = findViewById(R.id.btnToBack)

        val extras = intent.extras

        if (extras != null){
            val devFavBookName = extras.getString(MainActivity.KEY)
            tvDevFavBook.text = "Любимая книга разработчика - $devFavBookName"
        }

        btnToBack.setOnClickListener {
            val intent = Intent()
            val bookName = inputFavBook.text.toString().trim()
            intent.putExtra(MainActivity.USER_MESSAGE, bookName)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}