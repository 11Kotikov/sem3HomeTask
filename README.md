# Spring Boot Home Task

Spring Boot приложение для обработки данных пользователей.

## Описание

Проект включает в себя сервис регистрации пользователей с основными операциями, такими как сортировка, фильтрация и расчет среднего возраста.


## Использование

- **Добавление пользователя:**
    - Отправьте POST-запрос на `http://localhost:8080/user/registration` с телом запроса, содержащим данные пользователя в формате JSON.

- **Получение списка пользователей:**
    - Отправьте GET-запрос на `http://localhost:8080/user` для получения списка зарегистрированных пользователей.

- **Сортировка пользователей по возрасту:**
    - Отправьте GET-запрос на `http://localhost:8080/tasks/sort` для получения отсортированного списка пользователей.

- **Фильтрация пользователей по возрасту:**
    - Отправьте GET-запрос на `http://localhost:8080/tasks/filter/{age}` с указанием желаемого возраста для фильтрации.

- **Расчет среднего возраста пользователей:**
    - Отправьте GET-запрос на `http://localhost:8080/tasks/calc` для получения среднего возраста пользователей.


## Дополнительно
1. User Registration
![User Registration](https://github.com/11Kotikov/sem3HomeTask/blob/master/registrationPostMan.png?raw=true)
2. User Filter
![User Filter](https://github.com/11Kotikov/sem3HomeTask/blob/master/filterPostMan.png?raw=true)
3. User calc
![User calc](https://github.com/11Kotikov/sem3HomeTask/blob/master/calcPostMAN.png?raw=true)

### Данные, на которых проверялись задачи:
```json
[
{
"name": "Isaac Newton",
"age": 84,
"email": "isaac.newton@example.com"
},
{
"name": "Albert Einstein",
"age": 76,
"email": "albert.einstein@example.com"
},
{
"name": "Galileo Galilei",
"age": 77,
"email": "galileo.galilei@example.com"
}
]
```
### Дополненное решение от 01.03.2024

- создан пост-обработчик для добавления 1го пользователя
- реализован GoF-паттерн Singleton:
``` Отправьте POST-запрос на `http://localhost:8080/user/addUser` для получения среднего возраста пользователей. ```
- пример запроса:
```  
  {
    "name": "Andrew",
    "age": 34,
    "email": "andrew@example.com"
  } 
 ```