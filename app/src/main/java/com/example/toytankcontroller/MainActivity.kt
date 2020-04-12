package com.example.toytankcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

import android.app.Application
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //AlertDialog.Builder(this).setTitle(getString(R.string.btn_fore) + "ボタンが押されました\n\n")
            //    .setMessage("前進します")
            //    .setPositiveButton("OK", null)
            //    .show()
            val url = "http://192.168.0.8:8000/tank/go_forward"
            runBlocking {
                url.httpGet().response{ request, responce, result ->
                    when (result) {
                        is Result.Success -> {
                            // レスポンスボディを表示
                            println("非同期処理の結果：" + responce.toString())
                        }
                        is Result.Failure -> {
                            println("通信に失敗しました。")
                        }
                    }
                }
            }
        }

        button2.setOnClickListener{
            //AlertDialog.Builder(this).setTitle(getString(R.string.btn_back) + "ボタンが押されました\n\n")
            //    .setMessage("後退します")
            //    .setPositiveButton("OK", null)
            //    .show()
            val url = "http://192.168.0.8:8000/tank/go_backward"
            runBlocking {
                url.httpGet().response{ request, responce, result ->
                    when (result) {
                        is Result.Success -> {
                            // レスポンスボディを表示
                            println("非同期処理の結果：" + responce.toString())
                        }
                        is Result.Failure -> {
                            println("通信に失敗しました。")
                        }
                    }
                }
            }
        }

        button3.setOnClickListener{
            //AlertDialog.Builder(this).setTitle(getString(R.string.btn_left) + "ボタンが押されました\n\n")
            //    .setMessage("左旋回します")
            //    .setPositiveButton("OK", null)
            //    .show()
            val url = "http://192.168.0.8:8000/tank/turn_left"
            runBlocking {
                url.httpGet().response{ request, responce, result ->
                    when (result) {
                        is Result.Success -> {
                            // レスポンスボディを表示
                            println("非同期処理の結果：" + responce.toString())
                        }
                        is Result.Failure -> {
                            println("通信に失敗しました。")
                        }
                    }
                }
            }
        }

        button4.setOnClickListener{
            //AlertDialog.Builder(this).setTitle(getString(R.string.btn_right) + "ボタンが押されました\n\n")
            //    .setMessage("右旋回します")
            //    .setPositiveButton("OK", null)
            //    .show()
            val url = "http://192.168.0.8:8000/tank/turn_right"
            runBlocking {
                url.httpGet().response{ request, responce, result ->
                    when (result) {
                        is Result.Success -> {
                            // レスポンスボディを表示
                            println("非同期処理の結果：" + responce.toString())
                        }
                        is Result.Failure -> {
                            println("通信に失敗しました。")
                        }
                    }
                }
            }
        }

        button5.setOnClickListener{
            val url = "http://192.168.0.8:8000/tank/stop"
            runBlocking {
                url.httpGet().response{ request, responce, result ->
                    when (result) {
                        is Result.Success -> {
                            // レスポンスボディを表示
                            println("非同期処理の結果：" + responce.toString())
                        }
                        is Result.Failure -> {
                            println("通信に失敗しました。")
                        }
                    }
                }
            }
        }
    }
}
