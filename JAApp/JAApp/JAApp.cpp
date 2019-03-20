
// JAApp.cpp : Defines the entry point for the console application. //
#include "stdafx.h" 
#include <windows.h>

//extern "C" int _stdcall MyProc1 (DWORD x, DWORD y);
//extern "C" int _stdcall MyProc2 (DWORD x, DWORD y);
typedef void(*MyProc2)(int, int);

int _tmain(int argc, _TCHAR* argv[])  { 
	//MyProc2(2,3);
	HINSTANCE DynamicLib = LoadLibraryA("JADll");
	if (!DynamicLib) return 0;

	MyProc2 FunctionPtr = (MyProc2)GetProcAddress(DynamicLib, "MyProc2");
	
	if(FunctionPtr) {
		int x = 0x7FFFFFFF, y = 4;
		FunctionPtr(x, y);
	}

	FreeLibrary(DynamicLib);
	
	return 0; 
}