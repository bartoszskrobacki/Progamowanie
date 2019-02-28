#include "menu.h"

void Menu::menu_glowne() {
	Lista_pokoj list_p;
	Lista_klient list_k;
	Lista_rezerwacja list_r;
	list_p.wczytaj(list_p);
	list_k.wczytaj(list_k);
	list_r.wczytaj(list_r, list_k, list_p);
	Tabela_rezerwacji tab(list_r, list_p);
	
	int k=100 ;
	
	while (k)
	{
		
		tab.wyswietl();
		cout << "--------------------------" << endl;
		cout << "1.Zmien podglad rezerwacji" << endl;
		cout << "2.Dodaj rezerwacje" << endl;
		cout << "3.Usun rezerwacje" << endl;
		cout << "4.Dodaj Klienta" << endl;
		cout << "5.Dodaj pokoj" << endl;
		cout << "6.Wyswietl" << endl;

		cout << "0.Wyjdz" << endl;
		cin >> k;

		switch (k) {
			case 1:
				this->podmenu_data(list_r, list_p,tab);
			break;
			case 2:
				list_r.nowyrezerwacja(list_r, list_p, list_k);
				tab.refresh(list_r, list_p);
			break;
			case 3:
				list_r.usun_rezerwacje(list_r);
				tab.refresh(list_r, list_p);
				break;
			case 4:
				list_k.nowyklient(list_k);
				break;
			case 5:
				list_p.nowypokoj(list_p);
				break;
			case 6:
				this->podmenu_wyswietl(list_r, list_p,list_k);
				break;
			
			default:
				break;
			}
		
	
		
		system("cls");
			
	}

	list_p.zapisz(list_p);
	list_k.zapisz(list_k);
	list_r.zapisz(list_r);
	list_p.empty();
	list_k.empty();
	list_r.empty();

}

void Menu::podmenu_wyswietl(const Lista_rezerwacja &list_r, const Lista_pokoj &list_p, const Lista_klient &list_k)
{
	int p = 100;
	cout << "Co chcesz wyswietlic?" << endl;
	cout << "1.Liste klientów" << endl;
	cout << "2.Liste pokoi" << endl;
	cout << "3.Liste rezerwacji" << endl;
	cin >> p;
	switch (p)
	{
	case 1:
		cout << "Lista klientow" << endl;
		cout << list_k << endl;
		break;
	case 2:
		cout << "Lista pokoi" << endl;
		cout << "Numer Ilosc osob" << endl;
		cout << list_p << endl;
		break;
	case 3:
		cout << "Lista rezerwacji" << endl;
		cout << list_r << endl;
		break;
	default:
		break;
	}
	cout << "Wcisnij dowolny przycisk aby kontynuowaæ" << endl;
	system("pause");
}
void Menu::podmenu_data(Lista_rezerwacja &list_r, Lista_pokoj &list_p, Tabela_rezerwacji &tab)
{
	int p = 100;
	cout << "Co chcesz zrobic?" << endl;
	cout << "1.Aktualna data" << endl;
	cout << "2.WprowadŸ date" << endl;
	cin >> p;
	switch (p)
	{
	case 1:
		tab.aktualna_data();
		tab.refresh(list_r, list_p);
		break;
	case 2:
		tab.zmien_date();
		tab.refresh(list_r, list_p);
		break;

	default:
		break;
	}
}