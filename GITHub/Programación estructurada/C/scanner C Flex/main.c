/*
Integrantes:
150.571-3 Nuñez Federico
146.245-3 Quattrini Patricio
150.332-7 Gomez Dario
156.685-4 Alarcon Melanie
*/

#include "tokens.h"
#include "scanner.h"
#include <stdio.h>

char *token_names[] = {"EOF", "Programa","Variables","Definir","Código","Leer","Escribir","Fin", "Constante entera", "Identificador","Asignación"};
int main() {
	enum token t;
	while ((t = yylex()) != FDT)
		switch(t){
		case ID:
		case CONS:
		printf("Token: %s\t\tLexema: %s\n", token_names[t], yytext);
		break;
		case ',':
		case ';':
		case '(':
		case ')':
		case '+':
		case '*':
		case '/':
		case '-':
		printf("Token: '%s'\n",yytext);
		break;
		case ASIG:
		case PROGRAMA:
		case VARIABLES:
		case DEFINIR:
		case CODIGO:
		case LEER:
		case ESCRIBIR:
		case FIN:
		printf("Token: %s\n",token_names[t]);
		break;
		default:
		break;
		}
	printf("Fin de texto\n");
	return 0;
}
