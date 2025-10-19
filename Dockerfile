# 1️⃣ Stage de build
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Copia arquivos do Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Baixa dependências sem compilar ainda
RUN ./mvnw dependency:go-offline

# Copia o restante do código
COPY src ./src

# Compila e empacota o .jar
RUN ./mvnw package -DskipTests

# 2️⃣ Stage de runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia o .jar gerado do build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Comando para rodar o Spring Boot
ENTRYPOINT ["java","-jar","app.jar"]
