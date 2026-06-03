package ru.masyutin.geometry;

import java.util.List;

/**
 * Класс ShapeSum содержит методы для работы с геометрическими фигурами
 * Предоставляет методы для вычислений и вывода информации о фигурах
 */
//FIXME: п.7 методы в PascalCase, п.17 удалить неиспользуемые импорты 
// import java.util.Scanner;
// import ru.masyutin.geometry.*;
// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.List;
//FIXTO:
public class ShapeSum {

    public static double CalculateTotalArea(List<Shape> shapes) {
        double total_Area = 0.0;
        for (Shape shape : shapes) {
            total_Area += shape.GetArea();
        }
        return total_Area;
    }

    public static void PrintShapesInfo(List<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("Список фигур пуст");
            return;
        }

        System.out.println("\n=== ИНФОРМАЦИЯ О ФИГУРАХ ===");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).GetInfo());
        }
    }
}
