Feature: Testy weryfikujace dashboard zalogowanego uzytkownika

  Background: Wejscie na strone orangeHrm
    Given Wejscie na strone OrangeHRM

  @test
  Scenario Outline: Weryfikacja czy wszystkie wymagane sekcje w aplikacji sa wyswietlone
    Given Zalogowanie uzytkownika do strony OrangeHRM
    When Przejscie do wcisnietej sekcji: <sekcja>
    Then Sekcja z naglowkiem <naglowek> zostala wyswietlona
    And Zamkniecie przegladarki

    Examples:
      | sekcja      | naglowek    |
      | Admin       | Admin       |
      | Pim         | PIM         |
      | Time        | Time        |
      | Recruitment | Recruitment |
      | Performance | Performance |

  @test
  Scenario Outline: Weryfikacja wszystkich widniejacych przyciskow w sekcji Quick Launch
    Given Zalogowanie uzytkownika do strony OrangeHRM
    When Wciskam przycisk z sekcji quick launch przekierowywujacy do <sekcja>
    Then Strona z <url> zostala zaladowana
    And Zamkniecie przegladarki

    Examples:
      | sekcja       | url                   |
      | Assign Leave | assignLeave           |
      | Leave List   | viewLeaveList         |
      | Timesheets   | viewEmployeeTimesheet |
      | Apply Leave  | applyLeave            |
      | My Leave     | viewMyLeaveList       |
      | My Timesheet | viewMyTimesheet       |
