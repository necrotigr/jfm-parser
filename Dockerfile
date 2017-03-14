FROM lwieske/java-8:jdk-8u121-slim
LABEL version="1.0" description="JazzFestMap - whole app"
VOLUME /tmp
EXPOSE 9999
ADD jfm-parser-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]