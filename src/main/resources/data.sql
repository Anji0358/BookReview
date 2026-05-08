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
(id, title, author, published_date, description, created_at, updated_at, user_id)
VALUES
(1, 'Java基礎入門', 'サンプル著者A', '2000-01-01',
 'Javaの基礎文法、制御構文、クラスの基本を体系的に学べる入門書です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(2, '実践Javaプログラミング', 'サンプル著者B', '2000-01-02',
 'Javaを使った実践的なアプリケーション開発の考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(3, 'Java設計パターン入門', 'サンプル著者C', '2000-01-03',
 'オブジェクト指向設計や設計パターンの基本を、Javaの例を通して学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(4, '読みやすいコードの書き方', 'サンプル著者D', '2000-01-04',
 '保守しやすく読みやすいコードを書くための命名、分割、コメントの考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(5, 'ソフトウェア開発の基本姿勢', 'サンプル著者E', '2000-01-05',
 '開発者として成長するための学習方法、設計姿勢、改善の考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(6, 'リファクタリング実践入門', 'サンプル著者F', '2000-01-06',
 '既存コードを安全に改善し、可読性と保守性を高めるための基本を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(7, 'アーキテクチャ設計入門', 'サンプル著者G', '2000-01-07',
 'レイヤードアーキテクチャ、依存関係の整理、責務分離の考え方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(8, 'Webアプリケーション基礎', 'サンプル著者H', '2000-01-08',
 'HTTP、URL、リクエスト、レスポンスなど、Webアプリケーション開発の基礎を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(9, 'データベース設計入門', 'サンプル著者I', '2000-01-09',
 'テーブル設計、主キー、外部キー、正規化など、データベース設計の基本を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(10, 'SQL実践トレーニング', 'サンプル著者J', '2000-01-10',
 'SELECT、JOIN、GROUP BY、サブクエリなど、SQLの実践的な使い方を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(11, 'Spring Boot入門', 'サンプル著者K', '2000-01-11',
 'Spring Bootを使ったWebアプリケーション開発の基本構成を学べる入門書です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(12, 'Spring Framework基礎', 'サンプル著者L', '2000-01-12',
 'DI、MVC、データアクセス、サービス層の設計など、Springの基本を体系的に学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),

(13, 'Spring Boot実践開発', 'サンプル著者M', '2000-01-13',
 'Spring Bootを用いたCRUD、ログイン機能、データベース連携の実装を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),

(14, 'Git操作入門', 'サンプル著者N', '2000-01-14',
 'Gitの基本操作、コミット、ブランチ、マージ、リモートリポジトリの扱いを学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),

(15, 'システム運用とログ管理', 'サンプル著者O', '2000-01-15',
 'Webアプリケーションの運用、ログ確認、エラー調査、監視の基本を学べる本です。',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3);
 -- =========================
-- 初期レビューデータ
-- =========================
 INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーA', 5, '説明が丁寧で、初めて学ぶ内容でも流れを追いやすいと感じました。基礎を確認しながら読み進められる点が良かったです。', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーB', 4, '具体例が多く、内容を実際の場面に置き換えて考えやすかったです。少し難しい部分もありましたが、全体として参考になりました。', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーC', 3, '内容は充実していますが、ある程度の前提知識がないと理解に時間がかかる部分がありました。復習用として使いやすいと思います。', 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーD', 5, '章ごとの構成がわかりやすく、順番に読み進めることで理解が深まりました。学習の最初の一冊として使いやすい内容です。', 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーE', 4, '基礎から応用まで段階的に説明されていて、全体像をつかむのに役立ちました。図や補足説明も理解の助けになりました。', 3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーF', 2, '内容自体は参考になりますが、説明がやや抽象的で初学者には少し難しく感じました。補足資料と合わせて読むとよさそうです。', 3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーG', 5, '実践的な観点が多く、知識をどのように使うかまで考えられる内容でした。何度か読み返したいと思える本です。', 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーH', 4, '説明の順序が自然で、つまずきやすい部分も丁寧に扱われていました。学習メモを取りながら読むのに向いています。', 4, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーI', 3, '情報量が多いため一度で理解するのは難しいですが、必要な部分を参照する用途では便利だと思います。', 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (reviewer_name, score, content, book_id, user_id, created_at, updated_at)
VALUES
('ユーザーJ', 5, '全体的に読みやすく、学習のモチベーションを保ちやすい内容でした。初学者にも経験者にも参考になる部分があると思います。', 5, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);