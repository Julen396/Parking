# Parking
Aplicación para la gestión de un parking, formada por varios gestores y un administrador.

El script de la creación de la base de datos es (También puede ser encontrado en src/sql/create-parking.sql):

```maven
DROP SCHEMA IF EXISTS parkingDB;
DROP USER IF EXISTS 'spq'@'%';

CREATE SCHEMA parkingDB;
CREATE USER 'spq'@'%' IDENTIFIED BY 'spq';
GRANT ALL ON parkingDB.* TO 'spq'@'%';
```

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
