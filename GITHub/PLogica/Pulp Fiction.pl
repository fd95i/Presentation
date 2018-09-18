%Base de conocimientos 
pareja(marsellus, mia).
pareja(pumkin,    honeyBunny).

%trabajaPara(Empleador, Empleado)
trabajaPara(marsellus, vincent).
trabajaPara(marsellus, jules).
trabajaPara(marsellus, winston).

%Información base
personaje(pumkin,     ladron([licorerias, estacionesDeServicio])).
personaje(honeyBunny, ladron([licorerias, estacionesDeServicio])).
personaje(vincent,    mafioso(maton)).
personaje(jules,      mafioso(maton)).
personaje(marsellus,  mafioso(capo)).
personaje(winston,    mafioso(resuelveProblemas)).
personaje(mia,        actriz([foxForceFive])).
personaje(butch,      boxeador).
personaje(bernardo,   mafioso(cerebro)).
personaje(bianca,     actriz([elPadrino1])).

%encargo(Solicitante, Encargado, Tarea). 
encargo(marsellus, vincent,   cuidar(mia)).
encargo(vincent,  elVendedor, cuidar(mia)).
encargo(marsellus, winston, ayudar(jules)).
encargo(marsellus, winston, ayudar(vincent)).
encargo(marsellus, vincent, buscar(butch, losAngeles)).
encargo(bernardo, vincent, buscar(jules, fuerteApache)).
encargo(bernardo, winston, buscar(jules, sanMartin)).
encargo(bernardo,  winston, buscar(jules, lugano)).

amigo(vincent, jules).
amigo(jules, jimmie).
amigo(vincent, elVendedor).

%Entrega1

%Ejercicio1
saleCon(Quien,Cual):- 
	pareja(Quien,Cual).
	
saleCon(Quien,Cual):- 
	pareja(Cual,Quien).
	


%Ejercicio2
pareja(bernardo,bianca).
pareja(bernardo,charo).

%Como no sabemos si demostenes es pareja de bianca(creo), no se declara por principio de universo cerrado.

%Ejercicio3
trabajaPara(Quien,bernardo):-
	trabajaPara(marsellus,Quien), Quien\=jules.
	
trabajaPara(Quien,george):-
	saleCon(bernardo,Quien).

%Ejercicio4
esFiel(Personaje):-
	saleCon(Personaje,Alguien) , not((saleCon(Personaje,Alguien),saleCon(Personaje,Alguienmas), Alguien \= Alguienmas)).

%Ejercicio5
acataOrden(Empleador, Empleado):-
	trabajaPara(Empleador, Empleado).
	
acataOrden(Empleador, Empleado):-
	trabajaPara(Empleador,EmpleadoI), acataOrden(EmpleadoI,Empleado).
	
	
	
%Entrega2

%Ejercicio1
esPeligroso(Quien):- 
	trabajaPara(Empleado,Quien),esPeligroso(Empleado).
	
esPeligroso(Quien):- 
	realizaActividadPeligrosa(Quien).
	
realizaActividadPeligrosa(Quien):-
	personaje(Quien,ladron(Lugares)),member(licorerias,Lugares).
	
realizaActividadPeligrosa(Quien):-
	personaje(Quien,mafioso(maton)).

%Ejercicio2
tieneCerca(Alguien, Otro):-
	trabajaPara(Alguien,Otro).
	
tieneCerca(Alguien, Otro):-
	amigo(Alguien,Otro).

sanCayetano(Quien):-
	tieneCerca(Quienes,Quien), forall(tieneCerca(Quienes,Quien), encargo(Quien,Quienes,_)).

%Ejercicio3
nivelRespeto(Quien,10):- 
	personaje(Quien,mafioso(resuelveProblemas)).
	
nivelRespeto(Quien,20):- 
	personaje(Quien,mafioso(capo)).
	
nivelRespeto(vincent,15).
	
nivelRespeto(Quien,Nivel):- 
	personaje(Quien,actriz(Peliculas)), length(Peliculas,CantidadDePeliculas), Nivel is CantidadDePeliculas/10.

%Ejercicio4
respetable(Personaje):-
	nivelRespeto(Personaje, Nivel), Nivel > 9.

encontrarRespetables(Respetables):-
	findall(Personaje,respetable(Personaje), Respetados), length(Respetados,Respetables).

encontrarNoRespetables(NoRespetables):-
	findall(Personaje,(personaje(Personaje,_),not(respetable(Personaje))), Respetados), length(Respetados,NoRespetables).

respetabilidad(Respetables,NoRespetables):-
	encontrarRespetables(Respetables), encontrarNoRespetables(NoRespetables).

%Ejercicio5
cantidadEncargos(Personaje,Cantidad):- 
    findall(Encargo,encargo(_, Personaje, Encargo),Encargos), length(Encargos,Cantidad).

persona(Personaje):- encargo(_,Personaje,_).

tieneMasEncargos(Personaje,OtroPersonaje):-
cantidadEncargos(Personaje,Cantidad),cantidadEncargos(OtroPersonaje,Cantidad2), Personaje \= OtroPersonaje, Cantidad > Cantidad2 .

masAtareado(Personaje):-
persona(Personaje).
masAtareado(Personaje):-
persona(Personaje),
forall((persona(Personaje),persona(OtroPersonaje)),tieneMasEncargos(Personaje,OtroPersonaje)).


%Entrega3

%Ejercicio1
escuadron(Personas) :- escuadronesPosibles(ListaEscuadrones), escuadrones(ListaEscuadrones, Personas), cumpleRespeto(Personas).

escuadronesPosibles(ListaEscuadrones) :- findall(Quien, personaje(Quien, _), ListaEscuadrones).

escuadrones([], []).
escuadrones([Personaje | Resto1], [Personaje | Resto2]) :- respetable(Personaje), escuadrones(Resto1, Resto2).
escuadrones([_| Resto], ListaEscuadrones) :- escuadrones(Resto, ListaEscuadrones).

cumpleRespeto(Personas) :- nivelRespetoTotal(Personas, Nivel), Nivel > 15.

nivelRespetoTotal([],0).
nivelRespetoTotal([Personaje | Resto], Nivel) :- nivelRespeto(Personaje,Nivel1), nivelRespetoTotal(Resto, Nivel2), Nivel is Nivel1 + Nivel2.