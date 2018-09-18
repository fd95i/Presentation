#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "scanner.h"

FILE *arch;
int estado = 0;
int columna;
int token;

enum columnas {LETRA_MIN = 1,DIGITO,ESPACIO,MAYUS_SIM,FDT};
enum estados {ESTADO,INICIAL,LEYENDO_ID,LEYENDO_DIGITO,LEYENDO_MAYUS_SIM,RECONOZCO_ID = 101,RECONOZCO_DIG,ERROR,REC_FDT};
enum tokens {LETRASMIN = 1, DIGITOS, ESPACIOS, ERRORES, FINDETEXTO};

int TT[9][6] =
    {
        {ESTADO,           LETRA_MIN,DIGITO,ESPACIO, MAYUS_SIM , FDT},
        {INICIAL,               2   ,   3  ,   1   ,      4    , 104},
        {LEYENDO_ID,            2   ,   2  ,  101  ,     101   , 101},
        {LEYENDO_DIGITO,       103  ,   3  ,  102  ,     102   , 102},
        {LEYENDO_MAYUS_SIM,    103  ,  103 ,  103  ,      4    , 103},
        {RECONOZCO_ID,         101  ,  101 ,  101  ,     101   , 101},
        {RECONOZCO_DIG,        102  ,  102 ,  102  ,     102   , 102},
        {ERROR,                103  ,  103 ,  103  ,     103   , 103},
        {REC_FDT,              104  ,  104 ,  104  ,     104   , 104}
    };


int encolumnar(int curr_char){

    if(ispunct(curr_char) || isupper(curr_char)){
            return ERRORES;
    }
    else if(isdigit(curr_char)){
            return DIGITOS;
    }
    else if(isspace(curr_char)){
            return ESPACIOS;
    }
    else if(isalpha(curr_char)){
            return LETRASMIN;
    }
    else if(curr_char == EOF){
            return FINDETEXTO;
    }else
    return 0;
}
int convertirAToken(int estado){
    switch(estado){
        case RECONOZCO_ID:
            return LETRASMIN;
        case RECONOZCO_DIG:
            return DIGITOS;
        case ERROR:
            return ERRORES;
        case REC_FDT:
            return FINDETEXTO;
    }
}

int scanner(){
    int curr_char;
    estado = INICIAL;
    do{
    curr_char = fgetc(arch);
    columna = encolumnar(curr_char);
    estado = TT[estado][columna];
    token = convertirAToken(estado);
    }while(estado < 100);
    if(estado == RECONOZCO_DIG || estado == RECONOZCO_ID){
        ungetc(curr_char,arch);
    }
    return token;
}

