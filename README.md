# Java-Lab2

# Отчет по работе: Реализация задач на Java
Бочкарёв Егор ИТ-13,14

## Общее описание
Данный проект представляет собой консольное приложение на Java, которое реализует 5 различных задач:
1. Задание 1. Человек и Имена
2. Задание 2. Человек с именем
3. Задание 3. Города
4. Задание 4. Создаём города
5. Задание 5. Дроби

Программа предлагает пользователю выбрать задачу через меню, затем выполняет соответствующую функцию.

## Структура проекта
- `Main.java` - главный класс с точкой входа и меню выбора
- `Human.java` - создание сущности Человек, которая описывается двумя параметрам: Имя, Рост 
- `Name.java` - создание сущности Имя, которая описывается тремя параметрами: Фамилия, Личное имя, 
Отчество
- `Person.java` - объединение сущности Человек из задачи 1.2 и Имя из задачи 1.3
- `City.java` - создание сущности Город, которая описывается двумя параметрами: Название города, Количество путей к другим городам
- `NewCity.java` - создание сущности НовыйГород, которая описывается двумя параметрами: Название города, Количество путей к другим городам
- `Fraction.java` - создание сущности Дробь, которая описывается двумя параметрами: Числитель, Знаменатель

## Детальный анализ методов

### Задание 1.2 (Человек)

**<ins>Задача:</ins>**

Создайте сущность Человек, которая описывается: 
+ Имя: строка 
+ Рост: целое число 
Может возвращать текстовое представление вида “Name, рост: height”, где Name и height это 
переменная с именем и ростом. 
Необходимо создать и вывести на экран следующих людей: 
+ Человек с именем “Клеопатра” и ростом 152 
+ Человек с именем “Пушкин ” и ростом 167 
+ Человек с именем “Владимир ” и ростом 189

**<ins>Метод решения:</ins>**

Для решения задачи используется класс `Human`. В классе есть 2 поля: `name` и `height`. Также есть конструктор с параметрами, геттеры и сеттеры для каждого из полей, а так же метод возвращения строки `toString`. В классе `Main` создается 3 человека с именами Клеопатра, Пушкин и Владимир и ростом 152, 167 и 189 соответственно. Кажде имя с ростом выводится на экран.

**<ins>Код реализации:</ins>**
```
public class Human
{
    private String name;
    private int height;

    // Геттеры
    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Возвращение строки
    @Override
    public String toString() {
        return this.name + ", рост: " + this.height;
    }

    // Конструктор с параметрами
    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
```

**<ins>Вывод на экран:</ins>**

Клеопатра, рост: 152

Пушкин, рост: 167

Владимир, рост: 189
***

### Задание 1.3 (Имена)

**<ins>Задача:</ins>**

Создайте сущность Имя, которая описывается тремя параметрами: Фамилия, Личное имя, 
Отчество. Имя может быть приведено к строковому виду, включающему традиционное 
представление всех трех параметров: Фамилия Имя Отчество (например “Иванов Иван 
Иванович”). Необходимо предусмотреть возможность того, что какой-либо из параметров может 
быть не задан, и в этом случае он не учитывается при приведении к текстовому виду. 
Необходимо создать следующие имена: 
+ Клеопатра 
+ Пушкин Александр Сергеевич 
+ Маяковский Владимир 
Обратите внимание, что при выводе на экран, не заданные параметры никак не участвуют в 
образовании строки. 

**<ins>Метод решения:</ins>**

Для решения задачи создается новый класс `Name`. Внутри него есть 3 поля: `name`, `surname` и `patronymic`. После реализован конструктор для создания полного имени, если какой-либо параметр не задан: проверяем, если строка не `null` и не пустая, она сохраняется; иначе в поле записывается `null`. Также есть геттеры и сеттеры для каждого поля. В конце метод `toString`, который выводит результат строкой. Причем при выводе учитывается, что не заданные параметры никак не участвуют в образовании строки: cоздаём строку с помощью `StringBuilder`; добавляем только те части ФИО, которые не равны `null`; между словами ставим пробел; в конце `trim()` убирает лишние пробелы. В классе `Main` создаётся 3 человека с ФИО: Клеопатра, Пушкин Александр Сергеевич, Маяковский Владимир.

**<ins>Код реализации:</ins>**
```
public class Name
{
    private String surname;
    private String name;
    private String patronymic;

    // Геттеры
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    // Сеттеры
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    // Возвращение строки
    @Override
    public String toString() {
        StringBuilder empty = new StringBuilder();

        if (surname != null) empty.append(surname).append(" ");
        if (name != null) empty.append(name).append(" ");
        if (patronymic != null) empty.append(patronymic).append(" ");

        return empty.toString().trim();
    }
    
    // Конструктор
    public Name(String surname, String name, String patronymic) {
        this.surname = (surname != null && !surname.isBlank()) ? surname : null;
        this.name = (name != null && !name.isBlank()) ? name : null;
        this.patronymic = (patronymic != null && !patronymic.isBlank()) ? patronymic : null;
    }
}
```

