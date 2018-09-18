#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int nid = 0;
char identificadores[50][20];

int estaDefinido(char* id){
	int estado = 0;
	for(int i=0 ; i<nid; i++){
	if(strcmp(id, identificadores[i]) == 0){
	estado = 1;
	}}
	return estado;
};
void aniadir(char* id){
	strcpy(identificadores[nid], id);
	nid++;
};

