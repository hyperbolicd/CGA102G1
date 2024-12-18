FROM tomcat:9.0.98-jre17-temurin
ADD CGA102G1.war webapps/CGA102G1.war
ADD src/main/webapp/WEB-INF/lib/mysql-connector-java-8.0.22.jar lib/mysql-connector-java-8.0.22.jar
ADD tomcat-config/context.xml conf/context.xml
# RUN apt-get update -y && apt-get install -y vim iputils-ping telnet default-mysql-client
EXPOSE 8080