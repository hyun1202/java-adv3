package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("Java");
        list1.add("Lambda");

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Hello");
        list2.add("Java");
        list2.add("Lambda");

        System.out.println("before list2 = " + list2);
        List<String> newList2 = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("after newList2 = " + newList2);
    }

    // 원본 리스트를 변경함 -> 부수 효과
    private static void changeList1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + "_complete");
        }
    }

    // 원본 리스트를 변경하지 않음 -> 함수형 프로그램에서 사용
    private static List<String> changeList2(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(i, list.get(i) + "_complete");
        }
        return newList;
    }
}
