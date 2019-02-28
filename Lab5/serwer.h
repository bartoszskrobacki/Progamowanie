#pragma once
#include "dane.h"
#include "klient.h"
using namespace std;

class Serwer {
	Dane *tab;
	int n;
public:
	Serwer(int n);
	void receive(string msg, Klient *kli);
	friend class Klient;

};