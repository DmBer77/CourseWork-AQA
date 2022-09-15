#### Порядок действий

1. Запустить Docker Desktop (если на компьютер Docker не установлен, скачать по ссылке https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?utm_source=docker&utm_medium=webreferral&utm_campaign=dd-smartbutton&utm_location=header и установить)
2. Открыть клонированный проект в IDEA
3. в терминале ввести команду: docker compose up
4. в случае если образ MySQL ранее не был загружен в Docker - дождаться окончания скачивания образа, формирования и запуска контейнера
5. в терминале ввести команду: java -jar artifacts/aqa-shop.jar
6. в терминале ввести команду: .\gradlew allureServe (для отслеживания выполнения тестов и формирования отчета Allure)
7. запустить на выполнение автотесты
8. после прогона тестов перейти в папку build/reports/tests/test и запустить файл index.html (для просмотра отчетов Allure)

p.s. после каждого ввода команды в терминале дожидаться полной загрузки