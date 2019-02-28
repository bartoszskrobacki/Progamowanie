#pragma once
#include "Klient.h"
#include "rezerwacja.h"
#include "pokoj.h"

#include <fstream>
using namespace std;
struct l_pokoj {
	Pokoj p;
	l_pokoj *next;
	l_pokoj(const Pokoj &pok) :p(pok), next(nullptr) {};
};

struct l_klient
{
	Klient k;
	l_klient *next;
	l_klient(const Klient &kli) :k(kli), next(nullptr) {};
};

struct l_rezerwacja
{
	Rezerwacja r;
	l_rezerwacja *next;
	l_rezerwacja(const Rezerwacja &rez) :r(rez), next(nullptr) {};
};



class Lista_pokoj {
protected:
	l_pokoj * head;
	l_pokoj * tail;
public:
	Lista_pokoj() :head(nullptr) {};

	Lista_pokoj dodaj(const Pokoj &pok);
	Lista_pokoj operator+=(const Pokoj &pok);
	void nowypokoj(Lista_pokoj &list);
	void empty();

	void wczytaj( Lista_pokoj &list);
	void zapisz(const Lista_pokoj &pok);

	
	Pokoj* pop(int numer, Lista_pokoj &pok);

	void wyswietl();
	friend ostream & operator<<(ostream &, const Lista_pokoj &);
	friend istream & operator >>(istream &, Lista_pokoj &);
	
	friend class Rezerwacja;
	friend class Lista_rezerwacja;
	friend class Tabela_rezerwacji;
		
};
class Lista_klient {
protected:
	l_klient * head;
	l_klient * tail;
public:
	Lista_klient() :head(nullptr) {};
	Lista_klient dodaj(const Klient &kli);
	void wczytaj(Lista_klient &lista);
	void wyswietl();
	void nowyklient(Lista_klient &list);
	void empty();
	void zapisz(const Lista_klient &kli);
	Klient* pop(string naz, Lista_klient &kli);
	Lista_klient operator+=(const Klient &kli);
	friend ostream & operator<<(ostream &, const Lista_klient &);
	friend istream & operator >>(istream &, Lista_klient &);
	friend class Rezerwacja;
	
	
};


class Lista_rezerwacja {
protected:
	l_rezerwacja * head;
	l_rezerwacja * tail;
public:
	Lista_rezerwacja() :head(nullptr) {};
	Lista_rezerwacja dodaj(const Rezerwacja &rez);
	Lista_rezerwacja operator+=(const Rezerwacja &rez);
	Lista_rezerwacja usun_rezerwacje(Lista_rezerwacja &list);
	void empty();
	void nowyrezerwacja(Lista_rezerwacja &list_r, Lista_pokoj &list_p, Lista_klient &list_k);
	void wczytaj(Lista_rezerwacja &lista_r, Lista_klient &lista_k, Lista_pokoj &lista_p);
	void zapisz(const Lista_rezerwacja &rez);
	bool zajety(Lista_rezerwacja &list_r, Rezerwacja &rez);
	friend ostream & operator<<(ostream &, const Lista_rezerwacja &);
	friend class Tabela_rezerwacji;

};