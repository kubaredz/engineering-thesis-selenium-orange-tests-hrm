Feature: Testy weryfikujace panel administratora

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  @test
  Scenario Outline: Jako zalogowany administrator dodanie nowego uzytkownika
    Given Przejscie do sekcji: Admin
    And Wcisniecie przycisku Add
    And Wybranie User Role: <role>
    And Imie zalogowanego uzytkownika zostaje zaladowane
    And Login pracownika zostanie wygenerowany
    And Haslo pracownika to: Pa$$word123!
    And Wpisanie ponownie hasla: Pa$$word123!
    * Status pracownika to: Enabled
    When Przycisk save zostaje wcisniety
    Then Alert sukces zostal wyswietlony
    And Strona User Management zostala zaladowana
    And Zamkniecie przegladarki

    Examples:
      | role  |
      | Admin |
      | ESS   |
