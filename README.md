#Projekt Przedsiębiorstwa Samochodowego.

Projekt ten wykorzystuje następujące wzorce projektowe:

##KREACYJNE

-Fabryki - Do tworzenia obiektów klasy nadrzędnej Wehikuł.

-abstrakcyjne

-korzystające z reflekcji

-korzystające z interfejsu funkcyjnego supplier

-korzystające z metody wytwórczej

-Singleton - Prezes Firmy, Singleton typu Double Lock Checking

-Budowniczy - Wbudowany w odpowiednie klasy obiektów Wehikuł

POŁĄCZENIE: Wzorzec BUDOWNICZY został wykorzystywany do tworzenia obiektów w FABRYKACH.


##STRUKTURALNE

-Kompozyty - do stworzenia hierarchii pracowników oraz do umożliwienia występowania zespołów oraz prowadzących grupy.

-Dekorator - zastosowałem wzorzec dekorator w kilku miejschach

1) Restauracja. Występują składniki bazowe dań takich jak Danie Główne bądź Deser. Dekorator służy do stworzenia posiłku poprzez dodawanie do elementu głównego kolejnych dodatków.

2) Fabryka. Dekoracja na fabrykach daje nam kolejne możliwości oferowane przez fabryki, taki jak: zmiana pojemności silnika wehikułu albo przemalowanie go.

POŁĄCZENIE - Wzorzec DEKORATOR został użyty również na elementach Kompozytu. Umożliwiają przerabianie pracowników z brakiem możliwości kierowania zespołem na takich, co te umiejętności posiadają. Również możliwe jest działanie w drugą stronę, czyli pozbawienie pracownika takich kwalifikacji.


##CZYNNOŚCIOWE

-WIZYTOR - służą do zwiększania bądź zmniejszania wynagrodzenia pracowników oraz regulowania ich ilości dni wolnych.

-OBSERWATOR - Wzorzec obserwator występuje w Klasie Księgowa. Obiekty Księgowej służą do kontrolowania zmian w płacach bądź ilości dni wolnych pracowników. Obserwują zmiany.

POŁĄCZENIE: Wzorzec Wizytator został połączony z wzorcem Obserwator. Przy każdej wizycie, która coś zmienia w polach pracowników, księgowa jest powiadamiana o tych zmianach i adekwatnie koryguje informacje, które posiada o pracownikach.