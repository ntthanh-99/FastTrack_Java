#FROM amazoncorretto:17
FROM 590183792993.dkr.ecr.ap-southeast-1.amazonaws.com/amazoncorretto:17
WORKDIR /fasttrack
COPY ./target/lesson23-0.0.1-SNAPSHOT.jar lesson23.jar
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:10006"
ENTRYPOINT ["java", "-jar", "/fasttrack/lesson23.jar"]