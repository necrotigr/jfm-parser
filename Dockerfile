FROM java:8
VOLUME /tmp
ADD parser-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
RUN apt-get install mysql-server
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]