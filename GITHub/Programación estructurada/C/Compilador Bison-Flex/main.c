/*
Integrantes:
150.571-3 Nuñez Federico
146.245-3 Quattrini Patricio
150.332-7 Gomez Dario
156.685-4 Alarcon Melanie
*/

#include <stdio.h>
#include "scanner.h"
#include "parser.h"
#include "semantic.h"
#include "symbol.h"

int yysemerrs =0;
int yynerrs = 0;
int yylexerrs = 0;
int main() {
	switch( yyparse() ){
	case 0:
		puts("Compilación terminada con exito");
		break;
	case 1:
		puts("Errores de compilación");	
		break;
	case 2:
		puts("Memoria insuficiente");
		break;
	}
	printf("Errores léxicos: %d - Errores sintácticos: %d\n - Errores semánticos: %d\n",yylexerrs,yynerrs,yysemerrs);
return 0;
}

void yyerror(const char *s){
	printf("línea #%d: %s\n", yylineno, s);
	return;
}
