package lambda.ex2;

public class ComposeExample {
    static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return s -> f2.transform(f1.transform(s));
    }

    public static void main(String[] args) {
        MyTransformer f1 = s -> s.toUpperCase();
        MyTransformer f2 = s -> "**" + s + "**";

        MyTransformer result = compose(f1, f2);
        System.out.println("result = " + result.transform("hello"));
    }
}
