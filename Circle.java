package ru.masyutin.geometry;

/**
 * Класс Circle представляет геометрическую фигуру круг
 * Наследуется от абстрактного класса Shape
 */
public class Circle extends Shape{
  private Point center;
  private int radius;

  /**
   * Получение центра круга
   */
  public Point getCenter(){
    return center;
  }
  //Получение радиуса круга
  public int getRadius(){
    return radius;
  }
  //Установка центра круга
  public void setCenter(){
    this.center = center;
  }
  //Установка радиуса круга
  public void setRadius(){
    this.radius = radius;
  }
  //Конструктор по умолчанию
  public Circle() {
    super("Круг");

  }
//Конструктор с центром и радиусом
  public Circle(Point center, int radius) {
    super("Круг");
    this.center = center;
    setRadius(radius);
  }
//Конструктор с координатами центра и радиусом
  public Circle(int centerX, int centerY, int radius) {
    super("Круг");
    this.center = new Point(centerX, centerY);
    setRadius(radius);
  }
  //Установка радиуса с валидацией
  public void setRadius(int radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("Радиус должен быть положительным числом");
    }
    this.radius = radius;
  }
  //Вычисление площади круга

  public double getArea(){
    return Math.PI * radius * radius;
  }
  @Override
  //Строковое представление круга

  public String toString(){
    return "Круг [Центр: " + center + ", Радиус: " + radius + "]";
  }
}
