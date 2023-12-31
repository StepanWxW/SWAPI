# Задание: Мобильное приложение "Звездные Войны"
### Описание 

В этом задании реализовал простое мобильное приложение для поиска и сохранения ресурсов "Звездных Войн" (персонажей и звездолетов). Для получения данных использовался **SWAPI**.

### Основные функции 

Приложение имеет две основные страницы:

#### Домашняя страница
На домашней странице отображается элемент ввода, который позволяет пользователю искать персонажей, звездолеты и планеты по имени. Вызов API инициируется только после ввода не менее 2 символов.

На странице поиска и в избранном отображается:

Для персонажей "Звездных войн": "имя, пол и количество звездолетов, которые пилотировал этот человек".
Для звездолетов: "имя, модель, производитель, пассажиры".

#### Страница избранного

На странице избранного отображаются персонажи и звездолеты, которые были отмечены как избранные.


БОНУС: К персонажам и звездолётам добавить третий тип объектов - планеты. Для планет показывать в списке название, диаметр, кол-во населения.

БОНУС: На странице избранного нужно отображать «название, режиссер и продюсер» для фильмов.

Вам решать, где хранить избранное, но оно должно быть постоянным (храниться между запусками приложения).

---
---
### Технологии и инструменты

- Приложение разработано под Android на языке Kotlin.
- Для работы с API используется библиотека Retrofit.
- Для парсинга JSON данных используется библиотека Jackson.
- Корутины (Kotlin Coroutines) используются для управления асинхронными запросами.
- Для хранения данных о избранных элементах используется SQLite база данных.
- Для отображения списков используется RecyclerView с кастомными элементами.
- Реализованы Unit Тесты для проверки функциональности.

### Установка и запуск

- Клонируйте репозиторий на свой локальный компьютер:
- Откройте проект в Android Studio.
- Запустите приложение на эмуляторе или на своем физическом устройстве.

### Как использовать приложение

- На главной странице приложения введите имя или название звездолета для поиска.
- Найденные совпадения будут отображены под полем ввода. Вы можете кликнуть на зеленое поле, чтобы переключиться между поиском персонажей и звездолетов.
- Рядом с каждым элементом списка поиска есть кнопка "Добавить в избранное". Вы можете кликнуть на нее, чтобы добавить элемент в список избранных.
- Внизу страницы есть кнопка "Перейти в избранное". Кликнув на нее, вы перейдете на страницу избранных элементов.
- На странице избранного отображаются все добавленные вами элементы. Если список избранных пуст, вы увидите соответствующее сообщение. На этой странице есть также кнопка "Удалить все", которая позволяет удалить все элементы из списка избранных.
