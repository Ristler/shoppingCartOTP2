FROM maven:latest
LABEL authors="daniel"


WORKDIR /app
COPY pom.xml /app
COPY . /app
FROM --platform=linux/amd64 tiangolo/uvicorn-gunicorn-fastapi:python3.9
RUN mvn package
CMD ["java", "-jar", "target/shopping.jar"]
