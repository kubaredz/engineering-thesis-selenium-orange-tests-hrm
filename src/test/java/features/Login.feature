Feature: Testy weryfikujace panel logowania uzytkownika

  Background:
    Given Wejscie na strone OrangeHRM

  @test
  Scenario: Logowanie administratora na stronie Orange HRM
    Given Podanie loginu uzytkownika: "Admin"
    And Podanie hasla uzytkownika: "admin123"
    When Wcisniecie przycisku logowania
    Then Ekran glowny aplikacji z logo OrangeHRM zostal wyswietlony
    And Zamkniecie przegladarki

  @test
  Scenario: Niepoprawne podanie danych przy logowaniu uzytkownika zwraca inofrmacje "Invalid credentials"
    Given Podanie loginu uzytkownika: "InvalidUsername123"
    When Podanie hasla uzytkownika: "InvalidPassword123"
    Then Strona po przeladowaniu wyswietla informacje "Invalid credentials"
    And Zamkniecie przegladarki
