%code top{
#include <stdio.h>
#include "scanner.h"
}
%code provides{
void yyerror(const char *);
extern int yylexerrs;
}
%define api.value.type {char *}
%define parse.error verbose
%defines "parser.h"
%output "parser.c"
%start programa
%token PROGRAMA VARIABLES CODIGO FIN
%token DEFINIR LEER ESCRIBIR
%token CONS ID
%token ASIG ":="
%precedence NEG
%left '+' '-' 
%left '*' '/'


%%
programa		: PROGRAMA VARIABLES definicionVariables CODIGO listaSentencias FIN { if (yynerrs || yylexerrs) YYABORT;};

definicionVariables	: variable
			| definicionVariables variable
	           	;

variable		: DEFINIR ID {printf("definir %s\n", yylval);} ';'
			| error ';' 
			;

listaSentencias		: sentencia
	       		| listaSentencias sentencia
	       		;

sentencia		: ID ":=" expresion ';' {printf("asignación\n");}
			| LEER '(' listaIdentificadores ')' ';' {printf("leer\n");}
			| ESCRIBIR '(' listaExpresiones ')' ';' {printf("escribir\n");}
			| error ';'
			;

listaIdentificadores	: ID
			| listaIdentificadores ',' ID
			;

listaExpresiones	: expresion
			| expresion ',' listaExpresiones
			;

expresion		: ID
			| CONS
			| expresion '+' expresion {printf("suma\n");}
			| expresion '-' expresion {printf("resta\n");}
			| expresion '*' expresion {printf("multiplicación\n");} 
			| expresion '/' expresion {printf("división\n");}
			| '(' expresion ')' 	 {printf("paréntesis\n");} 
			| '-' expresion 	 {printf("inversión\n");} %prec NEG	
			;


			;
%%
