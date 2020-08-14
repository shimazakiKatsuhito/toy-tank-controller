# toy-tank-controller
## 概要：
別途作成した[ラジコン戦車](https://github.com/shimazakiKatsuhito/toy-tank-2019)のコントローラーの役割を行う、スマホ(android)アプリです。<br>  以下のような操作コマンドをラジコン戦車に送ることができます。
### 戦車操作コマンド
 - 前進　  ：戦車を前進させます。
 - 後退　  ：戦車を後退させます。
 - 左旋回  ：戦車を左に旋回させます。
 - 右旋回  ：戦車を右に旋回させます。
 - 停止　  ：戦車を停止させます。
 - BB弾発射：戦車の砲台からBB弾を発射します。
 - 追尾開始：戦車搭載カメラの画像から砲台を目標位置まで旋回する追尾動作を開始します。
 - 追尾終了：戦車搭載カメラの画像から砲台を目標位置まで旋回する追尾動作を終了します。

![Screenshot_2020-05-25-19-52-52](https://user-images.githubusercontent.com/54632092/90218433-c0ab1e80-de3e-11ea-8a6d-bd4160e0bcb3.png)

## 開発環境：
OS : windows 10<br>  App : Andoid Studio 3.6.2

## 開発言語：
kotlin

## 動作環境：
スマートフォン(android 5.0.2)

## システム構成：
  - ラジコン戦車（raspberrypi Zeroを搭載し、アクセスポイントを経由してコントローラーとWiFi通信を行います）
  - アクセスポイント
  - コントローラー（androidスマートフォン。当アプリをインストール。戦車に動作指示を行います）
 
## 使い方
### インストール
1. androidstudioをインストール<br>  を参考にしました。<br>  - [Android] Android Studio をインストールする手順（Windows）<br><https://akira-watson.com/android/adt-windows.html>  
2. androidstudioをセットアップ

### デプロイ方法
1. 適当なフォルダに当リポジトリをクローン
