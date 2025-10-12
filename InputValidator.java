package ru.masyutin.utils;

import java.util.Scanner;

import ru.masyutin.geometry.*;

/**
 * Класс InputValidator предоставляет методы для валидации пользовательского ввода
 * Обеспечивает корректность данных, вводимых пользователем
 */

public class InputValidator {

  private Scanner scanner;

  //Конструктор валидатора
  public InputValidator(Scanner scanner) {
    this.scanner = scanner;
  }

  //Валидация целого числа
  public int getValidInt(String prompt) {
    while (true) {
      System.out.print(prompt);
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
      } else {
        System.out.println("Ошибка: введите целое число");
        scanner.nextLine();
      }
    }
  }

  //Валидация целого числа в диапазоне
  public int getValidInt(String prompt, int min, int max) {
    while (true) {
      System.out.print(prompt);
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        scanner.nextLine();

        if (value >= min && value <= max) {
          return value;
        } else {
          System.out.println("Ошибка: число должно быть от " + min + " до " + max);
        }
      } else {
        System.out.println("Ошибка: введите целое число");
        scanner.nextLine();
      }
    }
  }

  //Валидация строки с минимальной длиной
  public String getValidString(String prompt, int minLength) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();

      if (input.length() >= minLength) {
        return input;
      } else {
        System.out.println("Ошибка: введите не менее " + minLength + " символов");
      }
    }
  }

  //Валидация выбора пункта меню
  public int getMenuChoice(String prompt, int options) {
    return getValidInt(prompt, 1, options);
  }

  //Валидация логического выбора (да/нет)
  public boolean getBooleanChoice(String prompt) {
    int choice = getValidInt(prompt + " (1 - да, 0 - нет): ", 0, 1);
    return choice == 1;
  }

  //Валидация номера телефона
  public String getValidPhone(String prompt) {
    while (true) {
      String phone = getValidString(prompt, 5);

      boolean isValid = true;
      for (int i = 0; i < phone.length(); i++) {
        char c = phone.charAt(i);
        if (i == 0 && c == '+') {
          continue;
        }
        if (c < '0' || c > '9') {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        return phone;
      } else {
        System.out.println("Ошибка: телефон должен содержать только цифры и может начинаться с '+'");
      }
    }
  }

  //Валидация имени контакта
  public String getValidContactName(String prompt) {
    return getValidString(prompt, 1);
  }

  //Валидация оценки студента
  public int getValidGrade(String prompt) {
    return getValidInt(prompt, 2, 5);
  }


  //Валидация имени студента
  public String getValidStudentName(String prompt) {
    while (true) {
      String name = getValidString(prompt, 2);

      boolean hasInvalidChars = false;
      boolean hasLetters = false;

      for (int i = 0; i < name.length(); i++) {
        char c = name.charAt(i);

        if (c >= '0' && c <= '9') {
          System.out.println("Ошибка: имя не может содержать цифры");
          hasInvalidChars = true;
          break;
        }

        if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
                (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                c == ' ' || c == '-') {
          if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
                  (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            hasLetters = true;
          }
        } else {
          System.out.println("Ошибка: имя может содержать только буквы, пробелы и дефисы");
          hasInvalidChars = true;
          break;
        }
      }

      if (hasInvalidChars) {
        continue;
      }

      if (!hasLetters) {
        System.out.println("Ошибка: имя должно содержать буквы");
        continue;
      }

      return name;
    }
  }

  //Валидация номера группы студента
  public String getValidGroup(String prompt) {
    while (true) {
      String group = getValidString(prompt, 1);

      boolean hasLetters = false;
      boolean hasDigits = false;

      for (int i = 0; i < group.length(); i++) {
        char c = group.charAt(i);
        if ((c >= 'А' && c <= 'Я') || (c >= 'A' && c <= 'Z') ||
                (c >= 'а' && c <= 'я') || (c >= 'a' && c <= 'z')) {
          hasLetters = true;
        } else if (c >= '0' && c <= '9') {
          hasDigits = true;
        } else if (c != '-' && c != ' ') {
          System.out.println("Ошибка: номер группы может содержать только буквы, цифры и дефис");
          continue;
        }
      }

      if (!hasLetters) {
        System.out.println("Ошибка: номер группы должен содержать буквы");
        continue;
      }

      return group;
    }
  }


  //Проверка валидности треугольника
  public boolean isValidTriangle(Point a, Point b, Point c) {

    int area = a.getX() * (b.getY() - c.getY()) +
            b.getX() * (c.getY() - a.getY()) +
            c.getX() * (a.getY() - b.getY());
    return area != 0;
  }


  //Валидация положительного целого числа
  public int getValidPositiveInt(String prompt) {
    while (true) {
      int value = getValidInt(prompt);
      if (value > 0) {
        return value;
      } else {
        System.out.println("Ошибка: число должно быть положительным");
      }
    }
  }


  //Валидация радиуса фигуры
  public int getValidRadius(String prompt) {
    return getValidPositiveInt(prompt);
  }

  //Валидация стороны фигуры
  public int getValidSide(String prompt) {
    return getValidPositiveInt(prompt);
  }

  //Валидация ширины фигуры
  public int getValidWidth(String prompt) {
    return getValidPositiveInt(prompt);
  }

  //Валидация высоты фигуры
  public int getValidHeight(String prompt) {
    return getValidPositiveInt(prompt);
  }

  //Валидация координаты (любое целое число)
  public int getValidCoordinate(String prompt) {
    return getValidInt(prompt);
  }
}
