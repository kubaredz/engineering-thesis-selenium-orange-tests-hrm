Feature: Testy weryfikujace panel logowania uzytkownika

  @test
  Scenario: Logowanie administratora na stronie Orange HRM
    Given Wejscie na strone OrangeHRM
    When Podanie loginu uzytkownika: "Admin"
    And Podanie hasla uzytkownika: "admin123"
    And Wcisniecie przycisku logowania
    Then Ekran glowny aplikacji z logo OrangeHRM zostal wyswietlony
