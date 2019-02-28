#include "Klient.h"

Klient::Klient(string naz,string im,string pes)
{
	nazwisko = naz;
	imie = im;
	pesel = pes;
}



void Klient::wyswietl() {
	cout << "Nazwisko: " << nazwisko << " imie: " << imie << "Pesel: " << pesel <<" "<< endl;
}



int Klient::operator>(const Klient &kli)
{
	return nazwisko > kli.nazwisko;
}

ostream & operator<<(ostream &os, const Klient &kli) {
	os << endl;
	os << kli.nazwisko;
	os << " ";
	os << kli.imie;
	os << " ";
	os << kli.pesel;
	return os;

}

istream & operator>>(istream &is, Klient &kli) {
	return is >> kli.nazwisko >> kli.imie >> kli.pesel;
};

