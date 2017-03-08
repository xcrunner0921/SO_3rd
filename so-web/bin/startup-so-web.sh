#!/bin/sh
JAR_PATH=../build/libs/so-web-1.0.0-SNAPSHOT.jar

java -jar ${JAR_PATH} -Dspring.config.location=../conf/application.properties