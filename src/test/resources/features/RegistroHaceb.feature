#language: es

Característica: Registro de usuario
  Yo como usuario quiero registrarme a la pagina haceb.com

  @RegistroUsuario
  Escenario:Regisrtro de usuario exitoso
    Dado que el usuario ingresa a la pagina haceb.com
    Cuando el usuario llena el formulario de registro
    Y Ingresamos los datos adicionales para terminar el registro
      | Cedula     | Genero    | Fecha_nacimiento | Codigo | Numero_contacto | Departamento | Ciudad |
      | 1703335666 | Masculino | 29031978         | +57    | 3106547795      | Córdoba      | Lorica |
    Entonces el usuario visualiza informacion de su perfil.


  @agregarproductos
  Escenario:Agregar prodcutos al carrito de compras de forma exitosa
    Dado que el usuario ingresa a la pagina haceb.com
    Cuando ingresa a categorias electrodomesticos de cocina
    Y selecciona una subcategoria agrega productos al carrito
    Entonces el usuario visualiza el campo de "Entreg"

