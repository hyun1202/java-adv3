package stream.optional;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    // 어플리케이션에서 로딩될 때 호출된다.
    static {
        map.put(1L, "Apple");
        map.put(2L, "Banana");
    }

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(3L);
    }

    static void findAndPrint(Long id) {
        String name = findNameById(id);
        // nullPointerException 유발
//        System.out.println("name = " + name.toUpperCase());
        if (name != null) {
            System.out.println("name = " + name.toUpperCase());
        } else {
            System.out.println("UNKNOWN");
        }
    }

    static String findNameById(Long id) {
        return map.get(id);
    }
}
