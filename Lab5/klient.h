#pragma once
#include <string>
#include "serwer.h"
using namespace std;

class Klient {
	Serwer *s;
	string nazwa;
	static int zmienna_statyczna=0;
public: 
	Klient(Serwer *ser, string naz);
	void send(string msg);
	
};