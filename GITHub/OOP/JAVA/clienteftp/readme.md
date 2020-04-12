Documentacion:

Sobre el proyecto: Cliente FTP el cual se conecta con una DB para hacer CRUD(ABM) de las conexiones, a las cuales se puede conectar para subir, bajar, borrar o buscar archivos.

Sobre el diseño: La estructura del proyecto es un MVC, desarrollado en Java y conectado a la base de datos mediante servicios, modelos y objetos de acceso a los datos (DAO). A su vez la parte visual está desarrollada en Swing, el Framework visual de Java.

Estructura de las clases:

Class <NombreDeClase> {
	--nroSerial

	--Service de la Conexion con la DB

	--Manager de cambio de ventanas (PanelManager)

	--Labels (etiquetas - Swing)

	--Textfields (campos de Texto - Swing)

	--Buttons (botones - Swing)

	--Atributos (propios de la clase)

	
	<Constructor>

	<MetodosDelConstructor> 

	<ComportamientoYValidaciones>
}

Métodos Comunes: 

- createAllComponents(): Crea las instancias de los Componentes del Layout. No retorna nada.
- setAllComponentsValues(): Asigna a los Componentes sus valores iniciales y propiedades, de ser necesario. No retorna nada.
- addAllComponentsToLayout(): Agrega los Componentes instanciados y seteados al Layout. No retorna nada.
- setListeners(): Asigna a los Componentes sus respectivos Escuchadores de evento, utilizando expresiones anónimas (lambda). No retorna nada.
- validarConexion(Conexion con): Verifica valores nulos o errores de ID en los datos de una Conexión, arrojando una Excepción en caso de poseer alguno. No retorna nada.

Métodos propios de cada Clase:

<AltaConexion>
- cargarDatosConexion(Conexion conexion): Asigna a una conexión los valores que se encuentran en los Textfields.

<BajaConexion>
- validarID(int id): Valida que la cadena que se encuentra en el Textfield ID sea un entero parseable y válido, lanzando una Excepción en caso contrario. No retorna nada.

<BarraMenu>
- armarBarra(): Arma la barra del menú. No retorna nada.

<ConexionSimple>
- conectarA(Conexion conexion): Gestiona una conexión FTP con los datos de la conexión en los TextFields. No retorna nada.
- iniciarLayoutFTP(): Inicia el Layout del cliente FTP. No retorna nada.

<ConexionTableModel>
"solo posee métodos sobreescritos de la clase Padre".

<FTPView>
- initLeftPanel()/initRightPanel(): Inicia los paneles visuales del lado Cliente/Servidor. No retorna nada.
- refreshList(String nuevoDir): Actualiza la lista de archivos según el directorio actual. No retorna nada.
- refreshCliList(String nuevoDir): Actualiza la lista de archivos del Cliente según el directorio actual. No retorna nada.

<GrillaConexion>
- obtenerRegistroSeleccionadoEnTabla(): Devuelve el registro clickeado por el mouse obteniendo su Model. Retorna una Conexion(modelo).

<ModificarConexion>
- camposEditables(boolean valor): Asigna los campos en Solo Lectura/Lectura y Escritura. No retorna nada.
- validarID(int id): Valida que la cadena que se encuentra en el Textfield ID sea un entero parseable y válido, lanzando una Excepción en caso contrario. No retorna nada.
- cargarDatosConexion(Conexion conexion): Asigna a una conexión los valores que se encuentran en los Textfields.


Conceptos:
+Reutilización de código: Se redujeron a la mínima expresión la cantidad de métodos iguales posibles con el fin de aprovechar y reutilizar lógica.

+Acoplamiento: Hay un mínimo nivel de acoplamiento dado que las vistas apenas intercambian información.
Encapsulamiento: Todos los atributos y casi todos los métodos son privados, no se rompe el encapsulamiento o el estado interno de la Clase.

+Expresiones Anónimas: Se utilizaron expresiones anónimas a fin de reducir la cantidad de lineas de código y de maximizar la expresividad de la declaración. Dichas expresiones reciben un parámetro y lo operan acorde al comportamiento expresado después de la flecha (->). Se les llama anónimas porque no tienen un nombre, solo operan valores.

+Bloques try/catch y UserExceptions: Se utilizan constantemente Excepciones creadas por el desarrollador para validaciones y chequeos de datos para así minimizar las validaciones con condicional, lo cual se considera mala práctica.
