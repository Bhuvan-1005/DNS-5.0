public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second message");

        System.out.println(logger1 == logger2);
        System.out.println(logger1.getLog());

        logger1.clear();
        System.out.println(logger1.getLog().isEmpty());
    }
}
