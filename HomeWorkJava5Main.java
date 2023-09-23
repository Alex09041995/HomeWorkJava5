import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class HomeWorkJava5Main {  // Создали класс
    private HashMap<String, List<String>> phoneBook;
    public HomeWorkJava5Main() {
    phoneBook = new HashMap<>();
    }

public void addContact(String lastName, String phoneNumber) {
if (phoneBook.containsKey(lastName)) {
List<String> numbers = phoneBook.get(lastName);
numbers.add(phoneNumber);
} else {
List<String> numbers = new ArrayList<>();
numbers.add(phoneNumber);
phoneBook.put(lastName, numbers);
}
}
public List<String> getPhoneNumbers(String lastName) {
return phoneBook.get(lastName);
}

public static void main(String[] args) {  // Назначили точку входа
    TelephoneDirectory TelephoneDirectory = new TelephoneDirectory();
    try (Scanner Scanner = new Scanner(System.in)) {
        while (true) {
            System.out.println("Введите необходимую команду: ");
            String command = Scanner.nextLine();
            if (command.startsWith("ADD")) {
                String[] parts = command.split(" ");
                if (parts.length != 3) {
                System.out.println("Неизвестный формат команды ADD"); 
                continue;
                }

            String lastName = parts[1];
            String phoneNumber = parts[2];
            TelephoneDirectory.add(lastName, phoneNumber);
            System.out.println("Контакт добавлен в телефонный справочник");
            } else if (command.startsWith("GET")) {
            String[] parts = command.split(" ");
            if (parts.length != 2) {
            System.out.println("Неизвестный формат команды GET");
            continue;
            }
            String lastName = parts[1];
            List < String> numbers = TelephoneDirectory.get(lastName);
            if (numbers != null) {
                for (String number : numbers) {
                System.out.println(number);
            }
            } else {
                System.out.println("Номера: " + numbers);
            }       
            } else if (command.startsWith("REMOVE")) {
            String[] parts = command.split(" ");
            if (parts.length != 2) {
                System.out.println("Неизвестный формат команды REMOVE");
            continue;
            }
            String lastName = parts[1];
            TelephoneDirectory.remove(lastName);
            System.out.println("Контакт удален из телефонного справочника");
            } else if (command.equals("LIST")) {
                TelephoneDirectory.list();
            } else if (command.equals("EXIT")) {
                break;
            } else {
                System.out.println("Вы ввели неверную команду!");
            }           
        }
    }
}
}













