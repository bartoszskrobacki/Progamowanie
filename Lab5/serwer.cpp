#include "serwer.h"
Serwer::Serwer(int n) {
	int * tablica = new Dane[n];
	for (int i = 0;i < n;i++) {
		tablica[i] = NULL;
	}
}

void Serwer::receive(string msg, Klient *kli) {
	
}