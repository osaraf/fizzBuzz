import java.util.List;

public class Application {

    public static void main(String[] args) {
        int start = 1, end = 100;
        new FizzBuzz()
                // .addRule(7, "Bazz")
                .run(start, end, System.out::println);
    }
}
