# Use a imagem oficial do OpenJDK 11 como base
FROM adoptopenjdk/openjdk11

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Exponha a porta em que a aplicação Spring Boot será executada
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
