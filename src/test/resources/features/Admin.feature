Feature: Testy weryfikujace panel administratora

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  Scenario: Jako zalogowany administrator dodanie nowego
    Given Przejscie do wcisnietej sekcji: Admin
