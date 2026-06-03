package ru.masyutin.geometry;

/**
 * Класс Circle представляет геометрическую фигуру круг
 * Наследуется от абстрактного класса Shape
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case, п.13 валидация, п.14 возврат копии
// public class Circle extends Shape {
//     private Point center;
//     private int radius;
//
//     public Point getCenter() {
//         return center;
//     }
//
//     public int getRadius() {
//         return radius;
//     }
//
//     public void setCenter(Point center) {
//         this.center = center;
//     }
//
//     public Circle() {
//         super("Круг");
//     }
//
//     public Circle(Point center, int radius) {
//         super("Круг");
//         this.center = center;
//         setRadius(radius);
//     }
//
//     public Circle(int centerX, int centerY, int radius) {
//         super("Круг");
//         this.center = new Point(centerX, centerY);
//         setRadius(radius);
//     }
//
//     public void setRadius(int radius) {
//         if (radius <= 0) {
//             throw new IllegalArgumentException("Радиус должен быть положительным числом");
//         }
//         this.radius = radius;
//     }
//
//     public double getArea() {
//         return Math.PI * radius * radius;
//     }
//
//     @Override
//     public String toString() {
//         return "Круг [Центр: " + center + ", Радиус: " + radius + "]";
//     }
// }
//FIXTO:
public class Circle extends Shape {
    private Point center;
    private int radius;

    public Point GetCenter() {
        return new Point(center.GetX(), center.GetY());
    }

    public int GetRadius() {
        return radius;
    }

    public void SetCenter(Point center) {
        if (center == null) {
            throw new IllegalArgumentException("Центр не может быть null");
        }
        this.center = new Point(center.GetX(), center.GetY());
    }

    public Circle() {
        super("Круг");
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Circle(Point center, int radius) {
        super("Круг");
        SetCenter(center);
        SetRadius(radius);
    }

    public Circle(int center_X, int center_Y, int radius) {
        super("Круг");
        this.center = new Point(center_X, center_Y);
        SetRadius(radius);
    }

    public void SetRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    public double GetArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг [Центр: " + center + ", Радиус: " + radius + "]";
    }
}
