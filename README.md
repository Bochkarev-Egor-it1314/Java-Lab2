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
- `Human.java` - создание сущности Человек, которая описывается: Имя: строка, Рост: целое число 
- `Name.java` - создание сущности Имя, которая описывается тремя параметрами: Фамилия, Личное имя, 
Отчество
- `Person.java` - объединение сущности Человек из задачи 1.2 и Имя из задачи 1.3 


## Детальный анализ методов

**Задание 1.2**

<ins>Задача:</ins>

Создайте сущность Человек, которая описывается: 
+ Имя: строка 
+ Рост: целое число 
Может возвращать текстовое представление вида “Name, рост: height”, где Name и height это 
переменная с именем и ростом. 
Необходимо создать и вывести на экран следующих людей: 
+ Человек с именем “Клеопатра” и ростом 152 
+ Человек с именем “Пушкин ” и ростом 167 
+ Человек с именем “Владимир ” и ростом 189

<ins>Метод решения:</ins>

Для решения задачи используется класс Human. В классе есть 2 поля: name и height. Также есть 2 конструктора, геттеры и сеттеры для каждого из полей. В классе main создается 3 человека и именами Клеопатра, Пушкин и Владимир и ростом 152, 167 и 189 соответственно. Кажде имя с ростом выводится на экран

<ins>Код реализации:</ins>
```
public class Human
{
    private String name;
    private int height;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.name + ", рост: " + this.height;
    }

    //С параметрами
    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
```

<ins>Вывод на экран:</ins>

Клеопатра, рост: 152

Пушкин, рост: 167

Владимир, рост: 189
***

**Задание 1.3**

<ins>Задача:</ins>

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


<ins>Метод решения:</ins>

Для решения задачи создается новый класс Name. Внутри него есть 3 поля: name, surname и patronymic. После реализованы конструкторы для создания имени разными способами: без patronymic или только с name.Также есть геттеры и сеттеры для каждого поля. В конце метод toString, который выводит результат строкой. Причем при выводе учитывается, что не заданные параметры никак не участвуют в образовании строки.

<ins>Код реализации:</ins>
```
public class Name
{
    private String surname;
    private String name;
    private String patronymic;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        StringBuilder empty = new StringBuilder();

        if (surname != null) empty.append(surname).append(" ");
        if (name != null) empty.append(name).append(" ");
        if (patronymic != null) empty.append(patronymic).append(" ");

        return empty.toString().trim();
    }

    public Name(String surname, String name, String patronymic) {
        this.surname = (surname != null && !surname.isBlank()) ? surname : null;
        this.name = (name != null && !name.isBlank()) ? name : null;
        this.patronymic = (patronymic != null && !patronymic.isBlank()) ? patronymic : null;
    }
}
```

<ins>Вывод на экран:</ins>

Клеопатра

Пушкин Александр Сергеевич

Маяковский Владимир
***

**Задание 2.2**

<ins>Задача:</ins>

Объедините сущности Человек из задачи 1.2 и Имя из задачи 1.3 таким образом, чтобы имя 
человека задавалось с использованием сущности 1.3, а не строки.  
Необходимо объединить ранее созданные объекты имен и людей, с получением: 
+ Человека с Именем Клеопатра и ростом 152 
+ Человека с Именем Пушкин Александр Сергеевичи ростом 167 
+ Человека с Именем Маяковский Владимир и ростом 189

<ins>Метод решения:</ins>

Для решения задачи создается новый класс HumanWithName. В нем есть 2 поля: имя и рост. Также есть конструктор и геттер для каждого поля. В конце есть метод toString, который выводит результат строкой. В main создается 3 имени (как во 2 задании) и им присваивается рост (как в 1 задании). В результате получается 3 имени с ростом: Клеопатра с ростом 152, Пушкин Александр Сергеевич в ростом 167 и Владимир Маяковский с ростом 189.

<ins>Код реализации:</ins>
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

<ins>Вывод на экран:</ins>

Клеопатра, рост: 152

Пушкин Александр Сергеевич, рост: 167

Маяковский Владимир, рост: 189
***

**Задание 3.3**

<ins>Задача:</ins>

Создайте сущность Город, которая будет представлять собой точку на карте со следующими 
характеристиками: 
 Название города 
 Набор путей к следующим городам, где путь представляет собой сочетание Города и 
стоимости поездки в него. 
Кроме того, Город может возвращать текстовое представление, в виде названия города и списка 
связанных с ним городов (в виде пары: “название:стоимость”). 
Используя разработанную сущность реализуйте схему, представленную на рисунке 2.

<ins>Метод решения:</ins>

Для решения создается новый класс City. В нем есть 2 поля: name и ways. Также есть конструктор и метод для добавления пути из города в город. И как во всех классах есть метод toString для вывода ответа строкой. В main создается 6 городов и между ними прокладываются дороги как на рисунке. Итоговый список городов с их дорогами до других городов выводится на экран.

