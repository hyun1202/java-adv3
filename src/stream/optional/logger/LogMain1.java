package stream.optional.logger;

public class LogMain1 {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true);
        logger.debug(10+20);
        System.out.println("== 디버그 모드 off ==");
        logger.setDebug(false);
        // debug 모드가 꺼져있기 때문에 출력되지는 않지만 계산된 후에 버려지게 된다.
        logger.debug(10+20);

    }
}
