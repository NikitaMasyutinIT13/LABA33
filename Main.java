package ru.masyutin.main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import ru.masyutin.utils.InputValidator;
import ru.masyutin.education.Student;
import ru.masyutin.contacts.PhoneBook;
import ru.masyutin.geometry.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Главный класс приложения
 * Содержит точку входа и методы для работы со всеми системами
 */
public class Main {
  public static void main(String[] args) {
    if (args.length >= 2) {
      executePowerCalculation(args);
      return;
    }

    runInteractiveMenu();
  }

  /**
   * Выполнение возведения в степень из аргументов командной строки
   */
  private static void executePowerCalculation(String[] args) {
    System.out.println("=== ВОЗВЕДЕНИЕ В СТЕПЕНЬ ИЗ АРГУМЕНТОВ КОМАНДНОЙ СТРОКИ ===");

    try {
      String xStr = args[0];
      String yStr = args[1];

      double result = powerFromStrings(xStr, yStr);
      System.out.printf("Результат: %s ^ %s = %.2f\n", xStr, yStr, result);

    } catch (NumberFormatException e) {
      System.out.println("Ошибка: аргументы должны быть целыми числами");
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Ошибка вычисления: " + e.getMessage());
    }
  }


  private static void runInteractiveMenu() {
    Scanner scanner = new Scanner(System.in);
    InputValidator validator = new InputValidator(scanner);
    System.out.println("=== ПРОГРАММА РЕШЕНИЯ ЗАДАЧ ===");

    boolean running = true;
    while (running) {
      showMainMenu();
      int choice = validator.getMenuChoice("Выберите задачу: ", 7);

      switch (choice) {
        case 1:
          runStudentTask(validator);
          break;
        case 2:
          runPhoneBookTask(validator);
          break;
        case 3:
          runPointTask(validator);
          break;
        case 4:
          runShapesTask(validator);
          break;
        case 5:
          demonstratePointEquals(validator);
          break;
        case 6:
          demonstratePointCloning(validator);
          break;
        case 7:
          running = false;
          break;
      }
    }

    System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    scanner.close();
  }

