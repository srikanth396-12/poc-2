FROM eclipse-temurin:17-jre
WORKDIR /app
COPY Hello.class .
CMD ["java", "Hello"]
