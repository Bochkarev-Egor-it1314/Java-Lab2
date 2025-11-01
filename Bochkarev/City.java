package ru.Bochkarev;

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

