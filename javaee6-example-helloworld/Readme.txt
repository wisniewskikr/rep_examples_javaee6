DESCRIPTION
===========

This is example project built by using Rest and Java EE 6. It consists of two pages:
- input page		: here you can type your name;
- output page		: here your name is displayed after text "Hello World"

This project shows how to use Rest and Java EE 6 together with:
- java script;
- css;
- validation.

To use CDI in Rest you have to:
- in web.xml add
<init-param>
	<param-name>javax.ws.rs.Application</param-name>
    <param-value>pl.kwi.rest.confs.MyApplication</param-value>
</init-param>
- add class pl.kwi.rest.confs.MyApplication;
- add class pl.kwi.rest.confs.MyApplicationBinder.    	

Recommended deployment of project:
----------------------------------
Maven command:
mvn clean install -Ploc,deploy 

Recommended usage of project:
-----------------------------
Browser url:
http://localhost:8080/javaee6-example-helloworld





JAVA EE 6 INSTALLATION STEPS
============================

Java EE 6 instalation steps depends on Server. If you use server supporting
this Java (JBoss 7, Glassfish etc.) then you don`t have to do anything. Otherwise
you have to add missing parts. For instance Tomcat 7 supports Servlets 3.0 but
does not support Dependency Injection. To use it developer has to:
- add Weld dependency in Maven;
- add file beans.xml to WEB-INF or META-INF;
- add listener to file web.xml.





PRECONDITIONS
=============

1. TOOLS
--------
This example project requires:
- Java (tested for version 1.7.0_10);
- Maven (tested for version 3.0.4);
- Tomcat (tested for version 7.0.34).

2. CONFIGURATION
----------------
All flexible configuration of project (server`s urls, logins, passwords etc.) can be changed in file:
<project_home>/project.properties





DEPLOYMENT
==========

You can deploy this application in two ways:
1. Copy war file
2. Use Maven plugin for deployment


Ad 1\ Copy war file
===================
You can do it using following steps:
- Open console;
- Go to project folder "javaee6-example-helloworld";
- Use Maven command for building project. Command: 
  
  mvn clean install
  
- Copy file "javaee6-example-helloworld.war" from <project_home>/target to <tomcat_home>/webapp


Ad 2\ Use Maven plugin for deployment
=====================================  
You can do it using following steps:
- Go to <tomcat_home>/conf/tomcat-users.xml and add user in manager role. For instance:

  <user username='admin' password='admin' roles='manager-gui,admin-gui,manager-script'/>
  
- Set server informations in file: <project_home>/project.properties. You have to set:
  loc.server.url, loc.server.username, loc.server.password;  
- Open console;
- Go to project folder "javaee6-example-helloworld";
- Use Maven command for building and deployment project. Command:
 
  mvn clean install -Ploc,deploy  





USAGE
=====

Type in browser:

http://localhost:8080/javaee6-example-helloworld