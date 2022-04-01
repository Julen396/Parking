# Parking
Aplicación para la gestión de un parking, formada por varios gestores y un administrador.

Para ejecutar la aplicación:

mvn clean javafx:run OR mvn javafx:run

Para probar el servidor

mvn exec:java

Para hacer la creación/eliminación del esquema de Base de Datos

mvn clean compile
mvn datanucleus:schema-create/mvn datanucleus:schema-delete