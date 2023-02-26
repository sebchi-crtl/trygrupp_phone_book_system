FROM openjdk:17
ADD build/libs/*.jar trygrupp.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "trygrupp.jar"]