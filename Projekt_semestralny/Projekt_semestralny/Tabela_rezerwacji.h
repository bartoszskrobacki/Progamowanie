#include "Klient.h"
#include "rezerwacja.h"
#include "pokoj.h"
#include "Lista.h"

class Tabela_rezerwacji
{
	size_t W;
	size_t K;
	int **tablica;
	tm *data;
public:
	
	Tabela_rezerwacji(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p);
	Tabela_rezerwacji refresh(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p);
	void zmien_date();
	void aktualna_data();
	void empty();
	void wyswietl();
};