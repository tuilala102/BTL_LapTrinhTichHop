#  syntax=docker/dockerfile:1
# Sử dụng ảnh base của Java 17
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["/mvnw","spring-boot:run"]

# # Tạo thư mục làm việc trong container
# VOLUME /tmp
# ADD target/accessing-data-mysql-complete-0.0.1-SNAPSHOT.jar  accessing-data-mysql-complete-0.0.1-SNAPSHOT.jar

# # Mở port 8080 để có thể truy cập ứng dụng từ bên ngoài container
# EXPOSE 8080

# # Chạy ứng dụng bằng lệnh 'java -jar app.jar'
# ENTRYPOINT ["java", "-jar", "/accessing-data-mysql-complete-0.0.1-SNAPSHOT.jar"]
