<div align="center">
    <img src="https://www.armadilloamarillo.com/wp-content/uploads/spring-boot-ok.png" width=400px"> </img> 
    
<!-- Encabezado -->
## Prueba técnica | Productos por departamento
## Junio 2022
### Autor 


| Nombre | Identidad | Correo |
|:-------------:| :-----:|:-----:|
| Edgar Josué Benedetto Godoy | `0801-1997-23600` | [Gmail](mailto:ejbg597@gmail.com) |

</div>

_____
_____

## Proyecto de Sitio Web para una Tienda de productos por Departamento 
### Instrucciones Generales
* El proyecto debe realizarlo de forma individual sin la colaboración de otra persona. 
* Podrá utilizar Bases de Datos relacionales (MySQL, Postgress) 
* Podra utilizar el servidor de aplicaciones de su preferencia (nginx, IIS, Tomcat, Apache, ...) 
* Se deberá programar la solución en lenguaje java (SpringBoot).
* Para el desarrollo del frontEnd(interfaces) es requerido que desarrolle funciones, clases o código en JavaScript, por ejemplo para despliegue de mensajes, validaciones de campos y llamados Ajax. 
* Deberá desarrollar al menos un servicio web que por medio de Ajax lo pueda invocar y obtener información en json para el despliegue de datos correspondiente. 
* La interfaz del sitio debe ser visualmente atractiva, puede utilizar bootstrap. 
* Debe de trabajar el proyecto en capas (Interfaz, lógica y acceso a los datos) 
### Detalles del proyecto
Debe diseñar una base de datos que contenga las siguientes tablas: 
  1. Usuario
  2. Categoría de Productos (debe haber eliminación en cascada de productos) 
  3. Productos 

Debe diseñar un sitio web que contenga los siguientes módulos: 
   1. Pantalla de Login 
   2. Mantenimiento de Categorías 
   3. Mantenimiento de Productos 
   
- Para el Login, deberá poder crearse el usuario si es primer ingreso y guardar la contraseña encriptada en la base de datos.
- Para el mantenimiento de productos se deberá hacer una lista de los mismos por categoría. Debe haber una búsqueda de productos por el campo de descripción. 
- De la lista debe tener una opción para mostrar el detalle de un producto, incluyendo una imagen del mismo.
- Las imágenes se deben de almacenar en un directorio y en la base de datos solo almacenar la ruta de la misma. 
______
### Repositorio Github | Ramas
Para el repositorio de fuentes debe crear un proyecto público en GitHub, donde deberán de quedar las diferentes etapas de la evolución del proyecto identificadas por branch. 
<div align="center">
    <img src="https://1v5ymx3zt3y73fq5gy23rtnc-wpengine.netdna-ssl.com/wp-content/uploads/2021/03/git-flow-4.svg" width=400px"> </img> 
</div>

* **Main Branch** 
  * El propósito de la rama principal en el flujo de trabajo de Git es contener código listo para producción que se pueda publicar. 
  * En el flujo de Git, la rama principal se crea al comienzo de un proyecto y se mantiene durante todo el proceso de desarrollo. La rama se puede etiquetar en varias confirmaciones para indicar diferentes versiones o versiones del código, y otras ramas se fusionarán con la rama principal después de que hayan sido suficientemente examinadas y probadas.
* **Develop Branch**
  * La rama de desarrollo se crea al comienzo de un proyecto y se mantiene durante todo el proceso de desarrollo, y contiene código de preproducción con funciones recientemente desarrolladas que están en proceso de prueba. Las funciones recién creadas deben basarse en la rama de desarrollo y luego volver a fusionarse cuando estén listas para la prueba.
* Supporting Branches
  * Al desarrollar con el flujo de Git, hay tres tipos de ramas de soporte con diferentes propósitos: función (Feature), lanzamiento (Release) y revisión (HotFix).
* Feature Branch: 
  * La rama de características es el tipo de rama más común en el flujo de trabajo de flujo de Git. 
  * Se utiliza al agregar nuevas características a su código. 
  * Cuando trabaje en una nueva función, iniciará una rama de función a partir de la rama de desarrollo y luego fusionará sus cambios nuevamente en la rama de desarrollo cuando la función se complete y se revise correctamente.
* Release Branch:
  * La rama de lanzamiento debe usarse al preparar nuevos lanzamientos de producción. 
  * Por lo general, el trabajo que se realiza en las ramas de lanzamiento se refiere a los toques finales y errores menores específicos de la liberación de código nuevo, con código que debe abordarse por separado de la rama de desarrollo principal.
