# AuditSpring

- import maven project and run in a container like Tomcat, User:john, password:password


Audit with Spring AOP
- Audit file can view in /audit.log in the root filesystem
- Important files: AuditInterceptor.java, log4j.properties, AOPConfig.java
- Internally runs with inmemory database and it's recreated every time the project runs.
