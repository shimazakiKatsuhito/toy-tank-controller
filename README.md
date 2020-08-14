# toy-tank-controller
## 概要：
[ラジコン戦車](https://github.com/shimazakiKatsuhito/toy-tank-2019)のコントローラーの役割を行う、スマホ(android)アプリです。

## 開発環境：
OS:windows 10
Env:Andoid Studio 3.6.2

## 開発言語：
kotlin

## 動作環境：
スマートフォン(android 5.0.2)

## システム構成：
・ラジコン戦車
  ⇒raspberrypi Zeroを搭載し、アクセスポイントを経由してコントローラーとWiFi通信を行います。
・アクセスポイント
・コントローラー
　⇒androidスマートフォン。当アプリをインストール。戦車に動作指示を行います
 
## 機能：
 当アプリはボタン押下(＊)、または、音声入力に従って、WiFiによって下記の戦車操作コマンドをAPを経由し、ラジコン戦車に送信します。
 ＊）前進・後退・左旋回・右旋回ボタン押下時は離すと停止します。
 ・前進
 ・後退
 ・左旋回
 ・右旋回
 ・停止
 ・目標追尾(砲台動作)開始
 ・目標追尾(砲台動作)終了
 ・BB弾発射

![Screenshot_2020-05-25-19-52-52](https://user-images.githubusercontent.com/54632092/90218214-32369d00-de3e-11ea-8064-b398bcb5fd79.jpg)
