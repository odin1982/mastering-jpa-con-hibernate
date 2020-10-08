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
