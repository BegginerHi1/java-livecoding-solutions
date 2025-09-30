# Задачи для тренировки live-coding (Java версия)

Репозиторий содержит задачи, отобранные для тренировки навыков live-coding на Java, и тесты к ним для проверки.

## Структура проекта

### Основные задачи (`src/main/java/ru/nazarovsa/livecodingtraining/`)
- **arrays** - задачи с массивами
- **binarysearch** - задачи по бинарному поиску
- **binarytree** - задачи с бинарными деревьями
- **datastructures** - структуры данных (MyQueue)
- **hashtable** - задачи с хеш-таблицами
- **linkedlists** - задачи со связанными списками
- **matrix** - задачи с матрицами
- **numbers** - задачи с числами
- **strings** - задачи со строками
- **yieldreturn** - задачи с lazy evaluation

### Тесты (`src/test/java/ru/nazarovsa/livecodingtraining/`)
- Для каждой категории задач есть соответствующие тесты
- Используется JUnit 5 и AssertJ

## Технологии
- **Java 21** - основной язык программирования
- **Maven** - система сборки и управления зависимостями
- **JUnit 5** - фреймворк для тестирования
- **AssertJ** - библиотека для fluent assertions
- **Lombok** - для уменьшения boilerplate кода

## Запуск тестов

Для запуска всех тестов:
```bash
mvn test
```

Для запуска конкретного тестового класса:
```bash
mvn test -Dtest="ArrayTasksTest"
```

Для запуска конкретного теста:
```bash
mvn test -Dtest="ArrayTasksTest#testIsAllPossibilities"
```

## Использование
Каждый класс с задачами содержит методы-заглушки, которые выбрасывают `UnsupportedOperationException`. 
Ваша задача - реализовать эти методы согласно описанию в комментариях.

Тесты помогут вам проверить правильность реализации.
