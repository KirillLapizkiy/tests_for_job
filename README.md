Проект написан на: java 8.0 + TestNG + Selenium + Gradle

Тестируемый сайт http://automationpractice.com/index.php

**Настройка проекта**
1. В Settings->Build,Execution,Deployment->Build Tools->Gradle установить:
1.1 Build and run using и Run tests using  - Intellij Idea
   Gradle JVM - java 1.8

2. Project SDK - java 1.8 

3. geckodriver от firefox разместить в папку из переменных среды (на ОС Windows можно положить в папку System32)

**Работа с проектом**
0. В классе TestBase.java в BrowserType.FIREFOX - указание на браузер, в котором запускать автотесты

1. В файле local.properties указан логин и пароль от тестовой учётки (если протухнут, 
   можно завести новую учётку на сайте и заменить логин и пароль в файле с пропертями и всё взлетит)
   
2. Автотесты запускаются тестовыми наборами(suits) тасками из файла build.gradle
`task testWishList
task testSearch`

3. После прогона формируется отчет allure в папке target\allure-results (приложено два примера от прогонов)

4. Что бы преобразовать данные из xml отчётов allure можно использовать плагин allure-commandline(приложен к проекту)

5. После распаковки плагина allure-commandline необходимо из папки с ним запустить командную строку 
   и проверить работоспособность командой: c:\Windows\System32\allure\bin\allure.bat help
`  пример команды: c:\Users\kir9l\IdeaProjects\CB>c:\Windows\System32\allure\bin\allure.bat help
   N.B. т.е. у меня локально проект лежит по пути c:\Users\kir9l\IdeaProjects\CB)`
   
6. После успешной отработки в командной строке подсказки(help), необходимо написать и запустить команду generate 
   и путь до файлов .xml: *путь до плагина*\allure\bin\allure.bat generate target\allure-results
   `пример команды: c:\Users\kir9l\IdeaProjects\CB>c:\Windows\System32\allure\bin\allure.bat generate target\allure-results`

7. Пример сформированного allure отчёта для открытия в браузере лежит в репозитории по пути CB\allure-report\index.html

p.s. Знаю, что отчёты и вебдрайверы не принято хранить в самой репе, 
это сделано для упрощения работы проверяющего тестовое задание

@Author (Лапицкий Кирилл Владиславович, 8-913-101-6898, kir9lapizkiy@gmail.com)