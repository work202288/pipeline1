FROM registry.access.redhat.com/ubi8/openjdk-11:latest
ADD target/*.jar pipeline1.jar
ENTRYPOINT ["java","-jar","pipeline1.jar"]