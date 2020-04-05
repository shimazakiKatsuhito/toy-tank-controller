package com.example.toytankcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            AlertDialog.Builder(this).setTitle(getString(R.string.btn_fore) + "ボタンが押されました\n\n")
                .setMessage("前進します")
                .setPositiveButton("OK", null)
                .show()
        }

        button2.setOnClickListener{
            AlertDialog.Builder(this).setTitle(getString(R.string.btn_back) + "ボタンが押されました\n\n")
                .setMessage("後退します")
                .setPositiveButton("OK", null)
                .show()
        }

        button3.setOnClickListener{
            AlertDialog.Builder(this).setTitle(getString(R.string.btn_left) + "ボタンが押されました\n\n")
                .setMessage("左旋回します")
                .setPositiveButton("OK", null)
                .show()
        }

        button4.setOnClickListener{
            AlertDialog.Builder(this).setTitle(getString(R.string.btn_right) + "ボタンが押されました\n\n")
                .setMessage("右旋回します")
                .setPositiveButton("OK", null)
                .show()
        }

    }
}
