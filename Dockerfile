FROM tomcat:10.1-jdk17-temurin
COPY target/student-portal.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
