public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance. Singleton works!");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
} 