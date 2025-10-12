package ru.masyutin.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Класс Student представляет студента с оценками
 * Содержит информацию о студенте и методы для работы с оценками
 */
public class Student {
  private String name;
  private String group;
  private List<Integer> grades;

  //Конструктор по умолчанию
  public Student() {
    this.name = "Неизвестно";
    this.group = "Не назначена";
    this.grades = new ArrayList<>();
  }

  //Конструктор с именем и группой
  public Student(String name, String group) {
    this.name = name;
    this.group = group;
    this.grades = new ArrayList<>();
  }

  //Получение имени студента
  public String getName() {
    return name;
  }

  //Получение группы студентa
  public String getGroup() {
    return group;
  }

  //Получение неизменяемого списка оценок
  public List<Integer> getGrades() {
    return Collections.unmodifiableList(grades);
  }

  //Установка имени студента
  public void setName(String name) {
    this.name = name;
  }

  //Установка группы студента
  public void setGroup(String group) {
    this.group = group;
  }

  //Добавление оценки с валидацией
  public void addGrade(int grade) {
    if (grade < 2 || grade > 5) {
      throw new InvalidGradeException("Оценка " + grade + " недопустима. Диапазон: 2-5");
    }
    grades.add(grade);
  }

  //Попытка добавления оценки без исключения
  public boolean tryAddGrade(int grade) {
    if (grade >= 2 && grade <= 5) {
      grades.add(grade);
      return true;
    }
    return false;
  }

  //Вычисление среднего балла студента
  public double getAverageGrade() {
    if (grades.isEmpty()) {
      return 0.0;
    }

    int sum = 0;
    for (int grade : grades) {
      sum += grade;
    }
    return (double) sum / grades.size();
  }

  //Получение количества оценок
  public int getGradesCount() {
    return grades.size();
  }

  //Проверка наличия оценок
  public boolean hasGrades() {
    return !grades.isEmpty();
  }

  //Проверка является ли студент отличником
  public boolean isExcellentStudent() {
    if (grades.isEmpty()) return false;

    for (int grade : grades) {
      if (grade != 5) {
        return false;
      }
    }
    return true;
  }

  //Проверка наличия неудовлетворительных оценок
  public boolean hasUnsatisfactoryGrades() {
    for (int grade : grades) {
      if (grade == 2) {
        return true;
      }
    }
    return false;
  }

  //Подсчет количества конкретных оценок
  public int countGrade(int targetGrade) {
    int count = 0;
    for (int grade : grades) {
      if (grade == targetGrade) {
        count++;
      }
    }
    return count;
  }

  //Получение базовой информации о студенте
  public String getStudentInfo() {
    return "Студент: " + name + ", Группа: " + group + ", Оценок: " + grades.size();
  }

  //Полное строковое представление студента
  @Override
  public String toString() {
    String info = "Студент: " + name + ", Группа: " + group;

    if (hasGrades()) {
      info += ", Оценки: " + grades + ", Средний: " + String.format("%.2f", getAverageGrade());
      if (isExcellentStudent()) info += " [ОТЛИЧНИК]";
      if (hasUnsatisfactoryGrades()) info += " [ЕСТЬ НЕУД]";
    } else {
      info += ", Оценки: нет";
    }

    return info;
  }
}

//Исключение для невалидных оценок
class InvalidGradeException extends RuntimeException {
  //Конструктор исключения
  public InvalidGradeException(String message) {
    super(message);
  }
}