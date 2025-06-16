package stream.collectors;

public class Student {
    String name;
    int grade;
    int score;

    public Student(String name, int grade, int score) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade='" + grade + '\'' +
                '}';
    }
}
