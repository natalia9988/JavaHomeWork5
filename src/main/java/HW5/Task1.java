package HW5;
//Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    // Метод, который добавляет номера в книгу
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }

    // Метод, который печатает список контактов
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";

            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Курицин", 1122333, bookPhone);
        addNumber("Курицин", 1662333, bookPhone);
        addNumber("Курицин", 1112333, bookPhone);
        addNumber("Антонов", 1122432, bookPhone);
        addNumber("Потапов", 1112453, bookPhone);
        addNumber("Потапов", 1632145, bookPhone);
        printBook(bookPhone);
    }
}