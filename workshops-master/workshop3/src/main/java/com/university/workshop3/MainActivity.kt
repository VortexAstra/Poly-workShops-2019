package com.university.workshop3

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var rotateCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rotateCount = savedInstanceState?.getInt(ROTATE_COUNT_KEY, -1) ?: -1
        rotateCount += 1

        bindViews()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy called")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROTATE_COUNT_KEY, rotateCount)
    }

    private fun bindViews() {
        setInputtedValue(0)

        setRotationCount(rotateCount)

        bPlus.setOnClickListener {
            val value = getInputtedValue()
            if (value != null) {
                setInputtedValue(value + 1)
            }
        }

        bMinus.setOnClickListener {
            val value = getInputtedValue()
            if (value != null) {
                setInputtedValue(value - 1)
            }
        }

        bNewScreen.setOnClickListener {
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            onStop()
        }
    }

    private fun setRotationCount(count: Int) {
        tvRotateCount.text = "rotation count: $count"
    }

    private fun getInputtedValue(): Int? = etValue.text.toString().toIntOrNull()

    private fun setInputtedValue(value: Int) {
        etValue.setText(value.toString())
    }

    companion object {
        private const val ROTATE_COUNT_KEY = "ROTATE_COUNT_KEY"
    }
}
