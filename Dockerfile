FROM openjdk:8
COPY target/spring-cloud-k8s-config-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS = ""
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar


