package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };
        // class.class = class lambda.lambda1.InstanceMain$1
        // class.instance = lambda.lambda1.InstanceMain$1@2a84aee7
        System.out.println("class.class = " + procedure1.getClass());
        System.out.println("class.instance = " + procedure1);

        Procedure procedure2 = () -> {
            System.out.println("Hello Lambda");
        };

        // class.class = class lambda.lambda1.InstanceMain$$Lambda/0x0000030001003780
        // class.instance = lambda.lambda1.InstanceMain$$Lambda/0x0000030001003780@30f39991
        System.out.println("class.class = " + procedure2.getClass());
        System.out.println("class.instance = " + procedure2);
    }
}
