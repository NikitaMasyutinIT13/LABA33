package ru.masyutin.geometry;
/**
 * Класс Point3d представляет точку в трехмерном пространстве
 * Наследуется от класса Point
 */
public class Point3d extends Point{
  private int z;

  //Получение координаты
  public double getZ(){
    return z;
  }
  //Установка координаты
  public void setZ(){
    this.z=z;
  }

  //Конструктор точки с 3 координатами
  public Point3d(int x, int y, int z){
    super(x,y);
    this.z=z;
  }

  //Строковое представление 3D точки
  @Override
  public String toString(){
    return "{" + x + ";" + y + ";" + z + "}";
  }

}
