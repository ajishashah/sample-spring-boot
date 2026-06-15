FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ENV PORT=8080
COPY target/springboot-sample-0.0.1-SNAPSHOT.jar springbootsample.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar springbootsample.jar"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar springbootsample.jar"]