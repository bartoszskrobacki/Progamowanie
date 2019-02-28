#pragma once
#include <iostream>
#include "Klient.h"
#include "Lista.h"
#include "pokoj.h"
#include "rezerwacja.h"
#include "Tabela_rezerwacji.h"
using namespace std;

class Menu {

public:
	
	void menu_glowne();
	void podmenu_wyswietl(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p, const Lista_klient &list_k);
	void podmenu_data( Lista_rezerwacja &list_r,  Lista_pokoj &list_p, Tabela_rezerwacji &tab);
};



