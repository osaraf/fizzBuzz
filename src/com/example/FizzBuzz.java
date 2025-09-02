package com.example;

import java.util.*;
import java.util.function.Consumer;

public class FizzBuzz {

    private final Map<Integer, String> rules = new LinkedHashMap<>();

    public FizzBuzz() {
        // Default rules
        rules.put(3, "Fizz");
        rules.put(5, "Buzz");
    }

    public FizzBuzz  addRule(int divisor, String word) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor must not be zero");
        rules.put(divisor, Objects.requireNonNull(word, "word"));
        return this;
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

    // returns the outputs
    public List<String> run(int start, int end) {
        if (end < start) throw new IllegalArgumentException("end must be >= start");
        List<String> out = new ArrayList<>(end - start + 1);
        for (int i = start; i <= end; i++) out.add(evaluate(i));
        return out;
    }

    /**
     * Computes com.example.FizzBuzz for [start, end] and passes each line to the given sink.
     * Useful to print to console, write to a file, or log without changing core logic.
     */
    public void run(int start, int end, Consumer<String> sink) {
        for (String s : run(start, end)) {
            sink.accept(s);
        }
    }

    @Override
    public String toString() {
        return "com.example.FizzBuzz{" +
                "rules=" + rules +
                '}';
    }
}