package ru.masyutin.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс PhoneBook представляет телефонный справочник
 * Хранит пары "телефон - имя"
 */
public class PhoneBook {
  private Map<String, String> contacts;
  private Map<String, String> nameToPhone;

  public PhoneBook() {
    this.contacts = new HashMap<>();
    this.nameToPhone = new HashMap<>();
  }

  /**
   * Добавление новой пары "телефон - имя"
   */
  public String addContact(String phone, String name) {
    if (phone == null || name == null) {
      throw new IllegalArgumentException("Телефон и имя не могут быть null");
    }

    String oldPhone = null;

    if (nameToPhone.containsKey(name)) {
      oldPhone = nameToPhone.get(name);
      contacts.remove(oldPhone);
    }

    if (contacts.containsKey(phone)) {
      String oldName = contacts.get(phone);
      nameToPhone.remove(oldName);
    }

    contacts.put(phone, name);
    nameToPhone.put(name, phone);

    return oldPhone;
  }

  /**
   * Удаление контакта по имени
   */
  public boolean removeContactByName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Имя не может быть null");
    }

    if (nameToPhone.containsKey(name)) {
      String phone = nameToPhone.get(name);
      nameToPhone.remove(name);
      contacts.remove(phone);
      return true;
    }
    return false;
  }

  /**
   * Получение телефона по имени
   */
  public String getPhoneByName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Имя не может быть null");
    }
    return nameToPhone.get(name);
  }

  /**
   * Проверка наличия имени в справочнике
   */
  public boolean containsName(String name) {
    return nameToPhone.containsKey(name);
  }

  /**
   * Проверка наличия телефона в справочнике
   */
  public boolean containsPhone(String phone) {
    return contacts.containsKey(phone);
  }

  /**
   * Получение количества контактов
   */
  public int getContactCount() {
    return contacts.size();
  }

  /**
   * Получение всех пар "телефон - имя" в виде массива
   */
  public String[] getAllPairs() {
    String[] pairs = new String[contacts.size()];
    int index = 0;

    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      pairs[index++] = entry.getKey() + " - " + entry.getValue();
    }

    return pairs;
  }

  /**
   * Получение всех телефонов в виде массива
   */
  public String[] getAllPhones() {
    return contacts.keySet().toArray(new String[0]);
  }

  /**
   * Получение всех имен в виде массива
   */
  public String[] getAllNames() {
    return nameToPhone.keySet().toArray(new String[0]);
  }

  /**
   * Поиск имен по началу названия
   */
  public String[] getNamesByPrefix(String prefix) {
    if (prefix == null) {
      throw new IllegalArgumentException("Префикс не может быть null");
    }

    List<String> matchingNames = new ArrayList<>();

    for (String name : nameToPhone.keySet()) {
      if (name.startsWith(prefix)) {
        matchingNames.add(name);
      }
    }

    return matchingNames.toArray(new String[0]);
  }

  @Override
  public String toString() {
    if (contacts.isEmpty()) {
      return "Телефонный справочник пуст";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("Телефонный справочник (").append(contacts.size()).append(" контактов):\n");

    int counter = 1;
    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      sb.append(counter).append(". ").append(entry.getKey())
              .append(" - ").append(entry.getValue()).append("\n");
      counter++;
    }

    return sb.toString();
  }
}