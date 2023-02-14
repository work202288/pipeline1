FROM openjdk:18
ADD target/*.jar pipeline1.jar
ENTRYPOINT ["java","-jar","pipeline1.jar"]