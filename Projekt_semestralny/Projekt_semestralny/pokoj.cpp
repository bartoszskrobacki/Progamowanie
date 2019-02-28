#include "pokoj.h"


int Pokoj::operator>(const Pokoj &pok) {
	return numer > pok.numer;
}
Pokoj::Pokoj(int num, int ilo, bool zaj) {
	numer = num;
	ilosc_osob = ilo;
	zajety = zaj;

}

void Pokoj::wyswietl() {
	cout << "Pokoj " << numer << "jest " << ilosc_osob << "osobowy"<<zajety<<endl;
}




ostream & operator<<(ostream &os, const Pokoj &pok) {
	os << endl;
	os << pok.numer;
	os << " ";
	os << pok.ilosc_osob;
	os << " ";
	os << pok.zajety;
	return os;

}

istream & operator>>(istream &is, Pokoj &pok) {
	return is >> pok.numer >> pok.ilosc_osob >> pok.zajety;
};