<ins>Код реализации:</ins>
```
import java.util.ArrayList;
import java.util.List;

public class City {
    private String name; // название города
    private List<Path> paths; // список исходящих путей

    public City(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPath(City toCity, int cost) {
        paths.add(new Path(toCity, cost));
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " -> ");
        for (Path p : paths) {
            sb.append(p.getCity().getName()).append(":").append(p.getCost()).append("  ");
        }
        return sb.toString().trim();
    }
}
```

<ins>Вывод на экран:</ins>

A -> D:6  F:1  B:5

B -> A:5  C:3

C -> D:4  B:4

D -> C:4  E:2  A:6

E -> F:2

F -> B:1  E:2
***

**Задание 4.8**

<ins>Задача:</ins>

Измените сущность Город из задачи 3.3. Новые требования включают: 
+ Город можно создать указав только название 
+ Город можно создать указав название и набор связанных с ним городов и стоимостей 
путей к ним 


<ins>Метод решения:</ins>

Для решения создается новый класс Fraction. У него есть 2 поля: numerator и denominator. Также есть конструктор, в котором проверяется поле denominator на равеноство 0. Если оно выполняется, то система заканчивает работу. Также есть констурктор при denominator = 1. Для каждого поля также есть геттер и сеттер. В классе также содержится 4 метода арифметических операций: сложения, вычитания, умножения и деления. В делении также есть проверка на деление на 0. Эти операции реализованы как обычные действия с дробями (В сложении и вычитании 2 дроби приводятся к общему знаменателю, а при делении числитель и знаменатель второй дроби меняются местами и производится умножение). В конце есть метод toString, который выводит ответ строкой в формате numerator / denominator.

В main создается 8 дробей. Между ними производятся арифметические операции и выводится результат каждой. В самом конце считается пример из задания под цифрой 4
<ins>Код реализации:</ins>
```
import java.util.ArrayList;
import java.util.List;

public class NewCity {
    private String name; // название города
    private List<Path> paths; // список исходящих путей

    // Конструктор только с названием города
    public NewCity(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    // Конструктор с названием и набором путей
    public NewCity(String name, List<Path> paths) {
        this.name = name;
        this.paths = paths != null ? paths : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPath(City toCity, int cost) {
        paths.add(new Path(toCity, cost));
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " -> ");
        for (Path p : paths) {
            sb.append(p.getCity().getName()).append(":").append(p.getCost()).append("  ");
        }
        return sb.toString().trim();
    }
}

public class Path {
    private City city;
    private int cost;

    public Path(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public City getCity() {
        return city;
    }

    public int getCost() {
        return cost;
    }
}
```

<ins>Вывод на экран:</ins>

1/3 + 2/3 = 9/9

1/3 - 2/3 = -3/9

1/3 * 2/3 = 2/9

1/3 / 2/3 = 3/6

1/3 + 5 = 16/3

1/3 - 5 = -14/3

1/3 * 5 = 5/3

1/3 / 5 = 1/15

(1/3 + 2/3) / 3/4 - 5 = -99/27
***

**Задание 5.5**

<ins>Задача:</ins>

Создайте сущность Дробь со следующими особенностями: 
+ Имеет числитель: целое число 
+ Имеет знаменатель: целое число 
+ Дробь может быть создана с указанием числителя и знаменателя  
+ Может вернуть строковое представление вида “числитель/знаменатель” 
+ Может выполнять операции сложения, вычитания, умножения и деления с другой Дробью 
или целым числом. Результатом операции должна быть новая Дробь (таким образом,обе 
исходные дроби не изменяются) 
Затем необходимо выполнить следующие задачи: 
1. Создать несколько экземпляров дробей. 
2. Написать по одному примеру использования каждого метода. 
3. Вывести на экран примеры и результаты их выполнения в формате «1/3 * 2/3 = 2/9» 
4. Посчитать f1.sum(f2).div(f3).minus(5) 


<ins>Метод решения:</ins>

Для решения создается новый класс Fraction. У него есть 2 поля: numerator и denominator. Также есть конструктор, в котором проверяется поле denominator на равеноство 0. Если оно выполняется, то система заканчивает работу. Также есть констурктор при denominator = 1. Для каждого поля также есть геттер и сеттер. В классе также содержится 4 метода арифметических операций: сложения, вычитания, умножения и деления. В делении также есть проверка на деление на 0. Эти операции реализованы как обычные действия с дробями (В сложении и вычитании 2 дроби приводятся к общему знаменателю, а при делении числитель и знаменатель второй дроби меняются местами и производится умножение). В конце есть метод toString, который выводит ответ строкой в формате numerator / denominator.

В main создается 8 дробей. Между ними производятся арифметические операции и выводится результат каждой. В самом конце считается пример из задания под цифрой 4
<ins>Код реализации:</ins>
```
public class Fraction {
    private int numerator; // числитель
    private int denominator; // знаменатель

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // Конструктор с числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
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

<ins>Вывод на экран:</ins>

1/3 + 2/3 = 9/9

1/3 - 2/3 = -3/9

1/3 * 2/3 = 2/9

1/3 / 2/3 = 3/6

1/3 + 5 = 16/3

1/3 - 5 = -14/3

1/3 * 5 = 5/3

1/3 / 5 = 1/15

(1/3 + 2/3) / 3/4 - 5 = -99/27
