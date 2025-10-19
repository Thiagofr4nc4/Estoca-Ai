# 1️⃣ Stage de build
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Copia arquivos do Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Baixa dependências sem compilar ainda
RUN ./mvnw dependency:go-offline -B

# Copia o restante do código
COPY src ./src

# Compila e empacota o .jar, ignorando testes e forçando UTF-8
RUN ./mvnw package -DskipTests -Dproject.build.sourceEncoding=UTF-8 -B

# 2️⃣ Stage de runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia o .jar gerado do build
COPY --from=build /app/target/*.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
