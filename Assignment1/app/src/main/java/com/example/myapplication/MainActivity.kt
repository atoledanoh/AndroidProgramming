package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val numKeyName = "numberValue"
    private var displayedNumber: Int = 10
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.toastBtn.setOnClickListener { showToast(it) }
        binding.countDownBtn.setOnClickListener { countDown() }
        binding.countUpBtn.setOnClickListener { countUp() }
    }

    private fun showToast(view: View) {
        Toast.makeText(applicationContext, "HOLA $displayedNumber", Toast.LENGTH_SHORT)
            .show()
    }

    private fun countUp() {
        displayedNumber++;
        updateView()
    }

    private fun countDown() {
        displayedNumber--;
        updateView()
    }

    private fun updateView() {
        binding.apply {
            numberBtn?.text = displayedNumber.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putInt(numKeyName, displayedNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val storedNumber = savedInstanceState.getInt(numKeyName)
        displayedNumber = storedNumber
        updateView()
    }

}