  private static void showMainMenu() {
    System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
    System.out.println("1. Задача: Студент с оценками");
    System.out.println("2. Задача: Телефонный справочник");
    System.out.println("3. Задача: Трехмерная точка");
    System.out.println("4. Гоеметрические фигуры");
    System.out.println("5. Сравнение точек");
    System.out.println("6. Копирование точек");
    System.out.println("7. Выход");

  }
  //Запуск задачи работы со студентами
  private static void runStudentTask(InputValidator validator) {
    System.out.println("\n=== ЗАДАЧА: СТУДЕНТ С ОЦЕНКАМИ ===");

    String name = validator.getValidStudentName("Введите имя студента: ");
    String group = validator.getValidGroup("Введите группу студента: ");
    Student student = new Student(name, group);

    System.out.println(" Создан: " + student.getStudentInfo());

    boolean working = true;
    while (working) {
      System.out.println("\n--- Действия со студентом ---");
      System.out.println("1. Добавить оценку");
      System.out.println("2. Показать информацию");
      System.out.println("3. Показать статистику");
      System.out.println("4. Вернуться в главное меню");

      int choice = validator.getMenuChoice("Выберите действие: ", 4);

      switch (choice) {
        case 1:
          int grade = validator.getValidGrade("Введите оценку (2-5): ");
          if (student.tryAddGrade(grade)) {
            System.out.println(" Оценка " + grade + " добавлена");
          } else {
            System.out.println(" Ошибка: оценка должна быть от 2 до 5");
          }
          System.out.println("Текущее состояние: " + student);
          break;
        case 2:
          System.out.println(student);
          break;
        case 3:
          if (student.hasGrades()) {
            System.out.println("Количество оценок: " + student.getGradesCount());
            System.out.println("Средний балл: " + String.format("%.2f", student.getAverageGrade()));
            System.out.println("Отличник: " + (student.isExcellentStudent() ? "ДА" : "нет"));
            System.out.println("Есть неудовлетворительные: " +
                    (student.hasUnsatisfactoryGrades() ? "ДА" : "нет"));

            System.out.println("\nДетальная статистика:");
            for (int i = 2; i <= 5; i++) {
              int count = student.countGrade(i);
              if (count > 0) {
                System.out.println("Оценка " + i + ": " + count + " раз");
              }
            }
          } else {
            System.out.println("Нет оценок для статистики");
          }
          break;
        case 4:
          working = false;
          break;
      }
    }
  }
  //Запуск задачи работы с телефонным справочником
  private static void runPhoneBookTask(InputValidator validator) {
    System.out.println("\n=== ЗАДАЧА: ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");

    PhoneBook phoneBook = new PhoneBook();
    System.out.println("Создан пустой телефонный справочник");

    boolean working = true;
    while (working) {
      System.out.println("\n--- Действия со справочником ---");
      System.out.println("1. Добавить контакт");
      System.out.println("2. Найти телефон по имени");
      System.out.println("3. Удалить контакт по имени");
      System.out.println("4. Показать все контакты");
      System.out.println("5. Поиск имен по началу");
      System.out.println("6. Показать статистику");
      System.out.println("7. Вернуться в главное меню");

      int choice = validator.getMenuChoice("Выберите действие: ", 7);

      switch (choice) {
        case 1:
          addContactToPhoneBook(phoneBook, validator);
          break;
        case 2:
          findPhoneByName(phoneBook, validator);
          break;
        case 3:
          removeContactByName(phoneBook, validator);
          break;
        case 4:
          showAllContacts(phoneBook);
          break;
        case 5:
          findNamesByPrefix(phoneBook, validator);
          break;
        case 6:
          showPhoneBookStatistics(phoneBook);
          break;
        case 7:
          working = false;
          break;
      }
    }
  }
  //Добавление контакта в телефонную книгу
  private static void addContactToPhoneBook(PhoneBook phoneBook, InputValidator validator) {
    System.out.println("\n--- ДОБАВЛЕНИЕ КОНТАКТА ---");

    String name = validator.getValidContactName("Введите имя: ");
    String phone = validator.getValidPhone("Введите телефон: ");

    String oldPhone = phoneBook.addContact(phone, name);

    if (oldPhone != null) {
      System.out.println(" Контакт обновлен. Старый телефон: " + oldPhone);
    } else {
      System.out.println(" Контакт добавлен: " + name + " - " + phone);
    }

    System.out.println("Всего контактов: " + phoneBook.getContactCount());
  }
  //Поиск контакта в телефонной книге
  private static void findPhoneByName(PhoneBook phoneBook, InputValidator validator) {
    System.out.println("\n--- ПОИСК ТЕЛЕФОНА ПО ИМЕНИ ---");

    String name = validator.getValidContactName("Введите имя для поиска: ");
    String phone = phoneBook.getPhoneByName(name);

    if (phone != null) {
      System.out.println(" Найден контакт: " + name + " - " + phone);
    } else {
      System.out.println(" Контакт с именем '" + name + "' не найден");
    }
  }

  //Удаление контакта по имени из телефонной книги
  private static void removeContactByName(PhoneBook phoneBook, InputValidator validator) {
    System.out.println("\n--- УДАЛЕНИЕ КОНТАКТА ---");

    String name = validator.getValidContactName("Введите имя для удаления: ");

    if (phoneBook.removeContactByName(name)) {
      System.out.println(" Контакт '" + name + "' удален");
      System.out.println("Осталось контактов: " + phoneBook.getContactCount());
    } else {
      System.out.println(" Контакт с именем '" + name + "' не найден");
    }
  }
  //Отображение всех контактов телефонной книги
  private static void showAllContacts(PhoneBook phoneBook) {
    System.out.println("\n--- ВСЕ КОНТАКТЫ ---");
    System.out.println(phoneBook.toString());
  }
  //Поиск имен по префиксу в телефонной книге
  private static void findNamesByPrefix(PhoneBook phoneBook, InputValidator validator) {
    System.out.println("\n--- ПОИСК ИМЕН ПО НАЧАЛУ ---");

    String prefix = validator.getValidContactName("Введите начало имени: ");
    String[] matchingNames = phoneBook.getNamesByPrefix(prefix);

    if (matchingNames.length > 0) {
      System.out.println("Найдено " + matchingNames.length + " контактов:");
      for (int i = 0; i < matchingNames.length; i++) {
        String phone = phoneBook.getPhoneByName(matchingNames[i]);
        System.out.println((i + 1) + ". " + matchingNames[i] + " - " + phone);
      }
    } else {
      System.out.println("Контакты, начинающиеся с '" + prefix + "' не найдены");
    }
  }

