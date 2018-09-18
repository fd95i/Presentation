#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "symbol.h"
#include "parser.h"

int Temp = 1;
char * bufferSem;
char temporales[100]; 
char* temp(){
	static int numero = 1;
	sprintf(temporales,"Temp#%d",numero);
	numero++;
	return temporales;
};

void crearBufferSem(char * s,char * lexema){
	bufferSem = malloc(100);
	strcpy(bufferSem,s);
	strcat(bufferSem,lexema);
}


//rutinas semanticas

void comenzar(){
	printf("Load rtlib,\n");
}

void definir(char * id){
	if(!estaDefinido(id)){
	aniadir(id);
	printf("Declare %s,Integer\n",id);
	}
}

void store(char * id1, char * id2){
	printf("Store %s,%s\n",id2,id1);
}

void leer(char * id){
	printf("Read %s,Integer\n",id);
}

void escribir(char * id){
	printf("Write %s,Integer\n",id);
}

//operaciones
char * generarInfijo(char* id1, char * id2, char op){
	char* temporal = strdup(temp());
	definir(temporal);
	switch(op){ 
		case '+':
			printf("ADD %s,%s,%s\n",id1,id2,temporal);
			Temp++;
			break;
		case '-':
			printf("SUBS %s,%s,%s\n",id1,id2,temporal);
			Temp++;			
			break;
		case '*':
			printf("MULT %s,%s,%s\n",id1,id2,temporal);
			Temp++;
			break;
		case '/':
			printf("DIV %s,%s,%s\n",id1,id2,temporal);
			Temp++;
			break;
		default: break;
}
return temporal;
}

char* invertir(char * id){
	char* temporal;
	temporal = strdup(temp());
	printf("Declare %s,Integer\n",temporal);
	printf("INV %s,,%s\n",id,temporal);
	Temp++;
	return temporal;
}

void idNoDeclarado(char* id){
	crearBufferSem("Error semántico: identificador NO declarado: ",id);
	yysemerrs++;
	yyerror(bufferSem);
	free(bufferSem);
}

void idYaDefinido(char* id){
	crearBufferSem("Error semántico: identificador ya declarado: ",id);
	yysemerrs++;
	yyerror(bufferSem);
	free(bufferSem);
	}

void stop(){
	printf("Stop ,\n");
}


