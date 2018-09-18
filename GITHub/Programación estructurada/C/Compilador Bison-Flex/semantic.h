#ifndef SEMANTIC_H_INCLUDED
#define SEMANTIC_H_INCLUDED

void comenzar();
void definir(char * id);
void store(char *id1, char * id2);
void leer(char * id);
void escribir(char * id);
char * generarInfijo(char* id1, char * id2, char op);
char * invertir(char * id);
void idNoDeclarado(char * id);
void idYaDefinido(char * id);
void stop();
char* temp();

#endif
