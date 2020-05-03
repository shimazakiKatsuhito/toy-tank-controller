package com.example.toytankcontroller


import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import java.util.*


const val REQUEST_CODE = 1000
const val TANK_ADR = "192.168.0.5"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 十字キーボタン押下設定ーボタンを押している間のみ戦車が動きます。
        // 前進ボタン押下
        button.setOnTouchListener { v, event ->
            if (v != null) {
                v.performClick()
            }
            when (event?.action) {
                MotionEvent.ACTION_DOWN ->{
                    sendCommGoForward()
                }
                MotionEvent.ACTION_UP->{
                    sendCommStop()
                }//Do Something
            }

            v?.onTouchEvent(event) ?: true
        }

        // 後退ボタン押下
        button2.setOnTouchListener { v, event ->
            if (v != null) {
                v.performClick()
            }
            when (event?.action) {
                MotionEvent.ACTION_DOWN ->{
                    sendCommGoBackward()
                }
                MotionEvent.ACTION_UP->{
                    sendCommStop()
                }//Do Something
            }

            v?.onTouchEvent(event) ?: true
        }

        // 左旋回ボタン押下
        button3.setOnTouchListener { v, event ->
            if (v != null) {
                v.performClick()
            }
            when (event?.action) {
                MotionEvent.ACTION_DOWN ->{
                    sendCommTurnLeft()
                }
                MotionEvent.ACTION_UP->{
                    sendCommStop()
                }//Do Something
            }

            v?.onTouchEvent(event) ?: true
        }

        // 右旋回ボタン押下
        button4.setOnTouchListener { v, event ->
            if (v != null) {
                v.performClick()
            }
            when (event?.action) {
                MotionEvent.ACTION_DOWN ->{
                    sendCommTurnRight()
                }
                MotionEvent.ACTION_UP->{
                    sendCommStop()
                }//Do Something
            }

            v?.onTouchEvent(event) ?: true
        }

        // Activityに設置しているボタンをタップすることで音声認識開始
        button5.setOnClickListener { // 音声認識を開始
            listen()
        }

        // 発射ボタン押下
        button6.setOnClickListener { // 砲台からBB弾を発射
            sendCommTurretShoot()
        }
    }

    // 音声認識を実行
    private fun listen() {
        // 音声認識Intent
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        // 音声の言語は日本語
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.JAPAN.toString())
        // 認識結果の最大数
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 10)
        // プロンプトに表示する文字列の設定
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "音声聞き取り中")

        try {
            // インテントを発行
            startActivityForResult(intent, REQUEST_CODE)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            textView.text = (e.message)
        }
    }

    // 音声認識結果対応処理
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if(data != null)
            {
                // 認識結果を取得
                val results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                // 内容があれば
                if (results != null) {
                    if (results.size > 0) {
                        // インデックス0の結果を表示
                        textView.text = results[0]

                        when(textView.text){
                            "前に進め" -> {
                                sendCommGoForward()
                            }
                            "後ろに進め" ->{
                                sendCommGoBackward()
                            }
                            "左に旋回" -> {
                                sendCommTurnLeft()
                            }
                            "右に旋回" -> {
                                sendCommTurnRight()
                            }
                            "止まれ" -> {
                                sendCommStop()
                            }
                            "追尾せよ" -> {
                                sendCommTurretFollow()
                            }
                            "追尾やめ" -> {
                                sendCommTurretUnFollow()
                            }
                            "打て" -> {
                                sendCommTurretShoot()
                            }
                        }
                    }
                }
            }
        }
    }

    // 前進コマンドを送信
    private fun sendCommGoForward(){
        val url = "http://$TANK_ADR:8000/tank/go_forward"
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

    // 後退コマンドを送信
    private fun sendCommGoBackward(){
        val url = "http://$TANK_ADR:8000/tank/go_backward"
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

    // 左旋回コマンドを送信
    private fun sendCommTurnLeft(){
        val url = "http://$TANK_ADR:8000/tank/turn_left"
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

    // 右旋回コマンドを送信
    private fun sendCommTurnRight(){
        val url = "http://$TANK_ADR:8000/tank/turn_right"
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

    // 停止コマンドを送信
    private fun sendCommStop(){
        val url = "http://$TANK_ADR:8000/tank/stop"
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

    // 自動追尾開始コマンドを送信
    private fun sendCommTurretFollow(){
        val url = "http://$TANK_ADR:8000/turret/follow"
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

    // 自動追尾終了コマンドを送信
    private fun sendCommTurretUnFollow(){
        val url = "http://$TANK_ADR:8000/turret/unfollow"
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

    // 発射コマンドを送信
    private fun sendCommTurretShoot(){
        val url = "http://$TANK_ADR:8000/turret/shoot"
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
