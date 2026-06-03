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
//FIXME: п.7 методы в PascalCase
// public class Main {
//   public static void main(String[] args) {
//     if (args.length >= 2) {
//       executePowerCalculation(args);
//       return;
//     }
//
//     runInteractiveMenu();
//   }
// }
//FIXTO:
public class Main {
    public static void main(String[] args) {
        if (args.length >= 2) {
            ExecutePowerCalculation(args);
            return;
        }

        RunInteractiveMenu();
    }

    /**
     * Выполнение возведения в степень из аргументов командной строки
     */
    //FIXME: п.7 методы в PascalCase
    // private static void executePowerCalculation(String[] args) {
    //FIXTO:
    private static void ExecutePowerCalculation(String[] args) {
        System.out.println("=== ВОЗВЕДЕНИЕ В СТЕПЕНЬ ИЗ АРГУМЕНТОВ КОМАНДНОЙ СТРОКИ ===");

        try {
            String x_String = args[0];
            String y_String = args[1];

            double result = PowerFromStrings(x_String, y_String);
            System.out.printf("Результат: %s ^ %s = %.2f\n", x_String, y_String, result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: аргументы должны быть целыми числами");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void runInteractiveMenu() {
    //FIXTO:
    private static void RunInteractiveMenu() {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);
        System.out.println("=== ПРОГРАММА РЕШЕНИЯ ЗАДАЧ ===");

        boolean running = true;
        while (running) {
            ShowMainMenu();
            int choice = validator.GetMenuChoice("Выберите задачу: ", 7);

            switch (choice) {
                case 1:
                    RunStudentTask(validator);
                    break;
                case 2:
                    RunPhoneBookTask(validator);
                    break;
                case 3:
                    RunPointTask(validator);
                    break;
                case 4:
                    RunShapesTask(validator);
                    break;
                case 5:
                    DemonstratePointEquals(validator);
                    break;
                case 6:
                    DemonstratePointCloning(validator);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
        scanner.close();
    }

    //FIXME: п.7 методы в PascalCase
    // private static void showMainMenu() {
    //FIXTO:
    private static void ShowMainMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Задача: Студент с оценками");
        System.out.println("2. Задача: Телефонный справочник");
        System.out.println("3. Задача: Трехмерная точка");
        System.out.println("4. Геометрические фигуры");
        System.out.println("5. Сравнение точек");
        System.out.println("6. Копирование точек");
        System.out.println("7. Выход");
    }

    //FIXME: п.7 методы в PascalCase
    // private static void runStudentTask(InputValidator validator) {
    //FIXTO:
    private static void RunStudentTask(InputValidator validator) {
        System.out.println("\n=== ЗАДАЧА: СТУДЕНТ С ОЦЕНКАМИ ===");

        String name = validator.GetValidStudentName("Введите имя студента: ");
        String group = validator.GetValidGroup("Введите группу студента: ");
        Student student = new Student(name, group);

        System.out.println(" Создан: " + student.GetStudentInfo());

        boolean working = true;
        while (working) {
            System.out.println("\n--- Действия со студентом ---");
            System.out.println("1. Добавить оценку");
            System.out.println("2. Показать информацию");
            System.out.println("3. Показать статистику");
            System.out.println("4. Вернуться в главное меню");

            int choice = validator.GetMenuChoice("Выберите действие: ", 4);

            switch (choice) {
                case 1:
                    int grade = validator.GetValidGrade("Введите оценку (2-5): ");
                    if (student.TryAddGrade(grade)) {
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
                    if (student.HasGrades()) {
                        System.out.println("Количество оценок: " + student.GetGradesCount());
                        System.out.println("Средний балл: " + String.format("%.2f", student.GetAverageGrade()));
                        System.out.println("Отличник: " + (student.IsExcellentStudent() ? "ДА" : "нет"));
                        System.out.println("Есть неудовлетворительные: " +
                                (student.HasUnsatisfactoryGrades() ? "ДА" : "нет"));

                        System.out.println("\nДетальная статистика:");
                        for (int i = 2; i <= 5; i++) {
                            int count = student.CountGrade(i);
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
                default:
                    break;
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void runPhoneBookTask(InputValidator validator) {
    //FIXTO:
    private static void RunPhoneBookTask(InputValidator validator) {
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

            int choice = validator.GetMenuChoice("Выберите действие: ", 7);

            switch (choice) {
                case 1:
                    AddContactToPhoneBook(phoneBook, validator);
                    break;
                case 2:
                    FindPhoneByName(phoneBook, validator);
                    break;
                case 3:
                    RemoveContactByName(phoneBook, validator);
                    break;
                case 4:
                    ShowAllContacts(phoneBook);
                    break;
                case 5:
                    FindNamesByPrefix(phoneBook, validator);
                    break;
                case 6:
                    ShowPhoneBookStatistics(phoneBook);
                    break;
                case 7:
                    working = false;
                    break;
                default:
                    break;
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void addContactToPhoneBook(PhoneBook phoneBook, InputValidator validator) {
    //FIXTO:
    private static void AddContactToPhoneBook(PhoneBook phoneBook, InputValidator validator) {
        System.out.println("\n--- ДОБАВЛЕНИЕ КОНТАКТА ---");

        String name = validator.GetValidContactName("Введите имя: ");
        String phone = validator.GetValidPhone("Введите телефон: ");

        String old_Phone = phoneBook.AddContact(phone, name);

        if (old_Phone != null) {
            System.out.println(" Контакт обновлен. Старый телефон: " + old_Phone);
        } else {
            System.out.println(" Контакт добавлен: " + name + " - " + phone);
        }

        System.out.println("Всего контактов: " + phoneBook.GetContactCount());
    }

    //FIXME: п.7 методы в PascalCase
    // private static void findPhoneByName(PhoneBook phoneBook, InputValidator validator) {
    //FIXTO:
    private static void FindPhoneByName(PhoneBook phoneBook, InputValidator validator) {
        System.out.println("\n--- ПОИСК ТЕЛЕФОНА ПО ИМЕНИ ---");

        String name = validator.GetValidContactName("Введите имя для поиска: ");
        String phone = phoneBook.GetPhoneByName(name);

        if (phone != null) {
            System.out.println(" Найден контакт: " + name + " - " + phone);
        } else {
            System.out.println(" Контакт с именем '" + name + "' не найден");
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void removeContactByName(PhoneBook phoneBook, InputValidator validator) {
    //FIXTO:
    private static void RemoveContactByName(PhoneBook phoneBook, InputValidator validator) {
        System.out.println("\n--- УДАЛЕНИЕ КОНТАКТА ---");

        String name = validator.GetValidContactName("Введите имя для удаления: ");

        if (phoneBook.RemoveContactByName(name)) {
            System.out.println(" Контакт '" + name + "' удален");
            System.out.println("Осталось контактов: " + phoneBook.GetContactCount());
        } else {
            System.out.println(" Контакт с именем '" + name + "' не найден");
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void showAllContacts(PhoneBook phoneBook) {
    //FIXTO:
    private static void ShowAllContacts(PhoneBook phoneBook) {
        System.out.println("\n--- ВСЕ КОНТАКТЫ ---");
        System.out.println(phoneBook.toString());
    }

    //FIXME: п.7 методы в PascalCase
    // private static void findNamesByPrefix(PhoneBook phoneBook, InputValidator validator) {
    //FIXTO:
    private static void FindNamesByPrefix(PhoneBook phoneBook, InputValidator validator) {
        System.out.println("\n--- ПОИСК ИМЕН ПО НАЧАЛУ ---");

        String prefix = validator.GetValidContactName("Введите начало имени: ");
        String[] matching_Names = phoneBook.GetNamesByPrefix(prefix);

        if (matching_Names.length > 0) {
            System.out.println("Найдено " + matching_Names.length + " контактов:");
            for (int i = 0; i < matching_Names.length; i++) {
                String phone = phoneBook.GetPhoneByName(matching_Names[i]);
                System.out.println((i + 1) + ". " + matching_Names[i] + " - " + phone);
            }
        } else {
            System.out.println("Контакты, начинающиеся с '" + prefix + "' не найдены");
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void showPhoneBookStatistics(PhoneBook phoneBook) {
    //FIXTO:
    private static void ShowPhoneBookStatistics(PhoneBook phoneBook) {
        System.out.println("\n--- СТАТИСТИКА СПРАВОЧНИКА ---");
        System.out.println("Общее количество контактов: " + phoneBook.GetContactCount());

        String[] all_Phones = phoneBook.GetAllPhones();
        String[] all_Names = phoneBook.GetAllNames();

        System.out.println("Всего телефонов: " + all_Phones.length);
        System.out.println("Всего имен: " + all_Names.length);

        if (phoneBook.GetContactCount() > 0) {
            System.out.println("\nПервые 5 контактов:");
            String[] pairs = phoneBook.GetAllPairs();
            for (int i = 0; i < Math.min(5, pairs.length); i++) {
                System.out.println((i + 1) + ". " + pairs[i]);
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void runPointTask(InputValidator validator) {
    //FIXTO:
    private static void RunPointTask(InputValidator validator) {
        System.out.println("\n=== ЗАДАЧА: 3D ТОЧКИ КООРДИНАТ ===");
        boolean working = true;
        while (working) {
            System.out.println("1. Создать три 3D точки");
            System.out.println("2. Вернуться в главное меню");
            int choice = validator.GetMenuChoice("Выберите действие: ", 2);
            switch (choice) {
                case 1:
                    CreateThreePoints(validator);
                    break;
                case 2:
                    working = false;
                    break;
                default:
                    break;
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void craeteThreePoints(InputValidator validator) {
    //FIXTO:
    private static void CreateThreePoints(InputValidator validator) {
        System.out.println("\n--- Создание Трех 3D Точек ---");
        Point3d[] points = new Point3d[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nТочка " + (i + 1) + ":");
            int x = validator.GetValidCoordinate("Введите координату X: ");
            int y = validator.GetValidCoordinate("Введите координату Y: ");
            int z = validator.GetValidCoordinate("Введите координату Z: ");
            points[i] = new Point3d(x, y, z);
            System.out.println(" Создана точка " + (i + 1) + ": " + points[i].toString());
        }

        System.out.println("\n=== СОЗДАННЫЕ ТОЧКИ ===");
        for (int i = 0; i < 3; i++) {
            System.out.println("Точка " + (i + 1) + ": " + points[i].toString());
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void runShapesTask(InputValidator validator) {
    //FIXTO:
    private static void RunShapesTask(InputValidator validator) {
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

            int choice = validator.GetMenuChoice("Выберите действие: ", 7);

            switch (choice) {
                case 1:
                    CreateCircle(validator);
                    break;
                case 2:
                    CreateSquare(validator);
                    break;
                case 3:
                    CreateRectangle(validator);
                    break;
                case 4:
                    CreateTriangle(validator);
                    break;
                case 5:
                    DemonstratePolymorphism(validator);
                    break;
                case 6:
                    DemonstrateSquarePolyline(validator);
                    break;
                case 7:
                    working = false;
                    break;
                default:
                    break;
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void createCircle(InputValidator validator) {
    //FIXTO:
    private static void CreateCircle(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ КРУГА ---");

        System.out.println("Центр круга:");
        int center_X = validator.GetValidCoordinate("Введите координату X центра: ");
        int center_Y = validator.GetValidCoordinate("Введите координату Y центра: ");
        int radius = validator.GetValidRadius("Введите радиус: ");

        Circle circle = new Circle(center_X, center_Y, radius);
        System.out.println(" Создан: " + circle.toString());
        System.out.println("Площадь круга: " + String.format("%.2f", circle.GetArea()));
    }

    //FIXME: п.7 методы в PascalCase
    // private static void createSquare(InputValidator validator) {
    //FIXTO:
    private static void CreateSquare(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ КВАДРАТА ---");

        System.out.println("Левый верхний угол:");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        int side = validator.GetValidSide("Введите длину стороны: ");

        Square square = new Square(x, y, side);
        System.out.println(" Создан: " + square.toString());
        System.out.println("Площадь квадрата: " + String.format("%.2f", square.GetArea()));
    }

    //FIXME: п.7 методы в PascalCase
    // private static void createRectangle(InputValidator validator) {
    //FIXTO:
    private static void CreateRectangle(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ ПРЯМОУГОЛЬНИКА ---");

        System.out.println("Левый верхний угол:");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        int width = validator.GetValidWidth("Введите ширину: ");
        int height = validator.GetValidHeight("Введите высоту: ");

        Rectangle rectangle = new Rectangle(x, y, width, height);
        System.out.println(" Создан: " + rectangle.toString());
        System.out.println("Площадь прямоугольника: " + String.format("%.2f", rectangle.GetArea()));
    }

    //FIXME: п.7 методы в PascalCase
    // private static void createTriangle(InputValidator validator) {
    //FIXTO:
    private static void CreateTriangle(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ ТРЕУГОЛЬНИКА ---");

        Point point_A, point_B, point_C;
        int max_Attempts = 3;
        int attempts = 0;

        while (attempts < max_Attempts) {
            System.out.println("Точка A:");
            int x1 = validator.GetValidCoordinate("Введите X1: ");
            int y1 = validator.GetValidCoordinate("Введите Y1: ");

            System.out.println("Точка B:");
            int x2 = validator.GetValidCoordinate("Введите X2: ");
            int y2 = validator.GetValidCoordinate("Введите Y2: ");

            System.out.println("Точка C:");
            int x3 = validator.GetValidCoordinate("Введите X3: ");
            int y3 = validator.GetValidCoordinate("Введите Y3: ");

            point_A = new Point(x1, y1);
            point_B = new Point(x2, y2);
            point_C = new Point(x3, y3);

            if (validator.IsValidTriangle(point_A, point_B, point_C)) {
                Triangle triangle = new Triangle(point_A, point_B, point_C);
                System.out.println(" Создан: " + triangle.toString());
                System.out.println("Площадь треугольника: " + String.format("%.2f", triangle.GetArea()));
                return;
            } else {
                attempts++;
                System.out.println(" Ошибка: точки лежат на одной прямой. Попытка " + attempts + " из " + max_Attempts);
                if (attempts < max_Attempts) {
                    System.out.println("Попробуйте ввести другие координаты");
                }
            }
        }

        System.out.println(" Не удалось создать треугольник после " + max_Attempts + " попыток");
    }

    //FIXME: п.7 методы в PascalCase
    // private static void demonstratePolymorphism(InputValidator validator) {
    //FIXTO:
    private static void DemonstratePolymorphism(InputValidator validator) {
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

            int choice = validator.GetMenuChoice("Выберите действие: ", 5);

            Shape new_Shape = null;

            switch (choice) {
                case 1:
                    new_Shape = CreateCircleForDemo(validator);
                    break;
                case 2:
                    new_Shape = CreateSquareForDemo(validator);
                    break;
                case 3:
                    new_Shape = CreateRectangleForDemo(validator);
                    break;
                case 4:
                    new_Shape = CreateTriangleForDemo(validator);
                    break;
                case 5:
                    creating = false;
                    break;
                default:
                    break;
            }

            if (new_Shape != null) {
                shapes.add(new_Shape);
            }
        }

        if (shapes.isEmpty()) {
            System.out.println("\nНе создано ни одной фигуры для демонстрации");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("РЕЗУЛЬТАТЫ ДЕМОНСТРАЦИИ ПОЛИМОРФИЗМА");
        System.out.println("=".repeat(50));

        ShapeSum.PrintShapesInfo(shapes);

        double total_Area = ShapeSum.CalculateTotalArea(shapes);
        System.out.println("\n--- ОБЩАЯ ПЛОЩАДЬ ВСЕХ ФИГУР ---");
        System.out.printf("Общая площадь: %.2f\n", total_Area);

        System.out.println("\n--- ДЕМОНСТРАЦИЯ ВИРТУАЛЬНОГО ВЫЗОВА ---");
        System.out.println("Вызов GetArea() для каждой фигуры (полиморфизм):");
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            String type_Name = shape.getClass().getSimpleName();
            double area = shape.GetArea();
            System.out.printf("%d. %s: GetArea() = %.2f\n", i + 1, type_Name, area);
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static Circle createCircleForDemo(InputValidator validator) {
    //FIXTO:
    private static Circle CreateCircleForDemo(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ КРУГА ---");
        System.out.println("Центр круга:");
        int center_X = validator.GetValidCoordinate("Введите координату X центра: ");
        int center_Y = validator.GetValidCoordinate("Введите координату Y центра: ");
        int radius = validator.GetValidRadius("Введите радиус: ");

        Circle circle = new Circle(center_X, center_Y, radius);
        System.out.println(" Создан: " + circle.toString());
        System.out.println("Площадь круга: " + String.format("%.2f", circle.GetArea()));
        return circle;
    }

    //FIXME: п.7 методы в PascalCase
    // private static Square createSquareForDemo(InputValidator validator) {
    //FIXTO:
    private static Square CreateSquareForDemo(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ КВАДРАТА ---");
        System.out.println("Левый верхний угол:");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        int side = validator.GetValidSide("Введите длину стороны: ");

        Square square = new Square(x, y, side);
        System.out.println(" Создан: " + square.toString());
        System.out.println("Площадь квадрата: " + String.format("%.2f", square.GetArea()));
        return square;
    }

    //FIXME: п.7 методы в PascalCase
    // private static Rectangle createRectangleForDemo(InputValidator validator) {
    //FIXTO:
    private static Rectangle CreateRectangleForDemo(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ ПРЯМОУГОЛЬНИКА ---");
        System.out.println("Левый верхний угол:");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        int width = validator.GetValidWidth("Введите ширину: ");
        int height = validator.GetValidHeight("Введите высоту: ");

        Rectangle rectangle = new Rectangle(x, y, width, height);
        System.out.println(" Создан: " + rectangle.toString());
        System.out.println("Площадь прямоугольника: " + String.format("%.2f", rectangle.GetArea()));
        return rectangle;
    }

    //FIXME: п.7 методы в PascalCase
    // private static Triangle createTriangleForDemo(InputValidator validator) {
    //FIXTO:
    private static Triangle CreateTriangleForDemo(InputValidator validator) {
        System.out.println("\n--- СОЗДАНИЕ ТРЕУГОЛЬНИКА ---");

        Point point_A, point_B, point_C;

        while (true) {
            System.out.println("Точка A:");
            int x1 = validator.GetValidCoordinate("Введите X1: ");
            int y1 = validator.GetValidCoordinate("Введите Y1: ");

            System.out.println("Точка B:");
            int x2 = validator.GetValidCoordinate("Введите X2: ");
            int y2 = validator.GetValidCoordinate("Введите Y2: ");

            System.out.println("Точка C:");
            int x3 = validator.GetValidCoordinate("Введите X3: ");
            int y3 = validator.GetValidCoordinate("Введите Y3: ");

            point_A = new Point(x1, y1);
            point_B = new Point(x2, y2);
            point_C = new Point(x3, y3);

            if (validator.IsValidTriangle(point_A, point_B, point_C)) {
                Triangle triangle = new Triangle(point_A, point_B, point_C);
                System.out.println(" Создан: " + triangle.toString());
                System.out.println("Площадь треугольника: " + String.format("%.2f", triangle.GetArea()));
                return triangle;
            } else {
                System.out.println(" Ошибка: точки лежат на одной прямой.");
                System.out.println("Попробуйте ввести другие координаты");
            }
        }
    }

    //FIXME: п.7 методы в PascalCase
    // private static void demonstrateSquarePolyline(InputValidator validator) {
    //FIXTO:
    private static void DemonstrateSquarePolyline(InputValidator validator) {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КВАДРАТА С ЗАМКНУТОЙ ЛОМАНОЙ ===");

        System.out.println("Создадим квадрат и покажем его замкнутую ломаную линию");

        System.out.println("Левый верхний угол:");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        int side = validator.GetValidSide("Введите длину стороны: ");

        Square square = new Square(x, y, side);

        System.out.println(square.toString());
        System.out.println("Площадь: " + String.format("%.2f", square.GetArea()));
        System.out.println("Периметр: " + square.GetPerimeter());

        System.out.println("\n--- ЗАМКНУТАЯ ЛОМАНАЯ ЛИНИЯ ---");
        List<Point> polyline = square.GetPolyline();

        System.out.println("Точки ломаной:");

        for (int i = 0; i < polyline.size(); i++) {
            Point point = polyline.get(i);
            String point_Type = (i == polyline.size() - 1) ? "(замыкающая)" : "";
            System.out.printf("%d. %s %s\n", i + 1, point, point_Type);
        }

        Point first = polyline.get(0);
        Point last = polyline.get(polyline.size() - 1);
        System.out.println("\n--- ПРОВЕРКА ЗАМКНУТОСТИ ---");
        System.out.println("Первая точка: " + first);
        System.out.println("Последняя точка: " + last);
        System.out.println("Ломаная замкнута: " +
                (first.GetX() == last.GetX() && first.GetY() == last.GetY() ? "ДА" : "НЕТ"));
    }

    //FIXME: п.7 методы в PascalCase
    // private static void demonstratePointEquals(InputValidator validator) {
    //FIXTO:
    private static void DemonstratePointEquals(InputValidator validator) {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ СРАВНЕНИЯ ТОЧЕК ===");
        System.out.println("Создадим несколько точек и проверим их равенство");

        System.out.println("\n--- Создание точек для сравнения ---");

        System.out.println("Точка A:");
        int x1 = validator.GetValidCoordinate("Введите X1: ");
        int y1 = validator.GetValidCoordinate("Введите Y1: ");
        Point point_A = new Point(x1, y1);

        System.out.println("Точка B:");
        int x2 = validator.GetValidCoordinate("Введите X2: ");
        int y2 = validator.GetValidCoordinate("Введите Y2: ");
        Point point_B = new Point(x2, y2);

        System.out.println("\n--- Сравнение точек ---");
        System.out.println("Точка A: " + point_A);
        System.out.println("Точка B: " + point_B);

        System.out.println("\nРезультаты сравнения:");
        System.out.println("A.equals(B): " + point_A.equals(point_B));
    }

    //FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case 
    // public static double powerFromStrings(String xStr, String yStr) {
    //FIXTO:
    public static double PowerFromStrings(String x_String, String y_String) {
        int x = parseInt(x_String);
        int y = parseInt(y_String);

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("Ноль в степени ноль не определен");
        }

        if (y < 0) {
            throw new IllegalArgumentException("Отрицательная степень не поддерживается для целых чисел");
        }

        return pow(x, y);
    }

    //FIXME: п.7 методы в PascalCase
    // public static void demonstratePointCloning(InputValidator validator) {
    //FIXTO:
    public static void DemonstratePointCloning(InputValidator validator) {
        System.out.println("\n=== КЛОНИРОВАНИЕ ТОЧЕК ===");

        System.out.println("\n--- Создание точки ---");
        int x = validator.GetValidCoordinate("Введите координату X: ");
        int y = validator.GetValidCoordinate("Введите координату Y: ");
        Point original = new Point(x, y);
        System.out.println("Создана точка: " + original);

        System.out.println("\n--- Клонирование точки ---");
        Point clone = original.Clone();
        System.out.println("Оригинальная точка: " + original);
        System.out.println("Клонированная точка: " + clone);
        System.out.println("Это разные объекты: " + (original != clone));
        System.out.println("Но имеют одинаковые значения: " + original.equals(clone));

        System.out.println("\n--- Демонстрация независимости ---");
        int new_X = validator.GetValidCoordinate("Введите новое X для оригинала: ");
        int new_Y = validator.GetValidCoordinate("Введите новое Y для оригинала: ");

        original.SetX(new_X);
        original.SetY(new_Y);

        System.out.println("После изменения оригинала:");
        System.out.println("Оригинальная точка: " + original);
        System.out.println("Клонированная точка: " + clone);
        System.out.println("Точки равны: " + original.equals(clone));
    }
}
