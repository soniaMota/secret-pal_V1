#!/bin/sh
docker run -it -v $(pwd)/service:/app -w /app gradle:6.3-jdk11 gradle war
