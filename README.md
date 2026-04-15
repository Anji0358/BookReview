# URL
* https://bookreview-43pt.onrender.com
※初期の起動時には約一分ほどかかります。

# BookReview　アプリ
本の管理とレビュー投稿ができるWebアプリケーションです。

## スクリーンショット
* ![alt text](images/image-3.png)

### 新規登録
* ![alt text](images/image-4.png)
* ![alt text](images/image-5.png)
* ![alt text](images/image-6.png)

### 書籍詳細
* ![alt text](images/image-7.png)
* ![alt text](images/image-8.png)
* ![alt text](images/image-9.png)

### 書籍編集
* ![alt text](images/image-10.png)
* ![alt text](images/image-11.png)
* ![alt text](images/image-12.png)

## 機能一覧
* 書籍の一覧表示・詳細閲覧
* 新しい書籍の登録・既存情報の編集
* 書籍に対するレビュー投稿機能（5段階評価とコメント）

## 使用技術
### バックエンド (Backend)
- **Java**: 21 (最新の長期サポート版)
- **Spring Boot**: 4.0.2
    - **Spring MVC**: Webアプリケーション構築
    - **Spring Data JPA**: データベース操作（ORM）
    - **Spring Boot Validation**: 入力値のバリデーション
- **Lombok**: アノテーションによるボイラープレートコードの削減

### フロントエンド (Frontend)
- **Thymeleaf**: テンプレートエンジンによる動的HTML生成
- **HTML5 / CSS3**: UIデザイン

### データベース / ツール (Database & Tools)
- **H2 Database**: インメモリ型データベース（開発・テスト用）
- **Maven**: プロジェクト管理・ビルドツール
- **Spring Boot DevTools**: 開発中のオートリロード機能
