mira(juan,himym).
mira(juan,futurama).
mira(juan,got).
mira(nico,starWars).
mira(maiu,starWars).
mira(maiu,got).
mira(maiu,onePiece).
mira(nico,got).
mira(gaston,hoc).

persona(juan).
persona(aye).
persona(maiu).
persona(gaston).
persona(nico).

populares(hoc).
populares(got).
populares(starWars).

quiereVer(juan,hoc).
quiereVer(aye,got).
quiereVer(gaston,himym).

amigo(nico, maiu).
amigo(maiu, gaston).
amigo(maiu, juan).
amigo(juan, aye).

got(12,3).
got(10,2).

himym(23,1).

drHouse(16,8).

/*No se escribe por ejemplo que Alf no ve ninguna serie,
 o que no sabemos cuantos capitulos tiene Mad Men porque 
 todo lo que no esta en la base de conocimiento se asume
 falso (Universo cerrado). Entonces no tendria sentido hacer un hecho de algo
 que es falso.*/
 
%----------------------Punto1-------------------------------
 %paso(Serie, Temporada, Episodio, Lo que paso)
paso(futurama, 2, 3, muerte(seymourDiera)).
paso(starWars, 10, 9, muerte(emperor)).
paso(starWars, 1, 2, relacion(parentesco, anakin, rey)).
paso(starWars, 3, 2, relacion(parentesco, vader, luke)).
paso(himym, 1, 1, relacion(amorosa, ted, robin)).
paso(himym, 4, 3, relacion(amorosa, swarley, robin)).
paso(got, 4, 5, relacion(amistad, tyrion, dragon)).

%leDijo/4
leDijo(gaston, maiu, got, relacion(amistad, tyrion, dragon)).
leDijo(nico, maiu, starWars, relacion(parentesco, vader, luke)).
leDijo(nico, juan, got, muerte(tyrion)). 
leDijo(aye, juan, got, relacion(amistad, tyrion, john)).
leDijo(aye, maiu, got, relacion(amistad, tyrion, john)).
leDijo(aye, gaston, got, relacion(amistad, tyrion, dragon)).
%------------------------Punto2-----------------------------
esEspoiler(Serie,Espoiler):-
	paso(Serie,_,_,Espoiler).

/* Se pueden hacer consultas existenciales, dejando elementos libres
para saber que individuos hacen a la consulta verdadera.*/

%-------------------------Punto3-----------------------------

leEspoileo(Persona1,Persona2,Serie):-
	leDijo(Persona1,Persona2,Serie,_),
	esEspoiler(Serie,Espoiler),
	mira(Persona2,Serie).
	
leEspoileo(Persona1,Persona2,Serie):-
	leDijo(Persona1,Persona2,Serie,_),
	esEspoiler(Serie,Espoiler),
	quiereVer(Persona2,Serie).

%------------------------Punto4-------------------------------
televidenteResponsable(Persona):-
	persona(Persona),
	not(leEspoileo(Persona,_,_)).


%----------------------Punto5--------------------------------
vieneZafando(Persona2,Serie):-
	forall(mira(Persona2,Serie),not(leDijo(Persona1,Persona2,Serie,_))).

%---------------------Punto6---------------------------------

%---------------------PrimeraEntrega-------------------------


malaGente(Persona) :-
	forall(leDijo(Persona,Serie),leEspoileo(Persona,Persona2,Serie)),
	mira(Persona,Serie).

malaGente(Persona) :-
	forall(not(mira(Persona,Serie)),leEspoileo(Persona,Persona2,Serie)),
	not(mira(Persona,Serie)).

%-----------------------Punto1--------------------------------


popular(Serie):-
	popularidad(Serie,CantidadMiran1),
	popularidad(starWars,CantidadMiran2),
	CantidadMiran1 >= CantidadMiran2.
	

popularidad(Serie,Numero):-
	cantidadQueMiran(Serie,CantidadMiran),
	cantidadConversaciones(Serie,CantidadConvesaciones),
	Numero is CantidadMiran * CantidadConvesaciones.

cantidadQueMiran(Serie,CantidadMiran):-
	findall(Persona,mira(Persona,Serie),Lista1),
	lenght(Lista1,CantidadMiran).

cantidadConversaciones(Serie,CantidadConvesaciones) :-
	findall(Persona,leDijo(Persona,_,Serie,_),Lista2),
	lenght(Lista2,CantidadConvesaciones).



fullSpoil(Persona1,Persona2) :-
	amigo(Persona2,Amigo),
	leEspoileo(Persona1,Amigo).

fullSpoil(Persona1,Persona2) :-
	leEspoileo(Persona1,Persona2,_).
