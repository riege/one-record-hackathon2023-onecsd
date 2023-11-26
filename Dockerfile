FROM registry.access.redhat.com/ubi9/openjdk-11-runtime:1.17-1
RUN mkdir /opt/app
CMD ["java","-jar","/opt/app/app.jar"]
COPY build/libs/*.jar /opt/app/app.jar
USER 1001
