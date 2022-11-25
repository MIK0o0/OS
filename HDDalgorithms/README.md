Symulacja algorytmów planowania dostępu do dysku.
1. Zaimplementować algorytmy FCFS, SSTF, SCAN i C-SCAN.
2. Następnie założyć, że w systemie istnieją także aplikacje real-time, które musza być obsłużone za pomocą
EDF oraz FD-SCAN. Jak wpływa to na wyniki? Zaimplementować również algorytmy EDF oraz FD-SCAN.


Wskazówki:
 'Dysk' to w naszym przypadku liniowo uporządkowany ciąg bloków o nr od 1 do MAX.
 Kryterium oceny alg. będzie suma przemieszczeń głowicy dysku, jak wiadomo proporcjonalna do czasu realizacji zleceń.
 Sformułowanie nie wymienionych powyżej warunków symulacji należy do Państwa tzn.: wielkość 'dysku' (ilość bloków),
liczba i sposób generowania zgłoszeń (pełna kolejka od początku? zgłoszenia w trakcie? rozkład zgłoszeń- równomierny,
inny?), sposób uwzględnienia obsługi zgłoszeń real-time. 
