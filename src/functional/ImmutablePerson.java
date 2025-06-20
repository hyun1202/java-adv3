package functional;

public class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public ImmutablePerson withName(String name) {
        return new ImmutablePerson(name, age);
    }

    public int getAge() {
        return age;
    }

    public ImmutablePerson withAge(int age) {
        return new ImmutablePerson(name, age);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
