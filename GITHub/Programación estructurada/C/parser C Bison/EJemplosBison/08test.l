%{
#include <stdio.h>
#include <strings.h>
#include "08test.tab.h"
%}
%option header-file="08test.h"
%option outfile="08test.c"

prehexa 0[xX]
dighexa [0-9a-fA-F]
digoctal [0-7]
nocero [1-9]
digdecimal [0-9]
sufijo [uU][lL]|[lL][uU]|[lL]|[uU]
sufreal [fFlL]
expo [eE][+-]?{digdecimal}+
fraccion  {digdecimal}*\.{digdecimal}+|{digdecimal}+\.{digdecimal}*
%%
{prehexa}{dighexa}+             {yylval = strdup(yytext); return HEXA;}
{nocero}{digdecimal}*{sufijo}?  {yylval = strdup(yytext); return DECIMAL;}
0{digoctal}*                    {yylval = strdup(yytext); return OCTAL;}
{fraccion}{expo}?{sufreal}?	|
{digdecimal}+{expo}{sufreal}?	{yylval = strdup(yytext); return REAL;}
.|\n    			;
%%

