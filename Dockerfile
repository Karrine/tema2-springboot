FROM openjdk:8
COPY target/tema2-springboot-0.0.1-SNAPSHOT.jar app.jar
run bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar