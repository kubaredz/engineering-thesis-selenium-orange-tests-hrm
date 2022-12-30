Feature: Testy weryfikujace panel administratora

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  Scenario Outline: Jako zalogowany administrator dodanie nowego uzytkownika
    Given Przejscie do sekcji: Admin
    And Wcisniecie przycisku Add
    And Wybranie User Role: <role>


    Examples:
      | role  |
      | Admin |
      | ESS   |

