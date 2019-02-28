#include "rezerwacja.h"

Rezerwacja::Rezerwacja(int numer_rez , int poczatek_d , int poczatek_m , int poczatek_r , int koniec_d , int koniec_m , int koniec_r, Klient *kli, Pokoj *pok) {
	numer_rezerwacji = numer_rez;
	poczatek_rezerwacji.tm_mday = poczatek_d;
	poczatek_rezerwacji.tm_mon = poczatek_m-1;
	poczatek_rezerwacji.tm_year = poczatek_r-1900;
	koniec_rezerwacji.tm_mday = koniec_d;
	koniec_rezerwacji.tm_mon = koniec_m-1;
	koniec_rezerwacji.tm_year = koniec_r-1900;
	wskklient = kli;
	wskpokoj = pok;

}
void Rezerwacja::wyswietl() {
	cout << "Numer_rezerwacji" << numer_rezerwacji << "Poczatek rezerwacji: " << poczatek_rezerwacji.tm_mday<<"-"<<poczatek_rezerwacji.tm_mon<<"-"<<poczatek_rezerwacji.tm_year<<" "<<"Koniec rezerwacji:"<< koniec_rezerwacji.tm_mday<<"-"<<koniec_rezerwacji.tm_mon<<"-"<<koniec_rezerwacji.tm_year<<endl;
	wskpokoj->wyswietl();
	wskklient->wyswietl();
}

bool Rezerwacja::operator>(const Rezerwacja &rez) {
	return numer_rezerwacji > rez.numer_rezerwacji;
}

ostream & operator<<(ostream &os, const Rezerwacja &rez) {
	
	os << endl;
	os << rez.numer_rezerwacji;
	os << " ";
	os << rez.poczatek_rezerwacji.tm_mday;
	os << " ";
	os << rez.poczatek_rezerwacji.tm_mon;
	os << " ";
	os << rez.poczatek_rezerwacji.tm_year;
	os << " ";
	os << rez.koniec_rezerwacji.tm_mday;
	os << " ";
	os << rez.koniec_rezerwacji.tm_mon;
	os << " ";
	os << rez.koniec_rezerwacji.tm_year;
	os << *rez.wskpokoj;
	os << *rez.wskklient;

	
	return os;

}


/*
istream & operator>>(istream &is, Rezerwacja &rez) {
int numer;
string nazwisko;
is >> rez.numer_rezerwacji;
is >> rez.data;
is >> numer;
is >> nazwisko;
rez.wskklient = kli.pop(nazwisko, kli);
rez.wskpokoj = pok.pop(numer, pok);
return is;
}
*/
