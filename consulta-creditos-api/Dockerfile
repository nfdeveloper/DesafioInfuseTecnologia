# Etapa 1: Build da aplicação
FROM eclipse-temurin:17-jdk-alpine as builder

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY . .

# Build do projeto usando Maven (ou Gradle se preferir)
# Substitua pelo comando equivalente caso esteja usando Gradle
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final para execução
FROM eclipse-temurin:17-jre-alpine

# Diretório de trabalho no container final
WORKDIR /app

# Copia o .jar do build anterior
COPY --from=builder /app/target/*.jar app.jar

# Porta que será exposta
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
