package ru.masyutin.geometry;
/**
 * Класс Rectangle представляет геометрическую фигуру прямоугольник
 * Наследуется от абстрактного класса Shape
 */
public class Rectangle extends Shape {
  private Point topLeft;
  private int width;
  private int height;

  //получение верхней левой точки
  public Point getTopLeft() {
    return topLeft;
  }

  //получение ширины прямоугольника
  public int getWidth() {
    return width;
  }

  //получение высоты прямоугольника
  public int getHeight() {
    return height;
  }

  //установка верхней левой точки
  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }

  //установка ширины с валидацией
  public void setWidth(int width) {
    if (width <= 0) {
      throw new IllegalArgumentException("Ширина должна быть положительным числом");
    }
    this.width = width;
  }
  //установка высоты с валидацией
  public void setHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException("Высота должна быть положительным числом");
    }
    this.height = height;
  }
  //конструктор по умолчанию
  public Rectangle() {
    super("Прямоугольник");

  }
  //Конструктор с точком и размерами
  public Rectangle(Point topLeft, int width, int height) {
    super("Прямоугольник");
    this.topLeft = topLeft;
    setWidth(width);
    setHeight(height);
  }
  //конструктор с координатами и размером
  public Rectangle(int x, int y, int width, int height) {
    super("Прямоугольник");
    this.topLeft = new Point(x, y);
    setWidth(width);
    setHeight(height);
  }
  //Вычисление площади прямоугольника
  @Override
  public double getArea() {
    return width * height;
  }

  //Строковое представление прямоугольника
  @Override
  public String toString() {
    return "Прямоугольник [Левый верх: " + topLeft + ", Ширина: " + width + ", Высота: " + height + "]";
  }
}