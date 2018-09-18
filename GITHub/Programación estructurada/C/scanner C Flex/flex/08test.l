%{
#include <stdio.h>
#include "tokens.h"
%}
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
{prehexa}{dighexa}+             return HEXA;
{nocero}{digdecimal}*{sufijo}?  return DECIMAL;
0{digoctal}*                    return OCTAL;
{fraccion}{expo}?{sufreal}?	|
{digdecimal}+{expo}{sufreal}?	return REAL;
.|\n    			;
<<EOF>>				return EOF;
%%
char *token_names[] = {"HEXA", "DECIMAL", "OCTAL", "REAL"};
int main() {
	enum token t;
	while ((t = yylex()) != EOF)
		printf("Token: %s\t\tValor: %s\n", token_names[t], yytext);
	return 0;
}
