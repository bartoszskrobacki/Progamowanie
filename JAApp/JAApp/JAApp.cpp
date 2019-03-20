
// JAApp.cpp : Defines the entry point for the console application. //
#include "stdafx.h" 
#include <windows.h>

//extern "C" int _stdcall MyProc1 (DWORD x, DWORD y);
//extern "C" int _stdcall MyProc2 (DWORD x, DWORD y);
//extern "C" {void __declspec(dllimport) MyProc2(int x, int y);}
typedef int(_stdcall *MyProc2)(int, int);

int _tmain(int argc, _TCHAR* argv[]) 
{ 
	//MyProc2(2,3);
	HINSTANCE dynamicznie = LoadLibraryA("JADll");
	if(dynamicznie==nullptr)
	{
		return 0;
	}

	MyProc2 ProcDynamicznie = (MyProc2)GetProcAddress(dynamicznie, "MyProc2");
	
	if(ProcDynamicznie)
	{
		int x = 0x7FFFFFFF, y = 4, z = 0;
		z = ProcDynamicznie (x, y);
	}

	FreeLibrary(dynamicznie);
	
	return 0; 
}