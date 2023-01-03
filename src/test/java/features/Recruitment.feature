Business Need: Weryfikacja dodania nowego stanowiska pracy

Feature: Testy weryfikujace panel Recruitment

  Background: Wejscie na strone Orange HRM oraz zalogowanie uzytkownika
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  @test
  Scenario Outline: Dodanie nowego stanowiska pracy oraz weryfikacja ze po dodaniu jest widoczne na liscie
    Given Przejscie do sekcji: Recruitment
    And Wybranie opcji z listy: Vacancies
    And Wcisniecie przycisku: Add
    And Wygenerowanie nazwy wakatu
    And Podanie typu pracy: QA Engineer
    And Dodanie opisu: Stanowisko dla osoby z doswiadczeniem wiekszym niz 2 lata
    And Polecajacy uzytkownik to aktualnie zalogowany uzytkownik
    And Ustawienie ilosci ogloszen: <ilosc_ogloszen>
    When Wcisniecie przycisku: Save
    Then Alert sukces zostal wyswietlony
    And Zamkniecie przegladarki

    Examples:
      | ilosc_ogloszen |
      | 1              |
      | 9              |

