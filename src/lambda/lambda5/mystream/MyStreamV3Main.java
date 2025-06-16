package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV3Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<Student> result = ex1(students);
        System.out.println("result = " + result);


        List<String> result2 = ex2(students);
        System.out.println("result2 = " + result2);
    }


    private static List<Student> ex1(List<Student> students) {
        return MyStreamV3.of(students)
                .filter(student -> student.getScore() >= 80)
                .toList();
    }

    // 점수가 80점 이상이면서, 이름이 5글자인 학생 이름을 대문자로 추출
    private static List<String> ex2(List<Student> students) {
        return MyStreamV3.of(students)
                .filter(student -> student.getScore() >= 80 && student.getName().length() == 5)
                .map(student -> student.getName().toUpperCase())
                .toList();
    }
}
