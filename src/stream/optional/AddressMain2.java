package stream.optional;

import stream.optional.model.Address;
import stream.optional.model.User;

import java.util.Optional;

// Optional을 사용하지 않으면 null 체크를 계속 해야한다.
public class AddressMain2 {
    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        Optional<String> userStreetOpt = getUserStreet(user);
        userStreetOpt.ifPresentOrElse(
                System.out::println,    // 값이 있을 때
                () -> System.out.println("userStreetOpt is empty")  // 값이 없을 때
        );
    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getStreet);
        // map 체이닝 중간에 null이면 Optional.empty()를 반환
    }
}
