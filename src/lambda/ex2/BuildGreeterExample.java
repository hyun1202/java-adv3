package lambda.ex2;

public class BuildGreeterExample {
    static StringFunction buildGreeter(String greeting) {
        return (str) -> greeting + ", " + str;
    }

    public static void main(String[] args) {
        StringFunction func1 = buildGreeter("Hello");
        System.out.println("result1 = " + func1.apply("Java"));
        System.out.println("result2 = " + func1.apply("Lambda"));
    }
}
