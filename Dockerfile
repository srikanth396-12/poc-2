FROM openjdk:17
 
WORKDIR /app
 
COPY Hello.java .
 
RUN javac Hello.java
 
EXPOSE 8080
 
CMD ["java", "Hello"]
