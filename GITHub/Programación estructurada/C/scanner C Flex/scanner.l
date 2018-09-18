%{
#include <stdio.h>
#include "tokens.h"
%}
%option outfile="scanner.c"
%option header-file="scanner.h"
%option noinput
%option nounput

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
{digdecimal}+									return CONS;
{letras}+({digdecimal}|{letras})*						return ID;
\,										return ',';
\;										return ';';
\(										return '(';
\)										return ')';
{asignacion}									return ASIG;
\+										return '+';
\*										return '*';
\/										return '/';
\-										return '-';
{digdecimal}+{letras}({letras}|{digdecimal})*					{printf("Error léxico: Constante invalida: %s\n",yytext);}
{caracInval}+									{printf("Error léxico: Cadena desconocida: %s\n",yytext);}
{letras}+{digdecimal}*{caracInval}({digdecimal}|{letras}|{caracInval})*		{printf("Error léxico: Identificador Invalido: %s\n",yytext);}
\n|{espacios}+ 		 							;
{comentario}.*									;
%%


