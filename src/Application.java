import java.util.List;

public class Application {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> out= fizzBuzz.run(1, 100);
        System.out.println(out);
    }
}
