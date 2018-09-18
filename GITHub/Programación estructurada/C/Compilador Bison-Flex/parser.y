%code top{
#include <stdio.h>
#include "scanner.h"
#include "semantic.h"
#include "symbol.h"
}
%code provides{
void yyerror(const char *);
extern int yylexerrs;
extern int yysemerrs;
}
%define api.value.type {char*}
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
programa		: PROGRAMA {comenzar();} VARIABLES definicionVariables CODIGO listaSentencias FIN {stop(); if (yynerrs || yylexerrs) 				  YYABORT;};
			;

definicionVariables	: variable
			| definicionVariables variable
	           	;

variable		: DEFINIR ID {if(estaDefinido($2)){idYaDefinido($2);YYERROR;}else{definir($2);}}';' 
			| error ';' 
			;

listaSentencias		: sentencia
	       		| listaSentencias sentencia
	       		;

sentencia		: ID ":=" expresion ';' {$1=$3;store($1,$3);}
			| LEER '(' listaIdentificadores ')' ';' 
			| ESCRIBIR '(' listaExpresiones ')' ';'
			| error ';'
			;

listaIdentificadores	: ID {leer($1);}
			| listaIdentificadores ',' ID {leer($3);}
			;

listaExpresiones	: expresion {escribir($1);}
			| expresion ',' listaExpresiones {escribir($3);}
			;

expresion		: id
			| CONS 
			| expresion '+' expresion {$$=generarInfijo($1,$3,'+');}
			| expresion '-' expresion {$$=generarInfijo($1,$3,'-');}
			| expresion '*' expresion {$$=generarInfijo($1,$3,'*');}
			| expresion '/' expresion {$$=generarInfijo($1,$3,'/');}
			| '(' expresion ')' 	  {$$=$2;} 
			| '-' expresion %prec NEG {$$=invertir($2);}	 		
			;

id			: ID {if(!estaDefinido($1)){idNoDeclarado($1);YYERROR;}}
			;
			;
%%




