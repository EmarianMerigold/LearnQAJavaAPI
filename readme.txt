-------------------Allure----------------------

Команда для запуска Allure в командной строке:
allure serve allure-results

----------------------------------------------


-------------------Docker----------------------

Загрузка образа Maven:
docker pull maven:3.9.6-openjdk-14

Создание образа:
docker build -t java_api_tests .

Запуск контейнера на основе образа выше:
docker run --rm --mount type=bind,src=$(pwd),target=/tests/ java_api_tests

Создание и запуск образа через Composer:
docker compose up --build

Запуск уже существующего образа в Composer (нужен, если зависимости тестов не менялись):
docker compose up

-----------------------------------------------