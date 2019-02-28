	#pragma once
#include <iostream>
using namespace std;

class Lista_pokoj;
class Tabela_rezerwacji;
class Pokoj
{
	int numer;
	int ilosc_osob;
	bool zajety;
public:
	Pokoj(int num = 0, int ilo = 1, bool zaj = false);
	int operator>(const Pokoj &pok);
	void wyswietl();
	

	friend ostream & operator<<(ostream &, const Pokoj &);
	friend istream & operator>>(istream &, Pokoj &);
	
	
	friend class Lista_pokoj;
	friend class Lista_rezerwacja;
	friend class Tabela_rezerwacji;
};