  // Отображение статистики телефонной книги
  private static void showPhoneBookStatistics(PhoneBook phoneBook) {
    System.out.println("\n--- СТАТИСТИКА СПРАВОЧНИКА ---");
    System.out.println("Общее количество контактов: " + phoneBook.getContactCount());

    String[] allPhones = phoneBook.getAllPhones();
    String[] allNames = phoneBook.getAllNames();

    System.out.println("Всего телефонов: " + allPhones.length);
    System.out.println("Всего имен: " + allNames.length);

    if (phoneBook.getContactCount() > 0) {
      System.out.println("\nПервые 5 контактов:");
      String[] pairs = phoneBook.getAllPairs();
      for (int i = 0; i < Math.min(5, pairs.length); i++) {
        System.out.println((i + 1) + ". " + pairs[i]);
      }
    }
  }

  //Запуск задачи работы с 3D точками
  private static void runPointTask(InputValidator validator) {
    System.out.println("\n=== ЗАДАЧА: 3D ТОЧКИ КООРДИНАТ ===");
    boolean working = true;
    while (working) {
      System.out.println("1. Создать три 3D точки");
      System.out.println("2. Вернуться в главное меню");
      int choice = validator.getMenuChoice("Выберите действие: ", 2);
      switch (choice) {
        case 1:

          craeteThreePoints(validator);
          break;

        case 2:
          working = false;
          break;
      }
    }
  }

  //Создание трех 3D точек
  private static void craeteThreePoints(InputValidator validator) {
    System.out.println("\n--- Создание Трех 3D Точек ---");
    Point3d[] points = new Point3d[3];
    for (int i = 0; i < 3; i++) {
      System.out.println("\nТочка " + (i + 1) + ":");
      int x = validator.getValidCoordinate("Введите координату X: ");
      int y = validator.getValidCoordinate("Введите координату Y: ");
      int z = validator.getValidCoordinate("Введите координату Z: ");
      points[i] = new Point3d(x, y, z);
      System.out.println(" Создана точка " + (i + 1) + ": " + points[i].toString());
    }

    System.out.println("\n=== СОЗДАННЫЕ ТОЧКИ ===");
    for (int i = 0; i < 3; i++) {
      System.out.println("Точка " + (i + 1) + ": " + points[i].toString());
    }

  }

  //Запуск задачи работы с геометрическими фигурами
  private static void runShapesTask(InputValidator validator) {
    System.out.println("\n=== ЗАДАЧА: ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ===");

    boolean working = true;
    while (working) {
      System.out.println("\n--- Действия с фигурами ---");
      System.out.println("1. Создать круг");
      System.out.println("2. Создать квадрат");
      System.out.println("3. Создать прямоугольник");
      System.out.println("4. Создать треугольник");
      System.out.println("5. Демонстрация полиморфизма (общая площадь)");
      System.out.println("6. Демонстрация замкнутой ломаной квадрата");
      System.out.println("7. Завершить работу");

      int choice = validator.getMenuChoice("Выберите действие: ", 7);

      switch (choice) {
        case 1:
          createCircle(validator);
          break;
        case 2:
          createSquare(validator);
          break;
        case 3:
          createRectangle(validator);
          break;
        case 4:
          createTriangle(validator);
          break;
        case 5:
          demonstratePolymorphism(validator);
          break;
        case 6:
          demonstrateSquarePolyline(validator);
        break;
        case 7:
          working = false;
          break;
      }
    }
  }

