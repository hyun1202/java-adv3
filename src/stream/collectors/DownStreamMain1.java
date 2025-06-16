package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 학년별로 학생 그룹화
        // 다운스트림에서 toList() 생략 가능
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  // 그룹화 기준: 학년
                        Collectors.toList() // 다운스트림: 학생을 리스트로 수집
                ));
        System.out.println("collect1_1 = " + collect1);

        // 학년별로 학생들의 이름 출력
        Map<Integer, List<String>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade, // 그룹화 기준
                        Collectors.mapping(s -> s.getName(), // 다운스트림1: 학생 -> 이름 변환
                                           Collectors.toList()) // 다운스트림2: 변환된 이름을 List로 수집
                ));
        System.out.println("collect1_2 = " + collect2);

        // 학년별로 학생들의 수를 출력
        Map<Integer, Long> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
        System.out.println("collect3 = " + collect3);

        // 학년 별로 학생들의 평균 성적 출력
        Map<Integer, Double> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getScore)
                ));
        System.out.println("collect4 = " + collect4);
    }
}
