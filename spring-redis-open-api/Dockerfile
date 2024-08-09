FROM eclipse-temurin:17
EXPOSE 8080
ARG JAR_FILE="target/spring-redis-open-api-0.0.1-SNAPSHOT.jar"
ADD ${JAR_FILE} spring-redis-open-api.jar
ENTRYPOINT [ "java", "-jar", "/spring-redis-open-api.jar" ]