# log4j-vul
This project is just to show Apache Log4j2 Vulnerability - aka CVE-2021-44228

Java:
========
java version "1.8.0_121"

Compile:
========
(from src folder)
javac -classpath .;lib/log4j-api-2.1.jar;lib/log4j-core-2.1.jar com\example\Log4jVul.java

Execute\Run:
=============
(from src folder)
java -classpath .;lib/log4j-api-2.1.jar;lib/log4j-core-2.1.jar com.example.Log4jVul Bhanu

Output:
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
11:29:08.081 [main] ERROR com.example.Log4jVul - ** Username: Bhanu**

Vulnerability show:
===================
(from src folder)
java -classpath .;lib/log4j-api-2.1.jar;lib/log4j-core-2.1.jar com.example.Log4jVul ${java:version}

Output:
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
11:34:04.110 [main] ERROR com.example.Log4jVul - ** Username: Java version 1.8.0_121**

NOTICE: output is "Java version 1.8.0_121" ********************





