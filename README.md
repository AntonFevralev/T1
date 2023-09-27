<div>

![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![JetBrains](https://img.shields.io/badge/IntelliJ%20IDEA-java-blue?style=for-the-badge&logo=jetbrains&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-green?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-blue?style=for-the-badge&logo=docker&logoColor=white)
</div>


# T1
## Тестовое задание компании Т1 Консалтинг

Данное приложение позволяет посчитать частоту встречи символов в строке.
Требования к строке: Строчные, либо заглавные буквы английского алфавита 1-100 знаков.  
При попытке передать любое другое значение будет выброшена ошибка 400.  
Пример входной строки: “aaaaabcccc”  
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

# Запуск приложения
Для запуска данного приложения потребуется Docker.

Стартовая команда для запуска контейнера

```
docker run -d -p 8080:8080 ghcr.io/antonfevralev/t1:release
```

Приложение будет развернуто по ссылке


<a href>http://localhost:8080/swagger-ui/index.html</a>
