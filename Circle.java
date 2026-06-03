package ru.masyutin.geometry;

/**
 * Класс Circle представляет геометрическую фигуру круг
 * Наследуется от абстрактного класса Shape
 */
//FIXME: п.7 методы в PascalCase, п.13 нет валидации, п.14 возвращает прямую ссылку, п.21 лишние комментарии
// public class Circle extends Shape{
//   private Point center;
//   private int radius;
//
//   /**
//    * Получение центра круга
//    */
//   public Point getCenter(){
//     return center;
//   }
//   //Получение радиуса круга
//   public int getRadius(){
//     return radius;
//   }
//   //Установка центра круга
//   public void setCenter(){
//     this.center = center;
//   }
//   //Установка радиуса круга
//   public void setRadius(){
//     this.radius = radius;
//   }
//   //Конструктор по умолчанию
//   public Circle() {
//     super("Круг");
//
//   }
// //Конструктор с центром и радиусом
//   public Circle(Point center, int radius) {
//     super("Круг");
//     this.center = center;
//     setRadius(radius);
//   }
// //Конструктор с координатами центра и радиусом
//   public Circle(int centerX, int centerY, int radius) {
//     super("Круг");
//     this.center = new Point(centerX, centerY);
//     setRadius(radius);
//   }
//   //Установка радиуса с валидацией
//   public void setRadius(int radius) {
//     if (radius <= 0) {
//       throw new IllegalArgumentException("Радиус должен быть положительным числом");
//     }
//     this.radius = radius;
//   }
//   //Вычисление площади круга
//   public double getArea(){
//     return Math.PI * radius * radius;
//   }
//   @Override
//   //Строковое представление круга
//   public String toString(){
//     return "Круг [Центр: " + center + ", Радиус: " + radius + "]";
//   }
// }
//FIXTO:
public class Circle extends Shape {
    private Point center;
    private int radius;

    /**
     * Возвращает центр круга
     * @return копия точки центра (защита внутреннего состояния)
     */
    public Point GetCenter() {
        return new Point(center.GetX(), center.GetY());
    }

    /**
     * Возвращает радиус круга
     * @return радиус круга
     */
    public int GetRadius() {
        return radius;
    }

    /**
     * Устанавливает центр круга
     * @param center новая точка центра
     * @throws IllegalArgumentException если центр равен null
     */
    public void SetCenter(Point center) {
        if (center == null) {
            throw new IllegalArgumentException("Центр не может быть null");
        }
        this.center = new Point(center.GetX(), center.GetY());
    }

    /**
     * Конструктор по умолчанию
     * Создаёт круг с центром в точке {0;0} и радиусом 1
     */
    public Circle() {
        super("Круг");
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    /**
     * Конструктор с центром и радиусом
     * @param center точка центра круга
     * @param radius радиус круга
     * @throws IllegalArgumentException если центр null или радиус <= 0
     */
    public Circle(Point center, int radius) {
        super("Круг");
        SetCenter(center);
        SetRadius(radius);
    }

    /**
     * Конструктор с координатами центра и радиусом
     * @param centerX координата X центра
     * @param centerY координата Y центра
     * @param radius радиус круга
     * @throws IllegalArgumentException если радиус <= 0
     */
    public Circle(int centerX, int centerY, int radius) {
        super("Круг");
        this.center = new Point(centerX, centerY);
        SetRadius(radius);
    }

    /**
     * Устанавливает радиус круга с валидацией
     * @param radius новый радиус
     * @throws IllegalArgumentException если радиус <= 0
     */
    public void SetRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    /**
     * Вычисляет площадь круга
     * @return площадь круга (π * R²)
     */
    public double GetArea() {
        return Math.PI * radius * radius;
    }

    @Override
    /**
     * Возвращает строковое представление круга
     * @return строка вида "Круг [Центр: {X;Y}, Радиус: R]"
     */
    public String toString() {
        return "Круг [Центр: " + center + ", Радиус: " + radius + "]";
    }
}
