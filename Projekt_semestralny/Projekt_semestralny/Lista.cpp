#include "Lista.h"

Lista_pokoj Lista_pokoj::dodaj(const Pokoj &pok) {
	l_pokoj * nowy = new l_pokoj(pok);
	if ((!head) || (head->p > pok))
	{
		nowy->next = head;
		head = nowy;
	}
	else
	{
		l_pokoj *pom = head;
		while (pom->next && !(pom->next->p > pok))
			pom = pom->next;

		nowy->next = pom->next;
		pom->next = nowy;
	}
	if (!nowy->next)
		tail = nowy;

	return *this;
}

Lista_pokoj Lista_pokoj::operator+=(const Pokoj &pok) {
	this->dodaj(pok);
	return *this;
}

void Lista_pokoj::wczytaj(Lista_pokoj &lista) {
	Pokoj p;
	fstream plik;
	plik.open("pokoj.txt", ios::in);
	if(plik.good())
	{
		while (!plik.eof())
		{
			plik >> p;

			lista += p;
		}
	}
	plik.close();
	
}


/*Lista_pokoj::~Lista_pokoj() {
	while (head) {
		const l_pokoj * pom = head;
		head = head->next;
		delete pom;
	}
}*/
void Lista_pokoj::empty()
{
	while (head) {
			const l_pokoj * pom = head;
			head = head->next;
			delete pom;
		}

}

void Lista_pokoj::zapisz(const Lista_pokoj &pok) {
	fstream plik("pokoj.txt", ios::out);
	if (plik.good()) {
		plik << pok ;

	}
	plik.close();
}

void Lista_pokoj::wyswietl() {
	l_pokoj *pom = head;
	while (pom)
	{
		pom->p.wyswietl();
		pom = pom->next;
	}
}

void Lista_pokoj::nowypokoj(Lista_pokoj &list) {
 int numer, ilosc;
	bool zaj = 0;

	cout << "Podaj numer pokoju: " << endl;
	cin >> numer;
	cout << "Podaj ilosc osob: " << endl;
	cin >> ilosc;
	
	Pokoj p(numer, ilosc, zaj);
	list += p;
}



Pokoj* Lista_pokoj::pop(int i, Lista_pokoj &pok) {
	l_pokoj *pom = pok.head;
	while (pom)
	{
		if (pom->p.numer == i)
		{
			return &pom->p;
			
		}
		pom = pom->next;
	}
	return nullptr;
	
}


ostream & operator<<(ostream &os, const Lista_pokoj &pok)
{
	l_pokoj *pom = pok.head;
	while(pom)
	{
		os << pom->p;
		pom = pom->next;
	}
	return os;
}
istream & operator>>(istream &is, Lista_pokoj &pok)
{
	Pokoj p;
	pok.empty();
	while (is >> p)
		pok += p;

	return is;
}




Lista_klient Lista_klient::dodaj(const Klient &kli) {
	l_klient * nowy = new l_klient(kli);
	if ((!head) || (head->k > kli))
	{
		nowy->next = head;
		head = nowy;
	}
	else
	{
		l_klient *pom = head;
		while (pom->next && !(pom->next->k > kli))
			pom = pom->next;

		nowy->next = pom->next;
		pom->next = nowy;
	}
	if (!nowy->next)
		tail = nowy;

	return *this;
}
void Lista_klient::empty() {
	while (head) {
		const l_klient * pom = head;
		head = head->next;
		delete pom;
	}

}

Lista_klient Lista_klient::operator+=(const Klient &kli) {
	this->dodaj(kli);
	return *this;
}


void Lista_klient::wyswietl() {
	l_klient *pom = head;
		while (pom)
		{
			pom->k.wyswietl();
			pom = pom->next;
		}
	
}

void Lista_klient::zapisz(const Lista_klient &kli) {
	fstream plik("klient.txt", ios::out);
	if (plik.good()) {
		plik << kli;

	}
	plik.close();
}

void Lista_klient::wczytaj(Lista_klient &lista) {
	Klient k;
	fstream plik;
	plik.open("klient.txt", ios::in);
	if (plik.good())
	{
		while (!plik.eof())
		{
			plik >> k;

			lista += k;
		}
	}
	plik.close();

}


