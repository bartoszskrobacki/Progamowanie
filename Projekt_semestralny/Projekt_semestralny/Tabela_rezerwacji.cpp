#include "Lista.h"
#include "Tabela_rezerwacji.h"

Tabela_rezerwacji::Tabela_rezerwacji(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p) {
	
	time_t rawtime;
	struct tm lokalny_czas;
	time(&rawtime);
	lokalny_czas = *localtime(&rawtime);
	
	

	time_t rawtimedod = rawtime;
	time_t rawtimeod = rawtime;
	
	W = 0;
	K = 29;
	l_pokoj *pom = list_p.head;
	l_rezerwacja *tmp = list_r.head;

	while (pom)
	{
		W++;
		pom = pom->next;
	}
	pom = list_p.head;
	tablica = new int *[W + 1];
	for (int i = 0; i < W + 1; i++) {
		tablica[i] = new int[K + 1];
		for (int j = 0; j<K + 1; j++)
			tablica[i][j] = { 0 };
	}

	for (int i = 1; i < W + 1; i++) {
		{
			tablica[i][0] = pom->p.numer;
			pom = pom->next;
		}

	}
	for (int j = 14, k = 14; j < K + 1; j++, k--)
	{

		//tablica[0][0] = 0;


		lokalny_czas = *localtime(&rawtimedod);
		tablica[0][j] = lokalny_czas.tm_mday;
		rawtimedod = rawtimedod + (3600 * 24);
		lokalny_czas = *localtime(&rawtimeod);
		tablica[0][k] = lokalny_czas.tm_mday;
		rawtimeod = rawtimeod - (3600 * 24);
	}

	while (tmp)
	{

		for (int i = 1; i < W + 1; i++) {
			if (tmp->r.wskpokoj->numer == tablica[i][0])
			{
				for (int j = 1; j < K + 1; j++)
				{
					
					if (tmp->r.wskpokoj->numer == tablica[i][0])
					{
						for (int j = 1; j < K + 1; j++)
						{
							if (tmp->r.poczatek_rezerwacji.tm_mon == tmp->r.koniec_rezerwacji.tm_mon == lokalny_czas.tm_mon) //aktualny miesiac
							{
								if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1] && tmp->r.koniec_rezerwacji.tm_mday >= tablica[0][j - 1])
									tablica[i][j] = 1;
							}

							if (tmp->r.poczatek_rezerwacji.tm_mon == lokalny_czas.tm_mon && tmp->r.koniec_rezerwacji.tm_mon == tmp->r.poczatek_rezerwacji.tm_mon + 1) //przyszly miesiac
							{
								if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1])
									tablica[i][j] = 1;
								if (tmp->r.koniec_rezerwacji.tm_mday >= tablica[0][j - 1] && j>14)
									tablica[i][j] = 1;
							}
							if (tmp->r.koniec_rezerwacji.tm_mon == lokalny_czas.tm_mon && tmp->r.koniec_rezerwacji.tm_mon == tmp->r.poczatek_rezerwacji.tm_mon + 1) //poprzedni miesiac
							{
								if (tmp->r.koniec_rezerwacji.tm_mday <= tablica[0][j - 1])
									tablica[i][j] = 1;
								if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1] && j <14)
									tablica[i][j] = 1;
							}
						}


					}
					
					
					
				}


			}
		}
		tmp = tmp->next;
	}
	this->data = localtime(&rawtime);

}

void Tabela_rezerwacji::wyswietl() {
	cout << "				Data: " << data->tm_mday << "-" << data->tm_mon + 1 << "-" << data->tm_year + 1900 << endl;
	if (tablica[0][1] > 9)
		cout << "    ";
	else cout << "    ";
	for (int i = 0; i < W + 1; i++) {

		for (int j = 0; j < K+1; j++)
		{
			if (i == 0)
				cout << tablica[i][j] << " ";
			else
			{


				if (tablica[0][j] <= 9 && tablica[0][j] >= 0)
				{
					if (tablica[i][j] == 0)
						cout << "  ";
					else
						cout << tablica[i][j] << " ";
				}
				else
				{
					if (tablica[i][j] == 0)
						cout << "   ";
					else
						cout << tablica[i][j] << "  ";
				}
			}
		}
		cout << endl;
	}
	
	}
	
