# Parking
Aplicación para la gestión de un parking, formada por varios gestores y un administrador.

El script de la creación de la base de datos es (También puede ser encontrado en src/sql/create-parking.sql):
Contrucción y prueba
Se puede contruir el proyecto y lanzar pruebas unitarias con el comando
```
mvn test
```
Base de datos
```maven
DROP SCHEMA IF EXISTS parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA parkingDB;
CREATE USER 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON parkingDB.* TO 'spq'@'localhost';
```
Las clases de datos deben ser procesadas antes de generar las tablas con el comando
```
mvn datanucleus:enhance
```
Para la creacion de las tablas se debe ejecutar el comando de maven
Una vez hecho esto, hacer la creación/eliminación del esquema de Base de Datos:

```maven
mvn clean compile
mvn datanucleus:schema-create/mvn datanucleus:schema-delete
```
Después, ejecuta el servidor:

```maven
mvn exec:java
```

Finalmente, ejecuta la aplicación:
```maven
mvn clean javafx:run OR mvn javafx:run
```
