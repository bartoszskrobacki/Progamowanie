#pragma once

#include <string>
#include <iostream>
using namespace std;

class Lista_klient;

class Klient {
	string nazwisko;
	string imie;
	string pesel;
public:
	

	Klient(string nazwisko = "Kowalski", string imie = "Jan", string pesel = "9709110672");

	void wyswietl();
	int operator>(const Klient &kli);
	friend ostream & operator<<(ostream &, const Klient &);
	friend istream & operator >>(istream &, Klient &);

	
	friend class Lista_klient;
	};