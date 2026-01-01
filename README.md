# File Filter Application

Консольное приложение для фильтрации и обработки текстовых файлов с разделением данных по типам.

## Требования

- **Java**: версия 21.0.9 или выше
- **Maven**: версия 3.9.11 или выше (только для сборки)

## Сборка проекта

git clone <repository-url>
cd <project-directory>

# Соберите проект
mvn clean package

# После сборки JAR файл будет доступен по пути:
target/file-filter.jar

## Базовый синтаксис:
java -jar target/file-filter.jar {опции} файл1.txt файл2.txt файл3.txt ...

## Разработал:
Кожевников Егор
