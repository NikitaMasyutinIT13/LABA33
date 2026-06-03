package ru.masyutin.geometry;

/**
 * Абстрактный класс Shape представляет геометрическую фигуру
 * Содержит общие свойства и методы для всех фигур
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case, п.21 лишние комментарии
// public abstract class Shape {
//   private String name;
//
//   //Конструктор по умолчанию
//   public Shape() {
//     this.name = "Фигура";
//   }
//
//   //Конструктор с именем
//   public Shape(String name) {
//     this.name = name;
//   }
//
//   //Получение имени фигуры
//   public String getName() {
//     return name;
//   }
//
//   //Установка имени фигуры
//   public void setName(String name) {
//     this.name = name;
//   }
//
//
//   //бстрактный метод вычисления площади
//   public abstract double getArea();
//
//
//   //Получение информации о фигуре
//   public String getInfo() {
//     return name + " [Площадь: " + Math.round(getArea() * 100) / 100.0 + "]";
//   }
//
//
//   //Абстрактный метод сторокового представления
//   @Override
//   public abstract String toString();
// }
//FIXTO:
public abstract class Shape {
    private String name;

    public Shape() {
        this.name = "Фигура";
    }

    public Shape(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public abstract double GetArea();

    public String GetInfo() {
        return name + " [Площадь: " + Math.round(GetArea() * 100) / 100.0 + "]";
    }

    @Override
    public abstract String toString();
}
