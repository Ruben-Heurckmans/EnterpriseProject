FROM openjdk:17-jdk-alpine
EXPOSE 8085

# ENV GOOGLE_CLIENTSECRET="810995543607-f3hp3p5urflmgov6aeplt5mpkule8p5r.apps.googleusercontent.com"
# ENV GOOGLE_CLIENTID="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"

ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]