**<ins>Вывод на экран:</ins>**

Клеопатра

Пушкин Александр Сергеевич

Маяковский Владимир
***

### Задание 2.2 (Человек с именем)

**<ins>Задача:</ins>**

Объедините сущности Человек из задачи 1.2 и Имя из задачи 1.3 таким образом, чтобы имя 
человека задавалось с использованием сущности 1.3, а не строки.  
Необходимо объединить ранее созданные объекты имен и людей, с получением: 
+ Человека с Именем Клеопатра и ростом 152 
+ Человека с Именем Пушкин Александр Сергеевичи ростом 167 
+ Человека с Именем Маяковский Владимир и ростом 189

**<ins>Метод решения:</ins>**

Для решения задачи создается новый класс `Person`. В нем есть 2 поля: `name` и `height`. Для выполнения задачи поле `name` является объектом класса `Name`. Также есть конструктор, геттеры и сеттеры для каждого поля. В конце есть метод `toString`, который выводит результат строкой. В `Main` создается 3 имени (как во 2 задании) и им присваивается рост (как в 1 задании). В результате получается 3 имени с ростом: Клеопатра с ростом 152, Пушкин Александр Сергеевич в ростом 167 и Владимир Маяковский с ростом 189.

**<ins>Код реализации:</ins>**
```
public class Person
{
    private Name name;
    private int height;

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return name.toString() + ", рост: " + height;
    }

}
```

**<ins>Вывод на экран:</ins>**

Клеопатра, рост: 152

Пушкин Александр Сергеевич, рост: 167

Маяковский Владимир, рост: 189
***

### Задание 3.3 (Города)

**<ins>Задача:</ins>**

Создайте сущность Город, которая будет представлять собой точку на карте со следующими характеристиками:
+ Название города
+ Набор путей к следующим городам, где путь представляет собой сочетание Города и стоимости поездки в него.

Кроме того, Город может возвращать текстовое представление, в виде названия города и списка связанных с ним городов (в виде пары: “название:стоимость”). Используя разработанную сущность реализуйте схему, представленную на рисунке 2. 

<img width="524" height="240" alt="Снимок экрана 2025-09-29 014131" src="https://github.com/user-attachments/assets/f0991b1b-4396-4d73-a0c6-8d8d052e616d" />

**<ins>Метод решения:</ins>**

Для решения создается новый класс `City`. В нем есть 2 поля: `name` и `ways`. Также есть конструктор и метод для добавления пути из города в город. И как во всех классах есть метод `toString` для вывода ответа строкой: начинает строку с названия города; если есть дороги — добавляет стрелку " -> "; проходит по всем дорогам (ways.entrySet()): road.getKey() — город назначения, road.getValue() — длина дороги; склеивает всё в строку с запятыми. В `Main` создается 6 городов и между ними прокладываются дороги как на рисунке. Итоговый список городов с их дорогами до других городов выводится на экран.

**<ins>Код реализации:</ins>**
```
import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> ways;

    // Конструктор
    public City(String name) {
        this.name = name;
        this.ways = new HashMap<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Map<City, Integer> getWays() {
        return ways;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setWays(Map<City, Integer> ways) {
        this.ways = ways;
    }

    // Добавление дороги
    public void addWays(City city, int way) {
        ways.put(city, way);
    }

    // Возвращение строки
    @Override
    public String toString() {
        String result = name;
        if (!ways.isEmpty()) {
            result += " -> ";
            boolean first = true;
            for (Map.Entry<City, Integer> road : ways.entrySet()) {
                if (!first) result += ", ";
                result += road.getKey().name + ":" + road.getValue();
                first = false;
            }
        }
        return result;
    }
}
```

**<ins>Вывод на экран:</ins>**

A -> B:5, D:6, F:1

B -> C:3, A:5

C -> B:3, D:4

D -> C:4, E:2, A:6

E -> F:2

F -> E:2, B:1
***

### Задание 4.8 (Создаем Города)

**<ins>Задача:</ins>**

Измените сущность Город из задачи 3.3. Новые требования включают: 
+ Город можно создать указав только название 
+ Город можно создать указав название и набор связанных с ним городов и стоимостей путей к ним 

**<ins>Метод решения:</ins>**

Для решения модернизируется класс `City` в `NewCity`, а точнее добавляется два новых конструктора. Первый конструктор может создать город только по имени. Второй конструктор позволяет создать город и сразу задать набор путей в другие города (параметр `connections` — это карта с другими городами и стоимостью дорог). Так же в этой задаче используется метод `toString` для вывода ответа строкой аналогично прошлой задачи. В `Main` создается 3 города только по названию, а один город создаётся сразу с дорогами в другие города (сначала добавляюся дороги и лишь затем создается город с этими дорогами).

