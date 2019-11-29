package com.university.workshop_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    init {
        val a = 0
        print(a)
    }

    private var inputState: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bNewScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        inputState = savedInstanceState?.getString(INPUT_KEY) ?: ""
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        etText.setText(inputState)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INPUT_KEY, etText.text.toString() + ", 1")
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("", "onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val INPUT_KEY = "INPUT_KEY"
    }

}
