package ru.masyutin.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс PhoneBook представляет телефонный справочник
 * Хранит пары "телефон - имя"
 */
//FIXME: п.7 методы в PascalCase, п.8 переменные в camel_Case
// public class PhoneBook {
//   private Map<String, String> contacts;
//   private Map<String, String> nameToPhone;
//
//   public PhoneBook() {
//     this.contacts = new HashMap<>();
//     this.nameToPhone = new HashMap<>();
//   }
//
//   public String addContact(String phone, String name) {
//     if (phone == null || name == null) {
//       throw new IllegalArgumentException("Телефон и имя не могут быть null");
//     }
//
//     String oldPhone = null;
//
//     if (nameToPhone.containsKey(name)) {
//       oldPhone = nameToPhone.get(name);
//       contacts.remove(oldPhone);
//     }
//
//     if (contacts.containsKey(phone)) {
//       String oldName = contacts.get(phone);
//       nameToPhone.remove(oldName);
//     }
//
//     contacts.put(phone, name);
//     nameToPhone.put(name, phone);
//
//     return oldPhone;
//   }
//
//   public boolean removeContactByName(String name) {
//     if (name == null) {
//       throw new IllegalArgumentException("Имя не может быть null");
//     }
//
//     if (nameToPhone.containsKey(name)) {
//       String phone = nameToPhone.get(name);
//       nameToPhone.remove(name);
//       contacts.remove(phone);
//       return true;
//     }
//     return false;
//   }
//
//   public String getPhoneByName(String name) {
//     if (name == null) {
//       throw new IllegalArgumentException("Имя не может быть null");
//     }
//     return nameToPhone.get(name);
//   }
//
//   public boolean containsName(String name) {
//     return nameToPhone.containsKey(name);
//   }
//
//   public boolean containsPhone(String phone) {
//     return contacts.containsKey(phone);
//   }
//
//   public int getContactCount() {
//     return contacts.size();
//   }
//
//   public String[] getAllPairs() {
//     String[] pairs = new String[contacts.size()];
//     int index = 0;
//
//     for (Map.Entry<String, String> entry : contacts.entrySet()) {
//       pairs[index++] = entry.getKey() + " - " + entry.getValue();
//     }
//
//     return pairs;
//   }
//
//   public String[] getAllPhones() {
//     return contacts.keySet().toArray(new String[0]);
//   }
//
//   public String[] getAllNames() {
//     return nameToPhone.keySet().toArray(new String[0]);
//   }
//
//   public String[] getNamesByPrefix(String prefix) {
//     if (prefix == null) {
//       throw new IllegalArgumentException("Префикс не может быть null");
//     }
//
//     List<String> matchingNames = new ArrayList<>();
//
//     for (String name : nameToPhone.keySet()) {
//       if (name.startsWith(prefix)) {
//         matchingNames.add(name);
//       }
//     }
//
//     return matchingNames.toArray(new String[0]);
//   }
//
//   @Override
//   public String toString() {
//     if (contacts.isEmpty()) {
//       return "Телефонный справочник пуст";
//     }
//
//     StringBuilder sb = new StringBuilder();
//     sb.append("Телефонный справочник (").append(contacts.size()).append(" контактов):\n");
//
//     int counter = 1;
//     for (Map.Entry<String, String> entry : contacts.entrySet()) {
//       sb.append(counter).append(". ").append(entry.getKey())
//               .append(" - ").append(entry.getValue()).append("\n");
//       counter++;
//     }
//
//     return sb.toString();
//   }
// }
//FIXTO:
public class PhoneBook {
    private Map<String, String> contacts;
    private Map<String, String> name_To_Phone;

    public PhoneBook() {
        this.contacts = new HashMap<>();
        this.name_To_Phone = new HashMap<>();
    }

    public String AddContact(String phone, String name) {
        if (phone == null || name == null) {
            throw new IllegalArgumentException("Телефон и имя не могут быть null");
        }

        String old_Phone = null;

        if (name_To_Phone.containsKey(name)) {
            old_Phone = name_To_Phone.get(name);
            contacts.remove(old_Phone);
        }

        if (contacts.containsKey(phone)) {
            String old_Name = contacts.get(phone);
            name_To_Phone.remove(old_Name);
        }

        contacts.put(phone, name);
        name_To_Phone.put(name, phone);

        return old_Phone;
    }

    public boolean RemoveContactByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }

        if (name_To_Phone.containsKey(name)) {
            String phone = name_To_Phone.get(name);
            name_To_Phone.remove(name);
            contacts.remove(phone);
            return true;
        }
        return false;
    }

    public String GetPhoneByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
        return name_To_Phone.get(name);
    }

    public boolean ContainsName(String name) {
        return name_To_Phone.containsKey(name);
    }

    public boolean ContainsPhone(String phone) {
        return contacts.containsKey(phone);
    }

    public int GetContactCount() {
        return contacts.size();
    }

    public String[] GetAllPairs() {
        String[] pairs = new String[contacts.size()];
        int index = 0;

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            pairs[index++] = entry.getKey() + " - " + entry.getValue();
        }

        return pairs;
    }

    public String[] GetAllPhones() {
        return contacts.keySet().toArray(new String[0]);
    }

    public String[] GetAllNames() {
        return name_To_Phone.keySet().toArray(new String[0]);
    }

    public String[] GetNamesByPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Префикс не может быть null");
        }

        List<String> matching_Names = new ArrayList<>();

        for (String name : name_To_Phone.keySet()) {
            if (name.startsWith(prefix)) {
                matching_Names.add(name);
            }
        }

        return matching_Names.toArray(new String[0]);
    }

    @Override
    public String toString() {
        if (contacts.isEmpty()) {
            return "Телефонный справочник пуст";
        }

        StringBuilder string_Builder = new StringBuilder();
        string_Builder.append("Телефонный справочник (").append(contacts.size()).append(" контактов):\n");

        int counter = 1;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            string_Builder.append(counter).append(". ").append(entry.getKey())
                    .append(" - ").append(entry.getValue()).append("\n");
            counter++;
        }

        return string_Builder.toString();
    }
}
