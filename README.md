# ReviewISPW


ReviewISPW was developed for the exam "Software Engineering and Web Application".

This standalone represents a part of an e-commerce web application, 
showing how review system and segnalation system work.

Another standalone like this can be found at 

https://github.com/simonedaniello/researchISPW

## Prerequisites

this standalone needs a database system to run.

PostgreSQL was used in development but everyone can change database system modifying Provider class (src/databaseINIT/Provider).

You have to create you're own database and connect it on you're IDE.
After you've done it, you can run DBinit.sql (src/databaseINIT/DBinit.sql) and it will create schemas on this database automatically.

You can test this standalone using running main function in src/testing/TestuRunner. 
JUnit JARs can be downloaded here

https://github.com/junit-team/junit4/wiki/Download-and-Install
##Development environment

* IDEA IntelliJ - IDE
* Postgresql 9.4.1210 - Database system
* JUnit 4.12 - Testing framework

##Author

* Simone D'Aniello - Student at University of Rome Tor Vergata