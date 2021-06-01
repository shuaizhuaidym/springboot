#!/bin/bash
java  -server -Xss256k -Xms512m -Xmx512m -XX:ErrorFile=./hs_error_%p.log -XX:SoftRefLRUPolicyMSPerMB=1 -XX:-DoEscapeAnalysis -XX:MaxMetaspaceSize=128m -XX:MetaspaceSize=128m  -XX:+UseParallelGC -Djava.library.path=/home/gateway/jitlib/native -DPKIToolConfig=/home/gateway/config/pkitool.ini -jar spring-boot-0.0.1-SNAPSHOT.jar
