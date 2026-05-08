-- =========================
-- 初期ユーザー
-- =========================
INSERT INTO users (id, username, email, password, role)
VALUES
(1, 'admin', 'admin@example.com', '$2a$10$PDGrBz5EMUah2MyikHma.ek3i9.ygo4CBmGHuqiaCoY6vthadwXKa', 'ADMIN'),
(2, 'taro', 'taro@example.com', '$2a$10$PDGrBz5EMUah2MyikHma.ek3i9.ygo4CBmGHuqiaCoY6vthadwXKa', 'USER'),
(3, 'hanako', 'hanako@example.com', '$2a$10$PDGrBz5EMUah2MyikHma.ek3i9.ygo4CBmGHuqiaCoY6vthadwXKa', 'USER');

-- =========================
-- 初期書籍データ
-- =========================
INSERT INTO books
(id, title, author, isbn, description, created_at, updated_at, user_id)
VALUES
(1, 'スッキリわかるJava入門', '中山清喬・国本大悟', '9784297126858',
 'Javaの基礎文法からオブジェクト指向までを体系的に学べる入門書です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(2, 'プロになるJava', 'きしだなおき・山本裕介・杉山貴章', '9784297129118',
 'Javaを実務で使うために必要な考え方、設計、ライブラリの使い方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(3, 'Effective Java 第3版', 'Joshua Bloch', '9784621303252',
 'Javaプログラミングにおける設計指針やベストプラクティスを学べる名著です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(4, 'リーダブルコード', 'Dustin Boswell・Trevor Foucher', '9784873115658',
 '読みやすく保守しやすいコードを書くための考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(5, '達人プログラマー 第2版', 'David Thomas・Andrew Hunt', '9784274226298',
 'ソフトウェア開発者として成長するための姿勢、設計、実践的な考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(6, 'Clean Code', 'Robert C. Martin', '9784048930592',
 '保守性の高いコードを書くための原則やリファクタリングの考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(7, 'Clean Architecture', 'Robert C. Martin', '9784048930653',
 '依存関係の制御、レイヤードアーキテクチャ、設計原則について学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(8, 'Webを支える技術', '山本陽平', '9784774142043',
 'HTTP、URI、RESTなど、Webアプリケーションの基礎技術を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(9, 'SQLアンチパターン', 'Bill Karwin', '9784873115894',
 'データベース設計やSQLの失敗例を通して、よりよい設計を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(10, '達人に学ぶSQL徹底指南書 第2版', 'ミック', '9784798157825',
 'SQLの考え方、集合指向、実践的なクエリ設計を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(11, 'Spring Boot 3 プログラミング入門', '掌田津耶乃', '9784798069982',
 'Spring BootによるWebアプリケーション開発の基本を学べる入門書です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(12, 'Spring徹底入門 第2版', '株式会社NTTデータ', '9784798175361',
 'Spring FrameworkのDI、AOP、MVC、データアクセスなどを体系的に学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(13, '現場で使える Spring Boot', '槇俊明', '9784798142479',
 'Spring Bootを使った実践的なWebアプリケーション開発を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(14, '独習Git', 'リック・ウマリ', '9784798159651',
 'Gitの基本操作からブランチ、マージ、履歴管理までを学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(15, '入門 監視', 'Mike Julian', '9784873118642',
 'システム運用における監視、ログ、アラート設計の考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3);