**<ins>Код реализации:</ins>**
```
import java.util.HashMap;
import java.util.Map;

class NewCity {
    private String name; // назание города
    private Map<NewCity, Integer> path; // город > стоимость пути

    // Конструктор только с названием
    public NewCity(String name) {
        this.name = name;
        this.path = new HashMap<>();
    }

    // Конструктор с названием и набором связанных городов
    public NewCity(String name, Map<NewCity, Integer> connections) {
        this.name = name;
        this.path = new HashMap<>();
        if (connections != null) {
            this.path.putAll(connections);
        }
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Map<NewCity, Integer> getPath() {
        return path;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(Map<NewCity, Integer> path) {
        this.path = path;
    }

    // Добавление пути
    public void addPath(NewCity city, int cost) {
        path.put(city, cost);
    }

    // Возвращение строки
    @Override
    public String toString() {
        String result = name;
        if (!path.isEmpty()) {
            result += " -> ";
            boolean first = true;
            for (Map.Entry<NewCity, Integer> road : path.entrySet()) {
                if (!first) result += ", ";
                result += road.getKey().name + ":" + road.getValue();
                first = false;
            }
        }
        return result;
    }
}
```

**<ins>Вывод на экран:</ins>**

A

B

C

G -> A:7, B:8
***

### Задание 5.5 (Дроби)

**<ins>Задача:</ins>**

Создайте сущность Дробь со следующими особенностями: 
+ Имеет числитель: целое число
+ Имеет знаменатель: целое число
+ Дробь может быть создана с указанием числителя и знаменателя
+ Может вернуть строковое представление вида “числитель/знаменатель”
+ Может выполнять операции сложения, вычитания, умножения и деления с другой Дробью или целым числом. Результатом операции должна быть новая Дробь (таким образом,обе исходные дроби не изменяются)
Затем необходимо выполнить следующие задачи:
1. Создать несколько экземпляров дробей.
2. Написать по одному примеру использования каждого метода.
3. Вывести на экран примеры и результаты их выполнения в формате «1/3 * 2/3 = 2/9»
4. Посчитать f1.sum(f2).div(f3).minus(5)

**<ins>Метод решения:</ins>**

Для решения создается новый класс `Fraction`. У него есть 2 поля: `numerator` (числитель) и `denominator` (знаменатель). Также есть конструктор, в котором проверяется поле `denominator` на равеноство 0. Если оно выполняется, то система заканчивает работу. Для каждого поля также есть геттер и сеттер. В классе также содержится 4 метода арифметических операций с дробями: сложение, вычитание, умножение, деление. И 4 метода арифметических операций с целыми числами: сложение, вычитание, умножение, деление. В делении также есть проверка на деление на 0. Эти операции реализованы как обычные действия с дробями (В сложении и вычитании 2 дроби приводятся к общему знаменателю, а при делении числитель и знаменатель второй дроби меняются местами и производится умножение). В классе есть метод `toString`, который выводит ответ строкой в формате `numerator / denominator`. В `Main` создается 3 дроби, с ними производятся арифметические операции согласно поставленному заданию.

**<ins>Код реализации:</ins>**
```
public class Fraction {
    private int numerator; // числитель
    private int denominator; // знаменатель

    // Геттеры
    public int getNumerator() {
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }

    // Сеттеры
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // Конструктор с числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Метод для получения строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод сложения двух дробей
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод вычитания двух дробей
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод умножения дробей
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод деления дробей
    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        if (newDenominator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод сложения дроби и целого числа
    public Fraction add(int number) {
        int newNumerator = this.numerator + number * this.denominator;
        return new Fraction(newNumerator, this.denominator);
    }

    // Метод вычитания дроби и целого числа
    public Fraction subtract(int number) {
        int newNumerator = this.numerator - number * this.denominator;
        return new Fraction(newNumerator, this.denominator);
    }

    // Метод умножения дроби и целого числа
    public Fraction multiply(int number) {
        int newNumerator = this.numerator * number;
        return new Fraction(newNumerator, this.denominator);
    }

    // Метод деления дроби на целое число
    public Fraction divide(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return new Fraction(this.numerator, this.denominator * number);
    }
}
```

**<ins>Вывод на экран:</ins>**

1/3 + 2/3 = 9/9

1/3 - 2/3 = -3/9

1/3 * 2/3 = 2/9

1/3 / 2/3 = 3/6

1/3 + 5 = 16/3

1/3 - 5 = -14/3

1/3 * 5 = 5/3

1/3 / 5 = 1/15

(1/3 + 2/3) / 3/4 - 5 = -99/27
