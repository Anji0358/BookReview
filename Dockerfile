FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# ① pom.xml だけコピー
COPY pom.xml .

# ② 依存を先にダウンロード（キャッシュされる）
RUN mvn dependency:go-offline

# ③ ソースコードをコピー
COPY src ./src

# ④ ビルド
RUN mvn clean package -DskipTests

# ===== 実行用イメージ =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# ⑤ jar をコピー（ここだけ確認）
COPY --from=build /app/target/BookReview-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]