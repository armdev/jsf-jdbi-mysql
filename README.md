# jsf-jdbi-mysql
JSF 2.2 JDBI and MySQL full example, CRUD
Project working under Apache Tomcat 8
1. Create database in mysql using mydb.sql script
2. Put following in tomcat context.xml file
####
<Resource
   # name = "jdbc/mysql"
   # auth = "Container"
   # type = "javax.sql.DataSource"
   # maxActive ="100"
   # maxIdle = "30"
   # maxWait = "10000"
   # driverClassName = "com.mysql.jdbc.Driver"
   # url = "jdbc:mysql://localhost:3306/mydb"
   # username = "root"
   # password = "root"       
#/>
#########

You can change mysql user/pass if yours is different.
Run web project.
Used JSF2.2, Primefaces, JDBI, Twitter Bootstrap.

