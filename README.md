# BookReview

## 概要

BookReview は、書籍の登録・レビュー投稿・閲覧ができる Web アプリケーションです。
個人の読書記録だけでなく、複数ユーザーが本の感想を共有できるサービスを想定しています。

## 使用技術

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- H2 Database
- PostgreSQL / Neon
- Docker
- Render

## 主な機能

- 書籍一覧表示
- 書籍詳細表示
- 書籍登録・編集・削除
- レビュー投稿
- ユーザー登録
- ログイン・ログアウト
- 管理者権限による管理機能

## 工夫した点

- Controller / Service / Repository に責務を分けた
- Spring Security による認証機能を実装した
- 本番環境と開発環境で DB を切り替えられるようにした
- Docker を用いてデプロイしやすい構成にした

## 今後追加したい機能

- 投稿者本人のみ編集・削除できる認可制御
- レビューのお気に入り機能
- キャッシュの活用
- バリデーション強化
- 管理者画面の拡充
