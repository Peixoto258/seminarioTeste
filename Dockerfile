# Imagem do OpenJDK 11 como base
FROM adoptopenjdk/openjdk11

# Definindo 0 diretório de trabalho no contêiner
WORKDIR /app

# Copiando o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Expondo a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
