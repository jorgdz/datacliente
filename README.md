# Conexión de Quarkus Java con base de datos Sybase

Si bien es cierto el ejemplo está con Quarkus sin embargo puede ser aplicado a un proyecto Java normal o incluso spring.

#### Dependencias: ####
Lo primero que necesitamos es agregar las dependencias necesarias:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-agroal</artifactId>
</dependency>

<dependency>
    <groupId>com.sybase.jdbcx</groupId>
    <artifactId>jconn4d</artifactId>
    <version>1.2</version>
    <scope>system</scope>
    <systemPath>${pom.basedir}/lib/jconn4.jar</systemPath>
</dependency>
```

Con la dependencias **sybase**, si bien es cierto no existe en el Maven Repository, sin embargo la podemos descargar desde internet, y posterior a eso la agregamos en una carpeta en la raiz del proyecto para que cuando se compile no la busque desde internet si no que la busque en un directorio en específico en el proyeto local.

![lib](docs/1.png)

Y Listo!

El siguiente paso, es configurar nuestro archivo de conexión, en el caso de quarkus, agregar al *application.properties* lo siguiente.

```sh
quarkus.datasource.db-kind=other
quarkus.datasource.username=sa
quarkus.datasource.password=
quarkus.datasource.jdbc.driver=com.sybase.jdbc4.jdbc.SybDriver
quarkus.datasource.jdbc.url=jdbc:sybase:Tds:DESKTOP-Q1SGOM8:5000/gizlo_test?SERVER_INITIATED_TRANSACTIONS=false&connect_timeout=2sec
```

#### Código fuente para conectar a la base de datos.
Crearemos una clase de repositorio y la inyectamos como **ApplicationScoped**, 

```java
@ApplicationScoped
public class ClienteRepositoryManager {}
```

Inyectamos nuestro AgroalDataSource para obtener la conexión a la Base de datos.

```java
@Inject
AgroalDataSource dataSource;
```

Función que consulta un store procedure de Sybase con Java.

```java
public List<Cliente> findByIdentification (String identification) throws SQLException {
    Connection connection = null;   // Inicializamos la variable de conexión
    CallableStatement cstmt = null;  // Inicializamos la variable para realizar la llamada del SP.
    ResultSet resultSet = null;  // Inicializamos la variable para obtener el resultado que nos devuelve el store procedure.

    List<Cliente> clientes = new ArrayList<>();

    try {
        connection = dataSource.getConnection();  // Obtener la conexión de Base de datos
        cstmt = connection.prepareCall("{call gizlo_test..sp_clientes (?)}"); // Llamada el Store procedure.
        cstmt.setString(1, identification); // Seteamos el parámetro de búsqueda.
        resultSet = cstmt.executeQuery(); // Ejecutamos la llamada del SP al Base.

        while (resultSet.next()) {   // Recorremos los resultados.
            Cliente cliente = new Cliente();
            cliente.setIdentificacion(resultSet.getString("identificacion"));
            cliente.setNombres(resultSet.getString("nombres"));
            cliente.setApellidos(resultSet.getString("apellidos"));
            clientes.add(cliente);
        }
    } finally {
        resultSet.close();
        cstmt.close();
        connection.close();
    }

    return clientes;
}
```