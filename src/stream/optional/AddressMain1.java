package stream.optional;

import stream.optional.model.Address;
import stream.optional.model.User;

// Optional을 사용하지 않으면 null 체크를 계속 해야한다.
public class AddressMain1 {
    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        String userStreet = getUserStreet(user);
        if (userStreet != null) {
            System.out.println(userStreet);
        } else {
            System.out.println("userStreet is null");
        }
    }

    static String getUserStreet(User user) {
        if (user == null) {
            return null;
        }
        Address address = user.getAddress();
        if (address == null) {
            return null;
        }
        return address.getStreet();
    }
}
