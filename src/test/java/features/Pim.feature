Business Need: Weryfikacja dodawania raportu w panelu PIM

Feature: Testy weryfikujace panel PIM (Personeels Informatie Manager)

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM
    And Zalogowanie uzytkownika do strony OrangeHRM

  @test
  Scenario Outline: Dodanie nowego raportu jako zalogowany uzytkownik z informacja na temat stopnia naukowego pracownika
    Given Przejscie do sekcji: Pim
    And Wcisniecie przycisku przechodzacego do sekcji PIM-Reports
    And Wcisniecie przycisku Add
    And Podanie nazwy raportu: Raport
    And Wybranie kryterium raportu: Education
    And Przycisk plus dla selection criteria zostal wcisniety
    And Wybranie stopnia naukowego: <stopien>
    And Pola z sekcji które mają zostać wyświetlone w raporcie to: Contact Details
    And Wybranie dokladnych danych jakie maja zostac wyswietlone: Address
    And Przycisk plus dla display fields zostal wcisniety
    When Przycisk save zostaje wcisniety
    Then Alert sukces zostal wyswietlony
    And Zamkniecie przegladarki

    Examples:
      | stopien               |
      | Bachelor's Degree     |
      | College Undergraduate |
      | High School Diploma   |
      | Master's Degree       |
