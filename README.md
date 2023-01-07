<b> Praca inzynierska [praca-inzynierska-selenium-orange-hrm] instrukcja obsługi: </b> <br><br>

<b> Instalacja: </b> <br>
Praca inzynierska wykorzystuje ponizsze narzedzia oraz oprogramowania, w tym celu należy zainstalowac : <br>
- Srodowisko programistyczne np. <b> IntelliJ IDEA </b> link: https://www.jetbrains.com/idea/download/#section=windows <br>
- Java <b> JDK </b> w wersji 19 - link: https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html <br>
- Przegladarke <b> Google Chrome </b> w wersji starszej niz: 108.0.5359.125 link: https://www.google.com/intl/pl_pl/chrome/ <br>
- Przegladarke <b> Mozilla Firefox </b> w wersji starszej niz: 108.0.2 link: https://www.mozilla.org/en-US/firefox/108.0.2/releasenotes/ <br><br>

<b> Zaciagniecie zaleznosci w Maven: </b> <br>
Nastepnie nalezy otworzyc projekt i zaciagnac zaleznosci. Zaleznosci powinny zaciagnac sie w tle, jednak jesli taka sytuacja
nie miala by miejsca prosze o przejscie do pliku: *pom.xml* i zaciagnac zaleznosci przez uruchomienie Mavena w tle. <br><br>


<b> Uruchomienie testow: </b> <br>
- Aby uruchomic testy <b> bez generowania raportu </b> naleze przejsc do folderu: "src/test" a nastepnie wcisnac folder "test" prawym przyciskiem myszy i wcisnac: <b> Run 'All Features in: test' </b>. 
Waznym aspektem jest, ze nalezy uruchomic testy przy pomocy narzedzia TestNG (nie Junit)
W tym momencie zostana uruchomione wszystkie testy lokalnie. Czas wykonywania testow to ok. 25 minut. <br>
- Aby uruchomic testy <b> z wygenerowaniem raportu Allure</b> nalezy przejsc do terminala w programie Intelij Idea lub, terminala na PC. Przejsc do lokalizacji w ktorej zostal zapisany projekt: praca-inzynierska a nastepnie uruchomic polecenia: <br><br>
<a>mvn clean test</a> <br>
W tym momencie zostana uruchomione wszystkie testy z lokalizacji: "src/test" czas trwania ok. 25 minut. <br><br>
<a>mvn allure:report</a> <br>
W tym momencie zostanie wygenerowany raport z przeprowadzonych testow przy pomocy narzedzia Allure.

Powyzszy raport zostanie umieszony automatycznie pod lokalizacja: <p> "target/site/allure-maven-plugin/index.html" </p> <br>
Aby otworzyc powyzszy raport nalezy otworzyc index.html przykladowo w Intelij IDEA a nastepnie w wybrac rodzaj przegladarki w ktorym raport
ma zostac otwarty. <br>

W pliku: "src/test/resources/configuration.properties" mozna zmieniac parametry takie jak: <br>
- typeOfBrowser = CHROME lub FIREFOX
- url - adres strony testowanej
- implicitlyWaitTime - ktory to definiuje oczekiwanie niejawne na elementy na stronie w sekundach
- login - ktory zostanie wykorzystany do logowania na stronie OrangeHRM
- haslo - ktore zostanie wykorzystane do logowania na stronie OrangeHRM

<b> Uruchomienie testow na Jenkinsie </b> <br>

- Aby uruchomic testy przy pomocy Jenkinsa nalezy zainstalowac serwer ze strony: https://www.jenkins.io/download/ 
- Po zainstalowaniu nalezy przejsc do zadeklarowanego portu na ktorym serwer zostanie uruchomiony, przykladowo: http://localhost:8080/ 
- Nalezy zainstalowac dodatek (plugin): "Allure Jenkins Plugin"
- Nalezy dodac nowy projekt wraz z nowym jobem.
- Nastepnie nalezy przejsc do nowego projektu i dodac Repozytorium kodu z adresem url: https://bitbucket.org/kuba_redzinski/praca-inzynierska-selenium-orange-hrm oraz wybrac branch: "*/master"
- W sekcji Build Steps nalezy ustawic: Invoke top-level Maven targets z ustawieniem: "clean install -DskipTests"
- W sekcji Build Steps nalezy dodac kolejny: Invoke top-level Maven targets z ustawieniem: "test -Dbrowser=${browserType}"
- W sekcji Akcje po zadaniu nalezy dodac: "Allure Report" i ustawic sciezke "path" z ustawieniem: "target/allure-results"
- Nalezy zaznaczyc checkbox: "To zadanie jest sparametryzowane" z "Lista wyboru": nazwa to: "browserType" a lista wyboru to: "CHROME (i w nowej linii) FIREFOX"
- Nalezy zapisac i przejsc do "job-a"
- Nastepnie nalezy uruchomic "job-a" wraz z parametrami (mozliwy wybor przegladarki to CHROME lub FIREFOX), po wyborze przegladarki nalezy wcisnac przycisk: "Buduj"
- W tym momencie zostana uruchomione testy i potrwa to ok. 15 min
- Po zakonczeniu budowania, zostanie dodany raport w postaci Allure Report ktory to nalezy otworzyc.