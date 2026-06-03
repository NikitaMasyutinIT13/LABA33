package ru.masyutin.geometry;

/**
 * Класс Rectangle представляет геометрическую фигуру прямоугольник
 * Наследуется от абстрактного класса Shape
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case, п.13 валидация, п.14 возврат копии, п.21 лишние комментарии
// public class Rectangle extends Shape {
//   private Point topLeft;
//   private int width;
//   private int height;
//
//   //получение верхней левой точки
//   public Point getTopLeft() {
//     return topLeft;
//   }
//
//   //получение ширины прямоугольника
//   public int getWidth() {
//     return width;
//   }
//
//   //получение высоты прямоугольника
//   public int getHeight() {
//     return height;
//   }
//
//   //установка верхней левой точки
//   public void setTopLeft(Point topLeft) {
//     this.topLeft = topLeft;
//   }
//
//   //установка ширины с валидацией
//   public void setWidth(int width) {
//     if (width <= 0) {
//       throw new IllegalArgumentException("Ширина должна быть положительным числом");
//     }
//     this.width = width;
//   }
//   //установка высоты с валидацией
//   public void setHeight(int height) {
//     if (height <= 0) {
//       throw new IllegalArgumentException("Высота должна быть положительным числом");
//     }
//     this.height = height;
//   }
//   //конструктор по умолчанию
//   public Rectangle() {
//     super("Прямоугольник");
//
//   }
//   //Конструктор с точком и размерами
//   public Rectangle(Point topLeft, int width, int height) {
//     super("Прямоугольник");
//     this.topLeft = topLeft;
//     setWidth(width);
//     setHeight(height);
//   }
//   //конструктор с координатами и размером
//   public Rectangle(int x, int y, int width, int height) {
//     super("Прямоугольник");
//     this.topLeft = new Point(x, y);
//     setWidth(width);
//     setHeight(height);
//   }
//   //Вычисление площади прямоугольника
//   @Override
//   public double getArea() {
//     return width * height;
//   }
//
//   //Строковое представление прямоугольника
//   @Override
//   public String toString() {
//     return "Прямоугольник [Левый верх: " + topLeft + ", Ширина: " + width + ", Высота: " + height + "]";
//   }
// }
//FIXTO:
public class Rectangle extends Shape {
    private Point top_Left;
    private int width;
    private int height;

    public Point GetTopLeft() {
        return new Point(top_Left.GetX(), top_Left.GetY());
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

    public void SetTopLeft(Point top_Left) {
        if (top_Left == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
        this.top_Left = new Point(top_Left.GetX(), top_Left.GetY());
    }

    public void SetWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина должна быть положительным числом");
        }
        this.width = width;
    }

    public void SetHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Высота должна быть положительным числом");
        }
        this.height = height;
    }

    public Rectangle() {
        super("Прямоугольник");
        this.top_Left = new Point(0, 0);
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(Point top_Left, int width, int height) {
        super("Прямоугольник");
        SetTopLeft(top_Left);
        SetWidth(width);
        SetHeight(height);
    }

    public Rectangle(int x, int y, int width, int height) {
        super("Прямоугольник");
        this.top_Left = new Point(x, y);
        SetWidth(width);
        SetHeight(height);
    }

    @Override
    public double GetArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник [Левый верх: " + top_Left + ", Ширина: " + width + ", Высота: " + height + "]";
    }
}
