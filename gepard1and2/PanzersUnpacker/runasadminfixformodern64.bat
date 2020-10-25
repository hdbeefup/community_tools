@echo off
REM This will make things running on more modern systems...
REM FOR 64BIT SYSTEMS. MADE AND TESTED USING WINDOWS 8.1 Embedded Industry Pro
REM BY BADS.TM 2017 12 10

REM MODIFY IF YOU'RE 32 BIT USER (%systemroot%\system32\RICHTX32.OCX)

REM IMPLEMENT %~dp0 IN ENGINE128-SETA L AND TINY (Starting dir)

REM xcopy /s c:\source d:\target
REM RichTx32.ocx
copy %~dp0\RichTx32.ocx %systemroot%\syswow64\
regsvr32.exe %systemroot%\syswow64\RICHTX32.OCX

REM comdlg32.ocx
copy %~dp0\comdlg32.ocx %systemroot%\syswow64\
regsvr32.exe %systemroot%\syswow64\comdlg32.ocx
pause