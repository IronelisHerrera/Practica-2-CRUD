# Práctica-2-6-CRUD-PaaS-Programación-Web-1

Este repositorio consta de dos implementaciones:
- CRUD utilizando el framework Spark para aplicaciones web en Java. 
- Implementación del CRUD en una plataforma orientada a servicios – PaaS. Las configuraciones fueron hechas para subir el proyecto mismo a la plataforma de Heroku.

Aclaraciones:
- Práctica de fin educativo.
- Ver la aplicación corriendo en Heroku: https://afternoon-spire-55955.herokuapp.com/
- Por defecto, Spark corre en http://localhost:4567/. Sin embargo, este proyecto funciona en el 8080. Para poder usarlo en el 4567, comentar los bloques
de código especificados en la clase principal.
- Heroku necesita un archivo Procfile con la ruta del archivo jar. Generar este archivo en construir (Build Gradle) en caso de no encontrarlo en su proyecto local.
- Para el frontend se utilizó Freemarker junto con Bootstrap.
- Revisar los pdfs adjuntos. Estos tienen los requerimientos de ambas prácticas.