void Tabela_rezerwacji::empty() {
	for (int i=0; i < W + 1; i++)
	{
		//delete tablica[i]; //uwolnienie pamieci
	}
	delete[] tablica; //uwolnienie pamieci

}



Tabela_rezerwacji Tabela_rezerwacji::refresh(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p) {
	this->empty();

	time_t rawtime=mktime(data);
	tm lokalny_czas;
	lokalny_czas = *localtime(&rawtime);

	time_t rawtimedod = rawtime;
	time_t rawtimeod = rawtime;
	W = 0;
	K = 29;
	l_pokoj *pom = list_p.head;
	l_rezerwacja *tmp = list_r.head;

	while (pom)
	{
		W++;
		pom = pom->next;
	}
	pom = list_p.head;
	tablica = new int *[W + 1];
	for (int i = 0; i < W + 1; i++) {
		tablica[i] = new int[K + 1];
		for (int j = 0; j<K + 1; j++)
			tablica[i][j] = { 0 };
	}

	for (int i = 1; i < W + 1; i++) {
		{
			tablica[i][0] = pom->p.numer;
			pom = pom->next;
		}

	}
	for (int j = 14, k = 14; j < K + 1; j++, k--)
	{
		lokalny_czas = *localtime(&rawtimedod);
		tablica[0][j] = lokalny_czas.tm_mday;
		rawtimedod = rawtimedod + (3600 * 24);
		lokalny_czas = *localtime(&rawtimeod);
		tablica[0][k] = lokalny_czas.tm_mday;
		rawtimeod = rawtimeod - (3600 * 24);
	}
	lokalny_czas = *localtime(&rawtime);
	while (tmp)
	{

		for (int i = 1; i < W + 1; i++) {
			if (tmp->r.wskpokoj->numer == tablica[i][0])
			{
				for (int j = 1; j < K + 1; j++)
				{
					if (tmp->r.poczatek_rezerwacji.tm_mon == tmp->r.koniec_rezerwacji.tm_mon == lokalny_czas.tm_mon) //aktualny miesiac
					{
						if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1] && tmp->r.koniec_rezerwacji.tm_mday >= tablica[0][j - 1])
							tablica[i][j] = 1;
					}

					if (tmp->r.poczatek_rezerwacji.tm_mon == lokalny_czas.tm_mon && tmp->r.koniec_rezerwacji.tm_mon > tmp->r.poczatek_rezerwacji.tm_mon ) //przyszly miesiac
					{
						if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1])
							tablica[i][j] = 1;
						if (tmp->r.koniec_rezerwacji.tm_mday >= tablica[0][j - 1] && j>14)
							tablica[i][j] = 1;
					}
					if (tmp->r.koniec_rezerwacji.tm_mon == lokalny_czas.tm_mon && tmp->r.koniec_rezerwacji.tm_mon >> tmp->r.poczatek_rezerwacji.tm_mon ) //poprzedni miesiac
					{
						if (tmp->r.koniec_rezerwacji.tm_mday <= tablica[0][j - 1])
							tablica[i][j] = 1;
						if (tmp->r.poczatek_rezerwacji.tm_mday <= tablica[0][j - 1] && j <14)
							tablica[i][j] = 1;
					}
				}


			}
		}
		tmp = tmp->next;
	}
	this->data = localtime(&rawtime);
	return *this;
}

void Tabela_rezerwacji::aktualna_data() {
	time_t rawtime;
	time(&rawtime);
	data = localtime(&rawtime);
}
void Tabela_rezerwacji::zmien_date() {
	int year,month;
	cout << "Podaj dzien, miesiac, rok kalendarza, ktory chcesz wyswietlic" << endl;
	cin >> data->tm_mday;
	cin >> month;
	data->tm_mon = month-1 ;
	cin >> year;
	data->tm_year = year - 1900;
}