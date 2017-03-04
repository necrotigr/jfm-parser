FROM java:8
LABEL version="1.0" description="JazzFestMap - whole app"
VOLUME /tmp
EXPOSE 9999
ADD jfm-parser-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]