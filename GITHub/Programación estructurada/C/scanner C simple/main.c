/* TP0 - 2017
Un scanner elemental

INTEGRANTES

Alarcon Melanie Sol 156.685-4
Gomez Dario Javier 150.332-7
Nuñez Federico Javier 150.571-3
Quattrini Patricio 146.245-3


*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "scanner.h"

enum tokens {LETRASMIN = 1, DIGITOS, ESPACIOS, ERRORES, FINDETEXTO};
int conterr, contid, contint = 0;
int token;
FILE *arch;

int main(){
    arch = fopen("tp.dat","r+");
    while(token != FINDETEXTO){
    token = scanner();
    switch(token){
        case LETRASMIN:
            printf("Identificador\n");
            contid++;
            break;
        case DIGITOS:
            printf("Constante entera\n");
            contint++;
            break;
        case ERRORES:
            printf("Error\n");
            conterr++;
            break;
        default:
            break;
    }}
    printf("--------\n");
    printf("Totales:\n");
    printf("Identificadores: %i\n", contid);
    printf("Constantes enteras: %i\n",contint);
    printf("Errores: %i\n", conterr);
    fclose(arch);
    return 0;
}


