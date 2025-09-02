import java.util.LinkedHashMap;
import java.util.Map;

public class FizzBuzz {

    private final Map<Integer, String> rules = new LinkedHashMap<>();

    public FizzBuzz() {
        // Default rules
        rules.put(3, "Fizz");
        rules.put(5, "Buzz");
    }

    public void addRule(int divisor, String word) {
        rules.put(divisor, word);
    }

    public String evaluate(int number) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : rules.entrySet()) {
            if (number % entry.getKey() == 0) {
                result.append(entry.getValue());
            }
        }

        return result.isEmpty() ? String.valueOf(number) : result.toString();
    }

    public void run(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(evaluate(i));
        }
    }

    @Override
    public String toString() {
        return "FizzBuzz{" +
                "rules=" + rules +
                '}';
    }
}