void Lista_rezerwacja::nowyrezerwacja(Lista_rezerwacja &list_r, Lista_pokoj &list_p, Lista_klient &list_k) {
	int numer_rez, poczdzien,poczmies,poczrok,kondzien,konmies,konrok;
	string nazwisko, imie, pesel;
	int numer;	
	Klient *wskkli = nullptr;
	Pokoj *wskpok = nullptr;
	cout << "Podaj numer rez" << endl;
	cin >> numer_rez;
	cout << "Podaj dzien przyjazdu" << endl;
	cin >> poczdzien;
	cout << "Podaj miesiac przyjazdu" << endl;
	cin >> poczmies;
	poczrok = 2019;
	cout << "Podaj dzien wyjazdu" << endl;
	cin >> kondzien;
	cout << "Podaj miesiac wyjazdu" << endl;
	cin >> konmies;
	konrok = 2019;
	list_p.wyswietl();
	cout << "Podaj numer pokoju" << endl;
	cin >> numer;
	wskpok = list_p.pop(numer, list_p);
	int decyzje=3;
		cout << "Chcesz dodaæ istniej¹cego klienta(1.) czy dodaæ nowego klienta(2.)?" << endl;
		cin >> decyzje;
		if (decyzje == 1) {
			list_k.wyswietl();
			cout << "Podaj nazwisko" << endl;
			cin >> nazwisko;
			wskkli = list_k.pop(nazwisko, list_k);
			if (!wskkli)
				cout << "Klient o danym nazwisku nie istnieje, musisz dodac nowego klienta" << endl;
		}
	 if(decyzje==2 || !wskkli)
		{
			cout << "Podaj imie" << endl;
			cin >> imie;
			cout << "Podaj nazwisko" << endl;
			cin >> nazwisko;
			while (pesel.length() != 11)
			{
				cout << "Podaj prawid³owy pesel" << endl;
				cin >> pesel;
			}

			Klient k(nazwisko, imie, pesel);
			list_k += k;
			wskkli = list_k.pop(nazwisko, list_k);
		}
	
	Rezerwacja r(numer_rez,poczdzien,poczmies,poczrok,kondzien,konmies,konrok,wskkli,wskpok);
	if (list_r.zajety(list_r, r))
		cout << "Podany termin dla danego pokoju jest ju¿ zajety" << endl;
	else
		list_r += r;
	

	
}



ostream & operator<<(ostream &os, const Lista_klient &kli)
{
	l_klient *pom = kli.head;
	
	while (pom)
	{
		os << pom->k;
		pom = pom->next;
	}
	return os;
}
istream & operator>>(istream &is, Lista_klient &kli)
{
	Klient k;
	kli.empty();

	while (is >> k)
		kli += k;

	return is;
}

Klient* Lista_klient::pop(string naz, Lista_klient &kli) {
	l_klient *pom = kli.head;
	while (pom)
	{
		if (pom->k.nazwisko == naz)
		{
			return &pom->k;
			
		}
		pom = pom->next;
	}
	return nullptr;


}
void Lista_klient::nowyklient(Lista_klient &list) {
	string imie, nazwisko,pesel;


	cout << "Podaj nazwisko: " << endl;
	cin >> nazwisko;
	cout << "Podaj imie: " << endl;
	cin >> imie;
	cout << "Pesel: " << endl;
	cin >> pesel;
	Klient k(nazwisko, imie, pesel);
	list += k;
}



Lista_rezerwacja Lista_rezerwacja::dodaj(const Rezerwacja &rez) {
	l_rezerwacja * nowy = new l_rezerwacja(rez);
	if ((!head) || (head->r > rez))
	{
		nowy->next = head;
		head = nowy;
	}
	else
	{
		l_rezerwacja *pom = head;
		while (pom->next && !(pom->next->r > rez))
			pom = pom->next;

		nowy->next = pom->next;
		pom->next = nowy;
	}
	if (!nowy->next)
		tail = nowy;

	return *this;
}

Lista_rezerwacja Lista_rezerwacja::operator+=(const Rezerwacja &rez) {
	this->dodaj(rez);
	return *this;
}

