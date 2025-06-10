package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static List<String> map(List<String> list, StringFunction function) {
        ArrayList<String> result = new ArrayList<>();

        for (String s : list) {
            String str = function.apply(s);
            result.add(str);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");
        System.out.println("원본 list = " + list);
        List<String> upper = map(list, s -> s.toUpperCase());
        List<String> decorate = map(list, s -> "***" + s + "***");

        System.out.println("upper = " + upper);
        System.out.println("decorate = " + decorate);
    }

}


