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
