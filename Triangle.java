package ru.masyutin.geometry;
/**
 * Класс Triangle представляет геометрическую фигуру треугольник
 * Наследуется от абстрактного класса Shape
 */
public class Triangle extends Shape {
  private Point pointA;
  private Point pointB;
  private Point pointC;

  //Получение вершины A
  public Point getPointA() {
    return pointA;
  }

  //Получение вершины B
  public Point getPointB() {
    return pointB;
  }

  //Получение вершины C
  public Point getPointC() {
    return pointC;
  }


  //Установка вершины A
  public void setPointA(Point pointA) {
    this.pointA = pointA;
  }

  // Установка вершины B
  public void setPointB(Point pointB) {
    this.pointB = pointB;
  }

  //Установка вершины C
  public void setPointC(Point pointC) {
    this.pointC = pointC;
  }

  //Конструктор по умолчанию
  public Triangle() {
    super("Треугольник");
  }

  //Конструктор с тремя точками
  public Triangle(Point pointA, Point pointB, Point pointC) {
    super("Треугольник");
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
  }

  //Конструктор с координатами вершин
  public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    super("Треугольник");
    this.pointA = new Point(x1, y1);
    this.pointB = new Point(x2, y2);
    this.pointC = new Point(x3, y3);
  }

  //Вычисление длины стороны между двумя точками
  private double getSideLength(Point p1, Point p2) {
    return p1.distanceTo(p2);
  }
  //Вычисление площади треугольника по формуле Герона
  @Override
  public double getArea() {
    double a = getSideLength(pointA, pointB);
    double b = getSideLength(pointB, pointC);
    double c = getSideLength(pointC, pointA);

    double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }

  //Строковое представление треугольника
  @Override
  public String toString() {
    return "Треугольник [A: " + pointA + ", B: " + pointB + ", C: " + pointC + "]";
  }
}