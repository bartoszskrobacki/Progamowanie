#pragma once
#include "Klient.h"
#include "pokoj.h"
#include <time.h>

class Lista_rezerwacja;
class Tabela_rezerwacji;
class Rezerwacja {

	struct tm poczatek_rezerwacji;
	struct tm koniec_rezerwacji;
	int numer_rezerwacji;

	Klient *wskklient;
	Pokoj  *wskpokoj;
	
public:
	Rezerwacja(int numer_rez = 0, int poczatek_dzien=1,int poczatek_miesiac=1,int poczatek_rok=2019,int koniec_dzien=31,int koniec_miesiac=1,int koniec_rok=2019, Klient *wskkli=nullptr, Pokoj *wskpok = nullptr);
	void wyswietl();
	bool operator>(const Rezerwacja &);

	friend ostream & operator<<(ostream &, const Rezerwacja &);
	friend class Lista_rezerwacja;
	friend class Tabela_rezerwacji;
	
};