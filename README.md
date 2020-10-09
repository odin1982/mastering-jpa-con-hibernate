# @Entity
    Le indicamos que nuestra clase es una entidad

# @Id 
    Tiene que ser serializables

GenerationType.AUTO
    JPA decidira cual es el mas conveniente
    No es estable
    Mala tecnica de programación


# @Transient
    Anotacion que indica que una propiedad no debe ser persistida
    Refleja que estamos mezclando logica de negocio que no debe de ir

# detach
JPA tiene un cache que guarda todas las entidades que ha cargado en el pasado
si queremos que esas entidades ya no esten en el cache se hace un DETACH


# HashCode - Equals
Como buena practica de programacion hay que sobreescribir los metodos hashCode y Equals y se debe seleccionar solamente el campo Id


# persistence.xml

Ubicacion predeterminada ----> META-INF/persistence.xml
Archivo principal de JPA


# Persistence Unit
    - Como JPA se va a conectar a la BD.
    - Puede soportar mas de una unidad de persistencia, pero es muy raro en ambiente    productivo.
    - Que entidades va a administrar.
    - Conexion BD
    - Propiedades de conexion, mostrar SQL, performance
    - Como debe ser creado el schema.

    <persistence-unit name="jpa" transaction-type="RESOURCE_LOCAL">
    
    persistence-unit name="jpa"         ----> Nombre de la unidad de persistencia
    transaction-type                    ----> Como queremos manejar las transacciones
    transaction-type="RESOURCE_LOCAL"   ----> Aplicaciones de escritorio
    transaction-type="JTA"              ----> Par entornos empresariales donde el servidor de aplicaciones es el encargado

    <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL55Dialect"/>
    Como hibernate va a interpretar las entidades o queries en sql nativo de la BD

    <property name="hibernate.show_sql" value="true"/>
    Imprime consultas

    <property name="javax.persistence.schema-generation.database.action" value="none"/>
    La forma en como se va  a crear nuestra base de datos
    

# EntityManger
    Se crea apartir de la unidad de persistencia.

# merge
    hazme un select con el where del id,administrala y despues actualizala.

# JPQL
    Java Persistence Query Language


