%{
#include <stdio.h>
#include <stdlib.h>
#include "parser.h"

char* buffer;
int crearBuffer(char * s,char * lexema){
buffer = malloc(100);
strcpy(buffer,s);
strcat(buffer,lexema);
return 0;
}

%}
%option outfile="scanner.c"
%option header-file="scanner.h"
%option noinput
%option nounput
%option yylineno

digdecimal [0-9]
letras [a-zA-Z]
asignacion ":="
comentario "//"
caracInval [[:punct:]]{-}[+*/,;():=-]
espacios [[:space:]]

%%
programa		 							return PROGRAMA;
variables									return VARIABLES;	
definir										return DEFINIR;
codigo										return CODIGO;
leer										return LEER;
escribir									return ESCRIBIR;
fin										return FIN;
{digdecimal}+									{yylval=strdup(yytext);return CONS;}
{letras}+({digdecimal}|{letras})*						{yylval=strdup(yytext);return ID;}
\,										return ',';
\;										return ';';
\(										return '(';
\)										return ')';
{asignacion}									return ASIG;
\+										return '+';
\*										return '*';
\/										return '/';
\-										return '-';
{digdecimal}+{letras}({letras}|{digdecimal})*					{yylexerrs++;crearBuffer("Error léxico: Constante invalida: ",yytext);yyerror(buffer);free(buffer);}
{caracInval}+									{yylexerrs++;crearBuffer("Error léxico: Cadena desconocida: ",yytext);yyerror(buffer);free(buffer);}
{letras}+{digdecimal}*{caracInval}({digdecimal}|{letras}|{caracInval})*		{yylexerrs++;crearBuffer("Error léxico: Identificador Invalido: ",yytext);yyerror(buffer);free(buffer);}
\n|{espacios}+ 		 							;
{comentario}.*									;
%%



