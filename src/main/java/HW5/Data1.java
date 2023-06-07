package HW5;
import java.util.HashMap;

public class Data1 {
 //Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.

    public static void main(final String[] args) {
        var dict = new HashMap<String, String>();
        dict.put("1122333", "Смирнов");
        dict.put("1662333", "Курицин");
        dict.put("1112333", "Курицин");
        dict.put("1122432", "Антонов");
        dict.put("1112453", "Потапов");
        dict.put("1632145", "Потапов");
        dict.put("1424214", "Курицин");
        dict.put("1424215", "Курицин");
        dict.put("1424216", "Курицин");
        dict.put("1234374", "Антонов");

        var a = get(dict);

        a.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }


    public static HashMap<String, Integer> get(HashMap<String, String> dict){
        var result = new HashMap<String, Integer>();
        for (var item : dict.entrySet()) {
            if (result.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = result.get(item.getValue());
                result.replace(key, value + 1);
            } else {
                result.put(item.getValue(), 1);
            }
        }
        return result;
    }
}