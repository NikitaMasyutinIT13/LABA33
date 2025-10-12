package ru.masyutin.geometry;

import java.util.Scanner;

import ru.masyutin.geometry.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс ShapeSum содержит методы для работы с геометрическими фигурами
 * Предоставляет методы для вычислений и вывода информации о фигурах
 */
public class ShapeSum {


  //Вычисление общей площади коллекции фигур
  public static double calculateTotalArea(List<Shape> shapes) {
    double totalArea = 0.0;
    for (Shape shape : shapes) {
      totalArea += shape.getArea();
    }
    return totalArea;
  }

  //Вывод информации о всех фигурах в списке
  public static void printShapesInfo(List<Shape> shapes) {
    if (shapes.isEmpty()) {
      System.out.println("Список фигур пуст");
      return;
    }

    System.out.println("\n=== ИНФОРМАЦИЯ О ФИГУРАХ ===");
    for (int i = 0; i < shapes.size(); i++) {
      System.out.println((i + 1) + ". " + shapes.get(i).getInfo());
    }
  }
}
