FROM khipu/openjdk17-alpine AS builder
WORKDIR /app

COPY . .

RUN ./gradlew clean build

# Stage 2: Create a production-ready image
FROM khipu/openjdk17-alpine

WORKDIR /app

# Copy only necessary files from the build stage
COPY --from=builder /app/build/libs/assessment-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar","app.jar"]
