# CDRS Service and Algorithm Task

## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
```
spring.datasource.url= jdbc:mysql://xxxxxxxxxxxxx
spring.datasource.username= xxxxx
spring.datasource.password= xxxx
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update
```
## Run Spring Boot application
```
mvn spring-boot:run
```
## Deployed API Instance
http://cdrs-service.herokuapp.com