  //Создание круга
  private static void createCircle(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ КРУГА ---");

    System.out.println("Центр круга:");
    int centerX = validator.getValidCoordinate("Введите координату X центра: ");
    int centerY = validator.getValidCoordinate("Введите координату Y центра: ");
    int radius = validator.getValidRadius("Введите радиус: ");

    Circle circle = new Circle(centerX, centerY, radius);
    System.out.println(" Создан: " + circle.toString());
    System.out.println("Площадь круга: " + String.format("%.2f", circle.getArea()));
  }

  //Создание квадрата
  private static void createSquare(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ КВАДРАТА ---");

    System.out.println("Левый верхний угол:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int side = validator.getValidSide("Введите длину стороны: ");

    Square square = new Square(x, y, side);
    System.out.println(" Создан: " + square.toString());
    System.out.println("Площадь квадрата: " + String.format("%.2f", square.getArea()));
  }

  //Создание прямоугольника
  private static void createRectangle(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ ПРЯМОУГОЛЬНИКА ---");

    System.out.println("Левый верхний угол:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int width = validator.getValidWidth("Введите ширину: ");
    int height = validator.getValidHeight("Введите высоту: ");

    Rectangle rectangle = new Rectangle(x, y, width, height);
    System.out.println(" Создан: " + rectangle.toString());
    System.out.println("Площадь прямоугольника: " + String.format("%.2f", rectangle.getArea()));
  }

  //Создание треугольника
  private static void createTriangle(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ ТРЕУГОЛЬНИКА ---");

    Point a, b, c;
    int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {
      System.out.println("Точка A:");
      int x1 = validator.getValidCoordinate("Введите X1: ");
      int y1 = validator.getValidCoordinate("Введите Y1: ");

      System.out.println("Точка B:");
      int x2 = validator.getValidCoordinate("Введите X2: ");
      int y2 = validator.getValidCoordinate("Введите Y2: ");

      System.out.println("Точка C:");
      int x3 = validator.getValidCoordinate("Введите X3: ");
      int y3 = validator.getValidCoordinate("Введите Y3: ");

      a = new Point(x1, y1);
      b = new Point(x2, y2);
      c = new Point(x3, y3);

      if (validator.isValidTriangle(a, b, c)) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println(" Создан: " + triangle.toString());
        System.out.println("Площадь треугольника: " + String.format("%.2f", triangle.getArea()));
        return;
      } else {
        attempts++;
        System.out.println(" Ошибка: точки лежат на одной прямой. Попытка " + attempts + " из " + maxAttempts);
        if (attempts < maxAttempts) {
          System.out.println("Попробуйте ввести другие координаты");
        }
      }
    }

    System.out.println(" Не удалось создать треугольник после " + maxAttempts + " попыток");
  }

  //Демонстрация полиморфизма с геометрическими фигурами
  private static void demonstratePolymorphism(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА И ОБЩЕЙ ПЛОЩАДИ ===");
    System.out.println("Создадим несколько фигур и вычислим их общую площадь");

    List<Shape> shapes = new ArrayList<>();


    boolean creating = true;

    while (creating) {
      System.out.println("\n--- Выбор типа фигуры ---");
      System.out.println("1. Создать круг");
      System.out.println("2. Создать квадрат");
      System.out.println("3. Создать прямоугольник");
      System.out.println("4. Создать треугольник");
      System.out.println("5. Закончить создание фигур и показать результаты");

      int choice = validator.getMenuChoice("Выберите действие: ", 5);

      Shape newShape = null;

      switch (choice) {
        case 1:
          newShape = createCircleForDemo(validator);
          break;
        case 2:
          newShape = createSquareForDemo(validator);
          break;
        case 3:
          newShape = createRectangleForDemo(validator);
          break;
        case 4:
          newShape = createTriangleForDemo(validator);
          break;
        case 5:
          creating = false;
          break;
      }

      if (newShape != null) {
        shapes.add(newShape);
      }
    }

    if (shapes.isEmpty()) {
      System.out.println("\nНе создано ни одной фигуры для демонстрации");
      return;
    }

    System.out.println("\n" + "=".repeat(50));
    System.out.println("РЕЗУЛЬТАТЫ ДЕМОНСТРАЦИИ ПОЛИМОРФИЗМА");
    System.out.println("=".repeat(50));

    ShapeSum.printShapesInfo(shapes);

    double totalArea = ShapeSum.calculateTotalArea(shapes);
    System.out.println("\n--- ОБЩАЯ ПЛОЩАДЬ ВСЕХ ФИГУР ---");
    System.out.printf("Общая площадь: %.2f\n", shapes.size(), totalArea);


    System.out.println("\n--- ДЕМОНСТРАЦИЯ ВИРТУАЛЬНОГО ВЫЗОВА ---");
    System.out.println("Вызов getArea() для каждой фигуры (полиморфизм):");
    for (int i = 0; i < shapes.size(); i++) {
      Shape shape = shapes.get(i);
      String typeName = shape.getClass().getSimpleName();
      double area = shape.getArea();
      System.out.printf("%d. %s: getArea() = %.2f\n", i + 1, typeName, area);
    }
  }

  //Создание круга для демонстрации полиморфизма
  private static Circle createCircleForDemo(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ КРУГА ---");
    System.out.println("Центр круга:");
    int centerX = validator.getValidCoordinate("Введите координату X центра: ");
    int centerY = validator.getValidCoordinate("Введите координату Y центра: ");
    int radius = validator.getValidRadius("Введите радиус: ");

    Circle circle = new Circle(centerX, centerY, radius);
    System.out.println(" Создан: " + circle.toString());
    System.out.println("Площадь круга: " + String.format("%.2f", circle.getArea()));
    return circle;
  }

  // Создание квадрата для демонстрации полиморфизма
  private static Square createSquareForDemo(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ КВАДРАТА ---");
    System.out.println("Левый верхний угол:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int side = validator.getValidSide("Введите длину стороны: ");

    Square square = new Square(x, y, side);
    System.out.println(" Создан: " + square.toString());
    System.out.println("Площадь квадрата: " + String.format("%.2f", square.getArea()));
    return square;
  }

  //Создание прямоугольника для демонстрации полиморфизма
  private static Rectangle createRectangleForDemo(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ ПРЯМОУГОЛЬНИКА ---");
    System.out.println("Левый верхний угол:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int width = validator.getValidWidth("Введите ширину: ");
    int height = validator.getValidHeight("Введите высоту: ");

    Rectangle rectangle = new Rectangle(x, y, width, height);
    System.out.println(" Создан: " + rectangle.toString());
    System.out.println("Площадь прямоугольника: " + String.format("%.2f", rectangle.getArea()));
    return rectangle;
  }
  /// Создание треугольника для демонстрации полиморфизма
  private static Triangle createTriangleForDemo(InputValidator validator) {
    System.out.println("\n--- СОЗДАНИЕ ТРЕУГОЛЬНИКА ---");

    Point a, b, c;

    while (true) {
      System.out.println("Точка A:");
      int x1 = validator.getValidCoordinate("Введите X1: ");
      int y1 = validator.getValidCoordinate("Введите Y1: ");

      System.out.println("Точка B:");
      int x2 = validator.getValidCoordinate("Введите X2: ");
      int y2 = validator.getValidCoordinate("Введите Y2: ");

      System.out.println("Точка C:");
      int x3 = validator.getValidCoordinate("Введите X3: ");
      int y3 = validator.getValidCoordinate("Введите Y3: ");

      a = new Point(x1, y1);
      b = new Point(x2, y2);
      c = new Point(x3, y3);

      if (validator.isValidTriangle(a, b, c)) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println(" Создан: " + triangle.toString());
        System.out.println("Площадь треугольника: " + String.format("%.2f", triangle.getArea()));
        return triangle;
      } else {
        System.out.println(" Ошибка: точки лежат на одной прямой.");
        System.out.println("Попробуйте ввести другие координаты");
      }
    }
  }

  //Демонстрация замкнутой ломаной линии квадрата
  private static void demonstrateSquarePolyline(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ КВАДРАТА С ЗАМКНУТОЙ ЛОМАНОЙ ===");

    System.out.println("Создадим квадрат и покажем его замкнутую ломаную линию");

    System.out.println("Левый верхний угол:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int side = validator.getValidSide("Введите длину стороны: ");

    Square square = new Square(x, y, side);


    System.out.println(square.toString());
    System.out.println("Площадь: " + String.format("%.2f", square.getArea()));
    System.out.println("Периметр: " + square.getPerimeter());

    // Демонстрация работы с ломаной линией
    System.out.println("\n--- ЗАМКНУТАЯ ЛОМАНАЯ ЛИНИЯ ---");
    List<Point> polyline = square.getPolyline();

    System.out.println("Точки ломаной:");

    for (int i = 0; i < polyline.size(); i++) {
      Point point = polyline.get(i);
      String pointType = (i == polyline.size() - 1) ? "(замыкающая)" : "";
      System.out.printf("%d. %s %s\n", i + 1, point, pointType);
    }

    Point first = polyline.get(0);
    Point last = polyline.get(polyline.size() - 1);
    System.out.println("\n--- ПРОВЕРКА ЗАМКНУТОСТИ ---");
    System.out.println("Первая точка: " + first);
    System.out.println("Последняя точка: " + last);
    System.out.println("Ломаная замкнута: " +
            (first.getX() == last.getX() && first.getY() == last.getY() ? "ДА" : "НЕТ"));
  }
  //Демонстрация сравнения точек
  private static void demonstratePointEquals(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ СРАВНЕНИЯ ТОЧЕК ===");
    System.out.println("Создадим несколько точек и проверим их равенство");

    System.out.println("\n--- Создание точек для сравнения ---");

    System.out.println("Точка A:");
    int x1 = validator.getValidCoordinate("Введите X1: ");
    int y1 = validator.getValidCoordinate("Введите Y1: ");
    Point pointA = new Point(x1, y1);

    System.out.println("Точка B:");
    int x2 = validator.getValidCoordinate("Введите X2: ");
    int y2 = validator.getValidCoordinate("Введите Y2: ");
    Point pointB = new Point(x2, y2);



    System.out.println("\n--- Сравнение точек ---");
    System.out.println("Точка A: " + pointA);
    System.out.println("Точка B: " + pointB);

    System.out.println("\nРезультаты сравнения:");
    System.out.println("A.equals(B): " + pointA.equals(pointB));


  }
  //Возведение в степень из строковых аргументов
  public static double powerFromStrings(String xStr, String yStr) {
    // Используем короткие имена статических методов
    int x = parseInt(xStr);  // вместо Integer.parseInt
    int y = parseInt(yStr);  // вместо Integer.parseInt

    // Проверка на особые случаи
    if (x == 0 && y == 0) {
      throw new IllegalArgumentException("Ноль в степени ноль не определен");
    }

    if (y < 0) {
      throw new IllegalArgumentException("Отрицательная степень не поддерживается для целых чисел");
    }

    // Используем короткое имя статического метода
    double result = pow(x, y);  // вместо Math.pow

    return result;
  }
  //Демонстрация клонирования точек
  public static void demonstratePointCloning(InputValidator validator) {
    System.out.println("\n=== КЛОНИРОВАНИЕ ТОЧЕК ===");

    System.out.println("\n--- Создание точки ---");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    Point original = new Point(x, y);
    System.out.println("Создана точка: " + original);

    System.out.println("\n--- Клонирование точки ---");
    Point clone = original.clone();
    System.out.println("Оригинальная точка: " + original);
    System.out.println("Клонированная точка: " + clone);
    System.out.println("Это разные объекты: " + (original != clone));
    System.out.println("Но имеют одинаковые значения: " + original.equals(clone));

    System.out.println("\n--- Демонстрация независимости ---");
    int newX = validator.getValidCoordinate("Введите новое X для оригинала: ");
    int newY = validator.getValidCoordinate("Введите новое Y для оригинала: ");

    original.setX(newX);
    original.setY(newY);

    System.out.println("После изменения оригинала:");
    System.out.println("Оригинальная точка: " + original);
    System.out.println("Клонированная точка: " + clone);
    System.out.println("Точки равны: " + original.equals(clone));
  }



}
