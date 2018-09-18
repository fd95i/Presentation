%{
#include <stdio.h>
#include <strings.h>
#include "registro.tab.h"
%}
%option header-file="registro.h"
%option outfile="registro.c"

dig [0-9]
expo [eE][+-]?{dig}+
frac  {dig}*\.{dig}+|{dig}+\.{dig}*
letra [a-zA-Z]
%%
{letra}({letra}|{dig})*	{yylval.str = strdup(yytext);
			 return ID;}
{dig}+			{yylval.str = strdup(yytext);
			 sscanf(yytext, "%d", &yylval.num);
			 return DECIMAL;}
{dig}+{letra}+		{yyerror("Constante decimal mal formada\n");}
{frac}{expo}?		|
{dig}+{expo}		{yylval.str = strdup(yytext);
			 sscanf(yytext, "%lf", &yylval.real);
			 return REAL;}
.|\n    		;
%%

