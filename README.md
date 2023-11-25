# Дипломный проект по тестированию API для [reqres.in](https://reqres.in/)

## :open_book: Содержание

- [Технологии и инструменты](#gear-технологии-и-инструменты)
- [Реализованныe проверки](#heavy_check_mark-тест-кейсы)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## :gear: Технологии и инструменты

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logos/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logos/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/logos/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logos/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logos/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="media/logos/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media\logos\Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="media\logos\Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
</p>

## :heavy_check_mark: Тест кейсы

- Получение списка пользователей
- Проверка наличия пользователя в базе
- Создание нового пользователя
- Обновление данных пользователя
- Успешная регистрация
- Проверка id, email пользователя
- Проверка email пользователя при помощи Groovy

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
./gradlew clean api
```

## <img width="4%" title="Jenkins" src="media/logos/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/qa-guru-reqres-diplom/)
Для запуска сборки необходимо нажать кнопку <code><strong>*Build with Parametrs*</strong></code>.

<p align="center">
  <img src="media/screenshots/JenkinsProject.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*Build history*</strong></code> напротив номера сборки появится
значок *Allure Report* и *Allure TestOps* кликнув по которому, откроется страница с сформированным html-отчетом и тестовой документацией.

## <img width="4%" title="Allure Report" src="media/logos/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/qa-guru-reqres-diplom/allure/)

<p align="center">
  <img src="media/screenshots/AllureReport.png" alt="allure-report" width="900">
</p>

<p align="center">
  <img src="media/screenshots/AllureSuite.png" alt="allure-report_1" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="media/logos/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3849/dashboards)

### Основной дашборд

<p align="center">
  <img src="media/screenshots/AllureTestOpsDash.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="media/screenshots/AllureTestOpsResult.png" alt="dashboard" width="900">
</p>

### Тест-кейсы

<p align="center">
  <img src="media/screenshots/AllureTestOpsTestCase.png" alt="testcase" width="900">
</p>

## <img width="4%" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screenshots/TelegramNotification.png">
