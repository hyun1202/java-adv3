package functional;

public class ImmutableMain1 {

    public static void main(String[] args) {
        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = m1;
        m2.setAge(11);
        System.out.println("m1 = " + m1);   // age가 11로 변경됨
        System.out.println("m2 = " + m2);

        ImmutablePerson i1 = new ImmutablePerson("Lee", 20);
        ImmutablePerson i2 = i1.withAge(21);    // 새로운 객체 생성
        System.out.println("i1 = " + i1);   // age가 변경되지 않음 , 새로운 객체이므로
        System.out.println("i2 = " + i2);
    }
}
