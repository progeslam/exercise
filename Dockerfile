FROM openjdk:8-jdk-alpine
COPY target/exercise-1.0.0.war exercise.war
ENTRYPOINT ["java","-jar","exercise.war"]
