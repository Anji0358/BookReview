-- Bookテーブルへの初期データ投入
-- ※カラム名はEntityのフィールド名に合わせてJPAが生成するもの（スネークケース）を指定します
INSERT INTO BOOKS (title, author, isbn, description, created_at, updated_at) 
VALUES ('スッキリわかるJava入門', '山田太郎', '2026-04-01', 'Javaの基礎を学ぶ本です。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO BOOKS (title, author, isbn, description, created_at, updated_at) 
VALUES ('Spring Boot実践', '佐藤次郎', '2026-05-01', '実践的なWebアプリ開発を学びます。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO BOOKS (title, author, isbn, description, created_at, updated_at)
 VALUES ('MySQL徹底解説', '鈴木花子', '2026-04-06', 'DBの設計と運用についての本。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);