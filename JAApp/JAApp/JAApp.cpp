
// JAApp.cpp : Defines the entry point for the console application. //
#include "stdafx.h" 
#include <windows.h>
#include "JAApp.h"

int _tmain(int argc, _TCHAR* argv[])  { 

	char szString[] = {'A','G','I','K','S','Z','J', 0xFF}; // definicja ciagu znakow 

	printf("FindChar_1 %s\n", (FindChar_1()==1 ? "Found J" : "Not Found J"));
	printf("FindChar_2 %s\n", (FindChar_2()==1 ? "Found J" : "Not Found J"));
	printf("FindChar_3 %s\n", (FindChar_3(szString) ? "Found J" : "Not Found J"));
	printf("FindChar_4 %s\n", (FindChar_4()==1 ? "Found J" : "Not Found J"));
	printf("FindChar_5 %s\n", (FindChar_5()==1 ? "Found J" : "Not Found J"));
	printf("FindChar_6 %s\n", (FindChar_6()==1 ? "Found J" : "Not Found J"));

	//int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
	//ReadTime_1(&a1, &a2, &a3, &a4, &a5);
	//printf("Czas przetwarzania: %i\n", a1);
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 1: %i\n", ReadTime_1(FindChar_1));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 2: %i\n", ReadTime_1(FindChar_2));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 3: %i\n", ReadTime_1(FindChar_3));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 4: %i\n", ReadTime_1(FindChar_4));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 5: %i\n", ReadTime_1(FindChar_5));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania 6: %i\n", ReadTime_1(FindChar_6));
	}
	printf("\n");
	for(int i=0; i<4; i++){
	printf("Czas przetwarzania: %i\n", ReadTime_1(FindChar));
	}



	MessageBox (NULL, L"Wyci¹gnij wnioski", L"Lab. 2", MB_OK);

	return 0; 
	
}
