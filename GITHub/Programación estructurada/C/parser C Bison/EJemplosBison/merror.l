%{
#include <stdio.h>
#include <strings.h>
#include "merror-par.h"
%}
%option header-file="merror-scan.h"
%option outfile="merror-scan.c"
%option yylineno

%%
[a-zA-Z]+		{yylval = strdup(yytext); return PALABRA;}
[0-9]+			{yylval = strdup(yytext); return NRO;}
,			{return ',';}
!			{return '!';}
[[:space:]]+		;
[[:punct:]]{-}[,!]+	{yylexerrs++; yyerror("Error léxico");}
.			;
%%

