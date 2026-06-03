package ru.masyutin.geometry;

/**
 * Класс Point представляет точку в двумерном пространстве
 * Реализует интерфейс Cloneable для поддержки клонирования
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case, п.21 лишние комментарии
// public class Point implements Cloneable {
//   protected int x;
//   protected int y;
//
//   //Получение координаты x
//   public int getX() {
//     return x;
//   }
//
//   //Получение координаты y
//   public int getY() {
//     return y;
//   }
//
//   //Установка координаты x
//   public void setX(int x) {
//     this.x = x;
//   }
//
//   //Установка координаты y
//   public void setY(int y) {
//     this.y = y;
//   }
//
//   //Конструктор с координатами
//   public Point(int x, int y) {
//     this.x = x;
//     this.y = y;
//   }
//
//   //Вычисление расстояния от одной точки до другой
//   public double distanceTo(Point other) {
//     int dx = this.x - other.x;
//     int dy = this.y - other.y;
//     return Math.sqrt(dx * dx + dy * dy);
//   }
//
//   //Вычисление расстояния от начала координат
//   public double distanceToOrigin() {
//     return Math.sqrt(x * x + y * y);
//   }
//
//   //троковое представление точки
//   @Override
//   public String toString() {
//     return "{" + x + ";" + y + "}";
//   }
//
//   //Сравнение точек с координатами
//   @Override
//   public boolean equals(Object obj) {
//     if (this == obj) return true;
//     if (obj == null || getClass() != obj.getClass())
//       return false;
//     Point other = (Point) obj;
//     return this.x == other.x && this.y == other.y;
//   }
//   @Override
//   //Создание копии точки
//   public Point clone() {
//     try {
//       return (Point) super.clone();
//     } catch (CloneNotSupportedException e) {
//       return null;
//     }
//   }
// }
//FIXTO:
public class Point implements Cloneable {
    protected int x;
    protected int y;

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public void SetX(int x) {
        this.x = x;
    }

    public void SetY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double DistanceTo(Point other) {
        int delta_X = this.x - other.x;
        int delta_Y = this.y - other.y;
        return Math.sqrt(delta_X * delta_X + delta_Y * delta_Y);
    }

    public double DistanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public Point Clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
