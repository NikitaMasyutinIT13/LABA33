package ru.masyutin.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Square представляет геометрическую фигуру квадрат
 * Наследуется от класса Shape
 */
public class Square extends Shape {

  private Point topLeft;

  private int side;

  //Получение верхней левой точки
  public Point getTopLeft() {
    return topLeft;
  }

  //Получение длины стороны
  public int getSide() {
    return side;
  }

  //УСтановка левой верхней точки
  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }

  //УСтановка длины стороны с валидацией
  public void setSide(int side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Сторона должна быть положительным числом");
    }
    this.side = side;
  }
  //Конструктор по умолчанию
  public Square() {
    super("Квадрат");

  }

  //Конструктор с точной и стороной
  public Square(Point topLeft, int side) {
    super("Квадрат");
    this.topLeft = topLeft;
    setSide(side);
  }

  //Конструктор с координатами и стороной
  public Square(int x, int y, int side) {
    super("Квадрат");
    this.topLeft = new Point(x, y);
    setSide(side);
  }

  //Вычисление площади квадрата
  @Override
  public double getArea() {
    return side * side;
  }

  //Получение замкнутой ломаной линии квадрата
  public List<Point> getPolyline() {
    List<Point> polyline = new ArrayList<>();

    int x1 = topLeft.getX();
    int y1 = topLeft.getY();
    int x2 = x1 + side;
    int y2 = y1;
    int x3 = x2;
    int y3 = y1 + side;
    int x4 = x1;
    int y4 = y3;

    polyline.add(new Point(x1, y1));
    polyline.add(new Point(x2, y2));
    polyline.add(new Point(x3, y3));
    polyline.add(new Point(x4, y4));
    polyline.add(new Point(x1, y1));

    return polyline;
  }

  //Вычисление периметра квадрата
  public double getPerimeter() {
    return 4 * side;
  }

  //Строковое представление квадрата
  @Override
  public String toString() {
    return "Квадрат [Левый верх: " + topLeft + ", Сторона: " + side + "]";
  }
}
