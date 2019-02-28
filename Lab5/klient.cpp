#include <string>
#include "klient.h"


Klient::Klient(Serwer *ser, string naz) {
	s = ser;
	nazwa = naz;
}

Klient::send(string msg) {
	Klient k = *this;
	s->receive(msg, &k);
	
}