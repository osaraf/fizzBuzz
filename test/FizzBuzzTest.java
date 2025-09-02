import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;



class FizzBuzzTest {

    @Test
    void evaluate_classicBehavior() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("1", fb.evaluate(1));
        assertEquals("Fizz", fb.evaluate(3));
        assertEquals("Buzz", fb.evaluate(5));
        assertEquals("FizzBuzz", fb.evaluate(15));
    }

    @Test
    void run_returnsListInOrder() {
        FizzBuzz fb = new FizzBuzz();
        List<String> out = fb.run(1, 5);
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), out);
    }

    @Test
    void run_withConsumer_streamsLines() {
        FizzBuzz fb = new FizzBuzz();

        List<String> sink = new ArrayList<>();
        Consumer<String> collector = sink::add;

        // Implemented via your run(start,end, Consumer<String>) overload
        for (String s : fb.run(1, 5)) collector.accept(s);

        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), sink);
    }

    @Test
    void addRule_chainableAndComposed() {
        FizzBuzz fb = new FizzBuzz();
        // Expect addRule to return the same instance for chaining
        FizzBuzz same = fb.addRule(7, "Bazz");
        assertSame(fb, same, "addRule should be chainable (return this)");

        assertEquals("Bazz", fb.evaluate(7));
        assertEquals("FizzBazz", fb.evaluate(21));     // 3 * 7
        assertEquals("FizzBuzzBazz", fb.evaluate(105)); // 3 * 5 * 7
    }

    @Test
    void invalidRange_throws() {
        FizzBuzz fb = new FizzBuzz();
        assertThrows(IllegalArgumentException.class, () -> fb.run(10, 1));
    }

    @Test
    void zeroDivisor_addRuleThrows() {
        FizzBuzz fb = new FizzBuzz();
        assertThrows(IllegalArgumentException.class, () -> fb.addRule(0, "Nope"));
    }
}
