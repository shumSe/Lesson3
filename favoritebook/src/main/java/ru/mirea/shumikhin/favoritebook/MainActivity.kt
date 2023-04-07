package ru.mirea.shumikhin.favoritebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY: String = "book_name"
        const val USER_MESSAGE: String = "MESSAGE"
        const val MAIN_TEXT = "Тут появится название вашей любимой книги!"
    }


    private lateinit var btnToSendData: Button
    private lateinit var tvFavBook: TextView

    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToSendData = findViewById(R.id.btnToSendData)
        tvFavBook = findViewById(R.id.tvFavouriteBook)
        tvFavBook.text = MAIN_TEXT

        val callback = ActivityResultCallback<ActivityResult> { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data = result.data!!
                val userBook = data.getStringExtra(USER_MESSAGE)
                if (userBook != "") {
                    tvFavBook.text = "Название Вашей любимой книги: $userBook"
                }else if(tvFavBook.text == MAIN_TEXT) {
                    Toast.makeText(applicationContext, "Вы не ввели название книги", Toast.LENGTH_LONG).show()
                }
            }
        }

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            callback
        )

        btnToSendData.setOnClickListener {
            getInfoAboutBook()
        }
    }

    private fun getInfoAboutBook(){
        val intent = Intent(this@MainActivity, ShareActivity::class.java)
        intent.putExtra(KEY, "Преступление и наказание")
        activityResultLauncher.launch(intent)
    }
}