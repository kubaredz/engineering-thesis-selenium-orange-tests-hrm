PL![image](https://github.com/kubaredz/engineering-thesis-selenium-orange-tests-hrm/assets/82051368/eab271be-1680-4825-be00-5dc400f61493)

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

ENG![image](https://github.com/kubaredz/engineering-thesis-selenium-orange-tests-hrm/assets/82051368/bc0f2cc7-22bd-4cdc-853c-e9899d8b884f)

<b> Engineering thesis [engineering-thesis-selenium-orange-hrm] manual: </b> <br><br>

<b> Installation: </b> <br>
The engineering work uses the following tools and software, for this you need to install: <br>
- Development environment e.g. <b> IntelliJ IDEA</b> link: https://www.jetbrains.com/idea/download/#section=windows <br>
- Java <b>JDK</b> version 19 - link: https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html <br>
- Browser <b>Google Chrome</b> version older than: 108.0.5359.125 link: https://www.google.com/intl/pl_pl/chrome/ <br>
- Browser <b>Mozilla Firefox</b> older than: 108.0.2 link: https://www.mozilla.org/en-US/firefox/108.0.2/releasenotes/ <br><br>

<b> Taking dependencies in Maven: </b> <br>
Next, open the project and download the dependencies. The dependencies should puff in the background, however, if this is the case
there would be no place, please go to the file: *pom.xml* and download the dependencies by running Maven in the background. <br><br>


<b> Run tests: </b> <br>
- To run tests <b> without generating a report</b> go to the folder: "src/test" and then click the folder "test" with the right mouse button and press: <b> Run 'All Features in: test' </ b>.
The important aspect is that you need to run the tests with the TestNG tool (not Junit)
At this point, all tests will run locally. Testing time is about 25 minutes. <br>
- To run tests <b> with Allure</b> report generation, go to the terminal in the Intelij Idea program or to the terminal on the PC. Go to the location where the project was saved: praca-engineering and then run the command: <br><br>
<a>mvn clean test</a> <br>
At this point, all tests will be run from the location: "src/test" duration approx. 25 minutes. <br><br>
<a>mvn allure:report</a> <br>
At this point, a report of the tests performed using the Allure tool will be generated.

The above report will be placed automatically under the location: <p> "target/site/allure-maven-plugin/index.html" </p> <br>
To open the above report, open index.html, for example, in Intelij IDEA and then select the type of browser in which the report
is to be opened. <br>

In the file: "src/test/resources/configuration.properties" you can change parameters such as: <br>
- typeOfBrowser = CHROME or FIREFOX
- url - address of the tested website
- implicitlyWaitTime - which defines the implicit wait for elements on the page in seconds
- login - which will be used to log in to the OrangeHRM website
- password - which will be used to log in to the OrangeHRM website

<b>Run tests on Jenkins</b> <br>

- To run tests using Jenkins, install the server from the website: https://www.jenkins.io/download/
- After installation, go to the declared port on which the server will be launched, for example: http://localhost:8080/
- You need to install the plugin: "Allure Jenkins Plugin"
- Add a new project along with a new job.
- Then go to the new project and add the Code Repository with the url: https://bitbucket.org/kuba_redzinski/praca-inzynierska-selenium-orange-hrm and select the branch: "*/master"
- In the Build Steps section, set: Invoke top-level Maven targets with the setting: "clean install -DskipTests"
- In the Build Steps section, add another: Invoke top-level Maven targets with the setting: "test -Dbrowser=${browserType}"
- In the Actions after task section, add: "Allure Report" and set the "path" with the setting: "target/allure-results"
- Checkbox: "This task is parameterized" from "Choicelist": name is: "browserType" and picklist is: "CHROME (and in a new line) FIREFOX"
- Save and go to "job"
- Then, run the "job" with parameters (possible choice of browser is CHROME or FIREFOX), after selecting the browser, press the button: "Build"
- At this point, the tests will be launched and it will take about 15 minutes
- After the build is finished, a report will be added in the form of Allure Report which should be opened.
