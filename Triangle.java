package ru.masyutin.geometry;

/**
 * Класс Triangle представляет геометрическую фигуру треугольник
 * Наследуется от абстрактного класса Shape
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case, п.13 валидация, п.14 возврат копии, п.21 лишние комментарии
// public class Triangle extends Shape {
//   private Point pointA;
//   private Point pointB;
//   private Point pointC;
//
//   //Получение вершины A
//   public Point getPointA() {
//     return pointA;
//   }
//
//   //Получение вершины B
//   public Point getPointB() {
//     return pointB;
//   }
//
//   //Получение вершины C
//   public Point getPointC() {
//     return pointC;
//   }
//
//
//   //Установка вершины A
//   public void setPointA(Point pointA) {
//     this.pointA = pointA;
//   }
//
//   // Установка вершины B
//   public void setPointB(Point pointB) {
//     this.pointB = pointB;
//   }
//
//   //Установка вершины C
//   public void setPointC(Point pointC) {
//     this.pointC = pointC;
//   }
//
//   //Конструктор по умолчанию
//   public Triangle() {
//     super("Треугольник");
//   }
//
//   //Конструктор с тремя точками
//   public Triangle(Point pointA, Point pointB, Point pointC) {
//     super("Треугольник");
//     this.pointA = pointA;
//     this.pointB = pointB;
//     this.pointC = pointC;
//   }
//
//   //Конструктор с координатами вершин
//   public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
//     super("Треугольник");
//     this.pointA = new Point(x1, y1);
//     this.pointB = new Point(x2, y2);
//     this.pointC = new Point(x3, y3);
//   }
//
//   //Вычисление длины стороны между двумя точками
//   private double getSideLength(Point p1, Point p2) {
//     return p1.distanceTo(p2);
//   }
//   //Вычисление площади треугольника по формуле Герона
//   @Override
//   public double getArea() {
//     double a = getSideLength(pointA, pointB);
//     double b = getSideLength(pointB, pointC);
//     double c = getSideLength(pointC, pointA);
//
//     double p = (a + b + c) / 2;
//     return Math.sqrt(p * (p - a) * (p - b) * (p - c));
//   }
//
//   //Строковое представление треугольника
//   @Override
//   public String toString() {
//     return "Треугольник [A: " + pointA + ", B: " + pointB + ", C: " + pointC + "]";
//   }
// }
//FIXTO:
public class Triangle extends Shape {
    private Point point_A;
    private Point point_B;
    private Point point_C;

    public Point GetPointA() {
        return new Point(point_A.GetX(), point_A.GetY());
    }

    public Point GetPointB() {
        return new Point(point_B.GetX(), point_B.GetY());
    }

    public Point GetPointC() {
        return new Point(point_C.GetX(), point_C.GetY());
    }

    public void SetPointA(Point point_A) {
        if (point_A == null) {
            throw new IllegalArgumentException("Точка A не может быть null");
        }
        this.point_A = new Point(point_A.GetX(), point_A.GetY());
    }

    public void SetPointB(Point point_B) {
        if (point_B == null) {
            throw new IllegalArgumentException("Точка B не может быть null");
        }
        this.point_B = new Point(point_B.GetX(), point_B.GetY());
    }

    public void SetPointC(Point point_C) {
        if (point_C == null) {
            throw new IllegalArgumentException("Точка C не может быть null");
        }
        this.point_C = new Point(point_C.GetX(), point_C.GetY());
    }

    public Triangle() {
        super("Треугольник");
        this.point_A = new Point(0, 0);
        this.point_B = new Point(1, 0);
        this.point_C = new Point(0, 1);
    }

    public Triangle(Point point_A, Point point_B, Point point_C) {
        super("Треугольник");
        SetPointA(point_A);
        SetPointB(point_B);
        SetPointC(point_C);
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super("Треугольник");
        this.point_A = new Point(x1, y1);
        this.point_B = new Point(x2, y2);
        this.point_C = new Point(x3, y3);
    }

    private double GetSideLength(Point p1, Point p2) {
        return p1.DistanceTo(p2);
    }

    @Override
    public double GetArea() {
        double a = GetSideLength(point_A, point_B);
        double b = GetSideLength(point_B, point_C);
        double c = GetSideLength(point_C, point_A);

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Треугольник [A: " + point_A + ", B: " + point_B + ", C: " + point_C + "]";
    }
}
