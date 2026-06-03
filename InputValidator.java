package ru.masyutin.utils;

import java.util.Scanner;
import ru.masyutin.geometry.Point;

/**
 * Класс InputValidator предоставляет методы для валидации пользовательского ввода
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case
// public class InputValidator {
//     private Scanner scanner;
//
//     public InputValidator(Scanner scanner) {
//         this.scanner = scanner;
//     }
//
//     public int getValidInt(String prompt) {
//         while (true) {
//             System.out.print(prompt);
//             if (scanner.hasNextInt()) {
//                 int value = scanner.nextInt();
//                 scanner.nextLine();
//                 return value;
//             } else {
//                 System.out.println("Ошибка: введите целое число");
//                 scanner.nextLine();
//             }
//         }
//     }
//
//     public int getValidInt(String prompt, int min, int max) {
//         while (true) {
//             int value = getValidInt(prompt);
//             if (value >= min && value <= max) {
//                 return value;
//             }
//             System.out.println("Ошибка: число должно быть от " + min + " до " + max);
//         }
//     }
//
//     public String getValidString(String prompt, int minLength) {
//         while (true) {
//             System.out.print(prompt);
//             String input = scanner.nextLine().trim();
//             if (input.length() >= minLength) {
//                 return input;
//             }
//             System.out.println("Ошибка: введите не менее " + minLength + " символов");
//         }
//     }
//
//     public int getMenuChoice(String prompt, int options) {
//         return getValidInt(prompt, 1, options);
//     }
//
//     public boolean getBooleanChoice(String prompt) {
//         int choice = getValidInt(prompt + " (1 - да, 0 - нет): ", 0, 1);
//         return choice == 1;
//     }
//
//     public String getValidPhone(String prompt) {
//         while (true) {
//             String phone = getValidString(prompt, 5);
//             boolean isValid = true;
//             for (int i = 0; i < phone.length(); i++) {
//                 char c = phone.charAt(i);
//                 if (i == 0 && c == '+') continue;
//                 if (c < '0' || c > '9') {
//                     isValid = false;
//                     break;
//                 }
//             }
//             if (isValid) return phone;
//             System.out.println("Ошибка: телефон должен содержать только цифры и может начинаться с '+'");
//         }
//     }
//
//     public String getValidContactName(String prompt) {
//         return getValidString(prompt, 1);
//     }
//
//     public int getValidGrade(String prompt) {
//         return getValidInt(prompt, 2, 5);
//     }
//
//     public String getValidStudentName(String prompt) {
//         while (true) {
//             String name = getValidString(prompt, 2);
//             boolean hasInvalidChars = false;
//             boolean hasLetters = false;
//             for (int i = 0; i < name.length(); i++) {
//                 char c = name.charAt(i);
//                 if (c >= '0' && c <= '9') {
//                     System.out.println("Ошибка: имя не может содержать цифры");
//                     hasInvalidChars = true;
//                     break;
//                 }
//                 if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
//                     (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
//                     c == ' ' || c == '-') {
//                     if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
//                         (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
//                         hasLetters = true;
//                     }
//                 } else {
//                     System.out.println("Ошибка: имя может содержать только буквы, пробелы и дефисы");
//                     hasInvalidChars = true;
//                     break;
//                 }
//             }
//             if (hasInvalidChars) continue;
//             if (!hasLetters) {
//                 System.out.println("Ошибка: имя должно содержать буквы");
//                 continue;
//             }
//             return name;
//         }
//     }
//
//     public String getValidGroup(String prompt) {
//         while (true) {
//             String group = getValidString(prompt, 1);
//             boolean hasLetters = false;
//             for (int i = 0; i < group.length(); i++) {
//                 char c = group.charAt(i);
//                 if ((c >= 'А' && c <= 'Я') || (c >= 'A' && c <= 'Z') ||
//                     (c >= 'а' && c <= 'я') || (c >= 'a' && c <= 'z')) {
//                     hasLetters = true;
//                 } else if (c >= '0' && c <= '9') {
//                 } else if (c != '-' && c != ' ') {
//                     System.out.println("Ошибка: номер группы может содержать только буквы, цифры, пробелы и дефис");
//                     continue;
//                 }
//             }
//             if (!hasLetters) {
//                 System.out.println("Ошибка: номер группы должен содержать буквы");
//                 continue;
//             }
//             return group;
//         }
//     }
//
//     public boolean isValidTriangle(Point a, Point b, Point c) {
//         int area = a.getX() * (b.getY() - c.getY()) +
//                    b.getX() * (c.getY() - a.getY()) +
//                    c.getX() * (a.getY() - b.getY());
//         return area != 0;
//     }
//
//     public int getValidPositiveInt(String prompt) {
//         while (true) {
//             int value = getValidInt(prompt);
//             if (value > 0) return value;
//             System.out.println("Ошибка: число должно быть положительным");
//         }
//     }
//
//     public int getValidRadius(String prompt) {
//         return getValidPositiveInt(prompt);
//     }
//
//     public int getValidSide(String prompt) {
//         return getValidPositiveInt(prompt);
//     }
//
//     public int getValidWidth(String prompt) {
//         return getValidPositiveInt(prompt);
//     }
//
//     public int getValidHeight(String prompt) {
//         return getValidPositiveInt(prompt);
//     }
//
//     public int getValidCoordinate(String prompt) {
//         return getValidInt(prompt);
//     }
// }
//FIXTO:
public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int GetValidInt(String prompt) {
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

    public int GetValidInt(String prompt, int min, int max) {
        while (true) {
            int value = GetValidInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка: число должно быть от " + min + " до " + max);
        }
    }

    public String GetValidString(String prompt, int min_Length) {
        while (true) {
            System.out.print(prompt);
            String input_String = scanner.nextLine().trim();
            if (input_String.length() >= min_Length) {
                return input_String;
            }
            System.out.println("Ошибка: введите не менее " + min_Length + " символов");
        }
    }

    public int GetMenuChoice(String prompt, int options) {
        return GetValidInt(prompt, 1, options);
    }

    public boolean GetBooleanChoice(String prompt) {
        int choice = GetValidInt(prompt + " (1 - да, 0 - нет): ", 0, 1);
        return choice == 1;
    }

    public String GetValidPhone(String prompt) {
        while (true) {
            String phone = GetValidString(prompt, 5);
            boolean is_Valid = true;
            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                if (i == 0 && c == '+') continue;
                if (c < '0' || c > '9') {
                    is_Valid = false;
                    break;
                }
            }
            if (is_Valid) return phone;
            System.out.println("Ошибка: телефон должен содержать только цифры и может начинаться с '+'");
        }
    }

    public String GetValidContactName(String prompt) {
        return GetValidString(prompt, 1);
    }

    public int GetValidGrade(String prompt) {
        return GetValidInt(prompt, 2, 5);
    }

    public String GetValidStudentName(String prompt) {
        while (true) {
            String name = GetValidString(prompt, 2);
            boolean has_Invalid_Chars = false;
            boolean has_Letters = false;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (c >= '0' && c <= '9') {
                    System.out.println("Ошибка: имя не может содержать цифры");
                    has_Invalid_Chars = true;
                    break;
                }
                if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
                    (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                    c == ' ' || c == '-') {
                    if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') ||
                        (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                        has_Letters = true;
                    }
                } else {
                    System.out.println("Ошибка: имя может содержать только буквы, пробелы и дефисы");
                    has_Invalid_Chars = true;
                    break;
                }
            }
            if (has_Invalid_Chars) continue;
            if (!has_Letters) {
                System.out.println("Ошибка: имя должно содержать буквы");
                continue;
            }
            return name;
        }
    }

    public String GetValidGroup(String prompt) {
        while (true) {
            String group = GetValidString(prompt, 1);
            boolean has_Letters = false;
            for (int i = 0; i < group.length(); i++) {
                char c = group.charAt(i);
                if ((c >= 'А' && c <= 'Я') || (c >= 'A' && c <= 'Z') ||
                    (c >= 'а' && c <= 'я') || (c >= 'a' && c <= 'z')) {
                    has_Letters = true;
                } else if (c >= '0' && c <= '9') {
                } else if (c != '-' && c != ' ') {
                    System.out.println("Ошибка: номер группы может содержать только буквы, цифры, пробелы и дефис");
                    continue;
                }
            }
            if (!has_Letters) {
                System.out.println("Ошибка: номер группы должен содержать буквы");
                continue;
            }
            return group;
        }
    }

    public boolean IsValidTriangle(Point a, Point b, Point c) {
        int area = a.GetX() * (b.GetY() - c.GetY()) +
                   b.GetX() * (c.GetY() - a.GetY()) +
                   c.GetX() * (a.GetY() - b.GetY());
        return area != 0;
    }

    public int GetValidPositiveInt(String prompt) {
        while (true) {
            int value = GetValidInt(prompt);
            if (value > 0) return value;
            System.out.println("Ошибка: число должно быть положительным");
        }
    }

    public int GetValidRadius(String prompt) {
        return GetValidPositiveInt(prompt);
    }

    public int GetValidSide(String prompt) {
        return GetValidPositiveInt(prompt);
    }

    public int GetValidWidth(String prompt) {
        return GetValidPositiveInt(prompt);
    }

    public int GetValidHeight(String prompt) {
        return GetValidPositiveInt(prompt);
    }

    public int GetValidCoordinate(String prompt) {
        return GetValidInt(prompt);
    }
}
