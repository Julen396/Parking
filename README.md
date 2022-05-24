![java ci workflow](https://github.com/julen396/parking/actions/workflows/javaci.yml/badge.svg) [![coverage](https://sonarcloud.io/api/project_badges/measure?project=Julen396_Parking&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Julen396_Parking) [![codecov](https://codecov.io/gh/Julen396/Parking/branch/main/graph/badge.svg?token=VWV6C72V4T)](https://codecov.io/gh/Julen396/Parking)

# Parking
Aplicación para la gestión de un parking, formada por varios gestores y un administrador.

El script de la creación de la base de datos es (También puede ser encontrado en src/sql/create-parking.sql):
Contrucción y prueba
Se puede contruir el proyecto y lanzar pruebas unitarias con el comando:
```
mvn test
```
Base de datos (Hay que ejecutar estas sentencias en MySQL)
```maven
DROP SCHEMA IF EXISTS parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA parkingDB;
CREATE USER 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON parkingDB.* TO 'spq'@'localhost';
```
Las clases de datos deben ser procesadas antes de generar las tablas con el comando:
```
mvn datanucleus:enhance
```
Para la creacion de las tablas se debe ejecutar el comando de maven
Una vez hecho esto, hacer la creación/eliminación del esquema de Base de Datos:

```maven
mvn clean compile
mvn datanucleus:schema-delete/mvn datanucleus:schema-create
```
Después, ejecuta el servidor:

```maven
mvn exec:java
```

Finalmente, ejecuta la aplicación:
```maven
mvn javafx:run
```
Documentacion:
```
mvn doxygen:report
```