void Lista_rezerwacja::empty() {
	while (head) {
		const l_rezerwacja * pom = head;
		head = head->next;
		delete pom;
	}

}

ostream & operator<<(ostream &os, const Lista_rezerwacja &rez)
{
	l_rezerwacja *pom = rez.head;

	while (pom)
	{
			os << pom->r;
		pom = pom->next;
	}
	return os;
}


void Lista_rezerwacja::zapisz(const Lista_rezerwacja &rez) {
	fstream plik("rezerwacja.txt", ios::out);
	if (plik.good()) {
		plik << rez;

	}
	plik.close();
}

void Lista_rezerwacja::wczytaj(Lista_rezerwacja &lista_r, Lista_klient &lista_k, Lista_pokoj &lista_p) {
	Rezerwacja r;
	int numer_p = 0;
	string nazwisko;
	Klient *wskkli = nullptr;
	Pokoj  *wskpok = nullptr;
	string tmp = "";



	fstream plik;
	plik.open("rezerwacja.txt", ios::in);
	if (plik.good())
	{
		while (!plik.eof())
		{
			plik >> r.numer_rezerwacji;
			plik >> r.poczatek_rezerwacji.tm_mday;
			plik >> r.poczatek_rezerwacji.tm_mon;
			plik >> r.poczatek_rezerwacji.tm_year;
			plik >> r.koniec_rezerwacji.tm_mday;
			plik >> r.koniec_rezerwacji.tm_mon;
			plik >> r.koniec_rezerwacji.tm_year;
			plik >> numer_p;
			wskpok = lista_p.pop(numer_p, lista_p);
			if (wskpok != nullptr)
			{
				plik >> tmp;
				plik >> tmp;
				plik >> nazwisko;
				wskkli = lista_k.pop(nazwisko, lista_k);
				
				if (wskkli != nullptr) {

					r.wskklient = wskkli;
					r.wskpokoj = wskpok;
					lista_r += r;
					wskkli = nullptr;
				}
				wskpok = nullptr;
			}
			
			getline(plik, tmp);
		}

		plik.close();

	}
}

bool Lista_rezerwacja::zajety(Lista_rezerwacja &list_r, Rezerwacja &rez)
{
	l_rezerwacja *pom = list_r.head;
	time_t rawtimepocz = mktime(&rez.poczatek_rezerwacji);
	time_t rawtimekon = mktime(&rez.koniec_rezerwacji);
	while (pom)
	{
		time_t rawtimepoczlist = mktime(&pom->r.poczatek_rezerwacji);
		time_t rawtimekonlist = mktime(&pom->r.koniec_rezerwacji);
		if (pom->r.wskpokoj->numer == rez.wskpokoj->numer && rawtimepocz >= rawtimepoczlist && rawtimekon <= rawtimekonlist)
			return true;
		pom = pom->next;
	}
	return false;
}

Lista_rezerwacja Lista_rezerwacja::usun_rezerwacje(Lista_rezerwacja &list) {
	
	l_rezerwacja *pom = list.head;
	l_rezerwacja *tmp = pom->next;
	int dzien,miesiac,rok, numer_pokoju=0;
	cout << "Podaj numer pokoju rezerwacji, któr¹ chcesz usun¹æ" << endl;
	cin >> numer_pokoju;
	cout << "Poda dzien, miesiac i rok" << endl;
	cin >> dzien;
	cin >> miesiac;
	cin >> rok;
	while (tmp)
	{
		if (tmp->r.wskpokoj->numer == numer_pokoju
			&& tmp->r.poczatek_rezerwacji.tm_mday <= dzien && tmp->r.poczatek_rezerwacji.tm_mon <= miesiac -1 && tmp->r.poczatek_rezerwacji.tm_year <= rok
			&& tmp->r.koniec_rezerwacji.tm_mday >= dzien && tmp->r.koniec_rezerwacji.tm_mon >=miesiac -1 && tmp->r.koniec_rezerwacji.tm_year <= rok)
		{
			
			pom->next = tmp->next;
			delete tmp;

			return *this;
		}
		pom = pom->next;
		tmp = tmp->next;
	}
	return *this;

}