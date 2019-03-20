;-------------------------------------------------------------------------
 .386 
 .MODEL FLAT, STDCALL
OPTION CASEMAP:NONE
INCLUDE C:\masm32\include\windows.inc
.data
msg db 'Hello, World!', 0Dh, 0Ah,'$'
len equ $ - msg
.CODE
DllEntry PROC hInstDLL:HINSTANCE, reason:DWORD, reserved1:DWORD
mov eax, TRUE 
ret
DllEntry ENDP
;------------------------------------------------------------------------- 
; To jest przyk³adowa funkcja. Jest tutaj, aby pokazaæ, 
; gdzie nale¿y umieszczaæ w³asne funkcje w bibliotece DLL 
;-------------------------------------------------------------------------
MyProc1 proc x: DWORD, y: DWORD
xor eax,eax
mov eax,x 
mov ecx,y 
ror ecx,1 
shld eax,ecx,2 
jnc ET1 
mul y 
ret 
ET1: 
Mul x 
Neg y 
ret
MyProc1 endp

MyProc2 proc x: DWORD, y:DWORD

;mov dx, msg
;mov cx, len
;mov bx, 1
;mov ah, 40h
;int 21h
 
std
cld
sub eax, eax

sub eax, y
add eax, y
mov eax, x
add eax, y


ret

MyProc2 endp


END DllEntry
;-------------------------------------------------------------------------






;std
;cld
;xor eax, eax
;sub eax, y
;mov eax, x
;add eax, y