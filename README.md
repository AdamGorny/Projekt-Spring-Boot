(Adam)\
(26.05) sortowanie zamówień, poprawa wyszukiwania, drobne poprawki\
(23.05): Naprawiłem to wylogowywanie, ale prawidłowo powinno się gdzieś w sesji trzymać informacje o zalogowanym kliencie a najlepiej to zrobić jakąś dedykowaną biblioteką, bo w tym co teraz jest trzeba za każdym razem wysyłać wszystkie dane wczytując stronę klienta. Mimo wszystko zostawiłbym to tak jak jest, chyba że ktoś chce się pobawić.

&#8595;&#8595;&#8595;
--------------------------------------
(Maciek) (22.05): Projekt jest już praktycznie gotowy! Są tylko dwie małe rzeczy, które przydałoby się poprawić (a których nie potrafiłem): 
  - ~~sortowanie tabeli z zamówieniami (na stronie klienta)~~
  - ~~dodawanie zamówienia (na stronie klienta) wylogowywuje go (przydałoby się zaktualizować listę zamówień bez odświeżania strony, ale nie wiem jak to zrobić)~~
  - (OPCJONALNIE) dodać więcej rekordów do bazy użytkowników, butów, zamówień (jeśli ktoś z Was się nudzi)

Poza tym wszystko jest ok, dobra robota!

--------------------------------------

login do konsoli: sa

hasło: 1234

Możecie tutaj napisać sugestie, opinie, rzeczy do zrobienia...

DO ZROBIENIA (na razie):
  - ~~dodanie listy zakupionych butów do klienta (ewentualnie inne, dodatkowe atrybuty)~~
  - ~~dodanie zapytań do bazy danych~~
  - ~~mozna dodac system logowania/rejestracji z baza uzytkownikow i mozliwosc edycji/dodawania/usuwania dac tylko administratorowi a klientom mozliwosc wybierania produktow i zlozenia zamowienia (wtedy tez baza zamowien powiazana z klientami)~~
  - teoretycznie filtrowanie, ale nie wiem czy to jest potrzebne jeśli wyszukiwanie działa na wszystkie pola

Adam:
  - dodalem wyswietlanie listy butów z edycją dodawaniem i usuwaniem
  - uzywalem thymeleaf do polaczenia z backendem, lepiej by pasowalo php ale imo bez sensu jak uzywamy springa pisac zapytania do bazy w php
  - wyszukiwanie + sortowanie

**Jak połączyć github z intellij:**
1. kliknac na nazwe obecnie otwartego pliku lub bezposrednio z menu glownego -> get from version control (VSC)
2. zalogowac sie na konto github i pobrac git jak nie ma
3. wybrac to repo i clone
4. po zrobieniu zmian w projekcie z lewego paska lub u góry z main wybrać commit
5. zrobić commit i push z komentarzem co zmienione
