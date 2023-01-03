Business Need: Weryfikacja dodania czasu pracy na danym projekcie w sekcji Time

Feature: Testy weryfikujace panel Time

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  @test
  Scenario: Dodanie godzin pracy za aktualny tydzien na karcie ewidencji czasu pracy
    Given Przejscie do sekcji: Time
    And Wcisniecie rozwijanej listy: Timesheets
    And Wybranie opcji z listy: My Timesheets
    And Wcisniecie przycisku: Edit
    And Zresetowanie raportu
    And Wybranie projektu: ACME Ltd
    And Wybranie rodzaju pracy: Administration
    And Dodanie 8 godzin pracy dla 5 dni roboczych
    When Wcisniecie przycisku: Save
    Then Alert sukces zostal wyswietlony
    And Zamkniecie przegladarki
