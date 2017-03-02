FROM java:8
LABEL version="1.0" description="JazzFestMap - whole app"
#VOLUME /tmp
EXPOSE 9999
ADD jfm-parser-1.0-SNAPSHOT.jar app.jar
ADD data/ data/
RUN bash -c 'touch /app.jar'
RUN export DEBIAN_FRONTEND=noninteractive && apt-get update && apt-get --yes install mysql-server
RUN /etc/init.d/mysql start && mysqladmin -u root password 1234 && /etc/init.d/mysql restart && mysql -u root -p1234 < data/jfm-data.sql
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]