* **Hotfix Branch**
  * En el flujo de Git, la rama de revisión se usa para abordar rápidamente los cambios necesarios en su rama principal. 
  * La base de la rama de revisión debe ser su rama principal y debe fusionarse con las ramas principal y de desarrollo. 
  * La fusión de los cambios de la rama de revisión en la rama de desarrollo es fundamental para garantizar que la corrección persista la próxima vez que se publique la rama principal.

![Workflow](https://bezkoder.com/wp-content/uploads/2019/12/spring-boot-vue-js-crud-example-architecture.png)

______
## Desarrollo
### Configuracion de desarrollo 
1. Editor de Texto 
   1. Visual Studio Code
2. Extensiones
   1. Java Managment Projects
   2. Spring Book
   3. Lombok Anotations
   4. Vetur

### Flujo de desarrollo
#### Instalacion de dependencias
1. Crear un proyecto en Spring Boot con el Spring Initializr desde VSCode y llamarlo backend (alternativa a hacerlo en [Spring Boot](https://start.spring.io/))
2. Instalar dependencias del **frontend** al crear aplicacion con vue
   ```
   vue create frontend
   ```
3. Instalar dependencias del **backend** en el archivo pom.xml con click derecho seleccionar **Add Starter**
  1. Spring Boot Web
  2. Mysql Driver SQL
  3. Spring Data JPA SQL 
  4. Lombook
  5. 
   
### DataBase 
#### Configuración previa de Docker
1. En los recursos del proyecto de java
  ```
  #Mysql
  spring.datasource.username=admin 
  spring.datasource.password=admin
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.url=jdbc:mysql://localhost:3306/productsApp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
  #JPA
  spring.jpa.generate-ddl=false
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
  spring.jpa.show-sql=true
  #Table names physically
  spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
  spring.jpa.hibernate.use-new-id-generator-mappings=false
  ```
2. Crear el volumen externo
  ```
  docker volume create --name=mysql-volume
  ```

#### Validar la correcta ejecucion de mysql dockerizado

1. Ejecutar el contenedor
  ```
  docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=productsApp -d -p 3306:3306 mysql

  docker-compose up -d
  ```

2. Entrar al contenedor de mysql
  ```
  docker-compose exec mysql bash
  ```

3. Conectarse a mysql:
  ```
  mysql -h nombre_servidor -u nombre_usuario -p nombre_base_datos

  mysql -h localhost -u admin -p productsApp
  ```


  * Conectarse a mysql con el usuario root y cambiar zona horaria
  ```
  docker exec -it ProductsApp mysql -uroot -p 

  pass: admin

  Cambiar zona horaria: SET GLOBAL time_zone = '-6:00';
  ```

  * Crear un backup y restore de una db Mysql dockerizada
  ```
  # Backup
  docker exec CONTAINER /usr/bin/mysqldump -u root --password=root DATABASE > backup.sql

  # Restore
  cat backup.sql | docker exec -i CONTAINER /usr/bin/mysql -u root --password=root DATABASE
  ```
## Deploy en Heroku
1. Crear un backup de la base de datos
2. Instalar clearDB Mysql
  ```
  heroku addons:create cleardb:ignite
  ```
2. Imprimir las variables de entorno 
  ```
  heroku run -a productsbydepartment printenv

  PORT=14953
  SPRING_DATASOURCE_USERNAME=b4bf7af203d414
  SPRING_DATASOURCE_URL=jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_935f7825dc6b73b?password=e6b9865c&reconnect=true&user=b4bf7af203d414
  CLEARDB_DATABASE_URL=mysql://b4bf7af203d414:e6b9865c@us-cdbr-east-05.cleardb.net/heroku_935f7825dc6b73b?reconnect=true
  TERM=xterm
  JDBC_DATABASE_PASSWORD=e6b9865c
  JDBC_DATABASE_USERNAME=b4bf7af203d414
  SHLVL=0
  LD_LIBRARY_PATH=/app/.jdk/jre/lib/amd64/server:
  PS1=\[\033[01;34m\]\w\[\033[00m\] \[\033[01;32m\]$ \[\033[00m\]
  SPRING_DATASOURCE_PASSWORD=e6b9865c
  PATH=/app/.heroku/bin:/app/.jdk/bin:/usr/local/bin:/usr/bin:/bin
  DYNO=run.5617
  _=/usr/bin/printenv
  ```
3. Conectarse a la base de datos MySQL remota de Heroku
  ```
  mysql -u b4bf7af203d414 -pe6b9865c -h us-cdbr-east-05.cleardb.net

  pass: e6b9865c

  connect heroku_935f7825dc6b73b;
  ```



