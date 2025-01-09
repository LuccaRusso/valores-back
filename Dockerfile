# Use uma imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o JAR gerado para dentro do contêiner
COPY target/gamecard-0.0.1-SNAPSHOT.jar app.jar


# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
