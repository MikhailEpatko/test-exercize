package ru.emi;

public class Start {

    public static void main(String[] args) {

        Example e = new Example();

        System.out.println("FizzBuzz output: ");
        e.fizzBuzz();

        System.out.println("Function output (m = 7, r = 3): " + e.function(7, 3));

        System.out.print("Words counter output ( original text is \"a a a b ,./+*%$^&#@! b c a b b b c c\"): ");
        e.countTheWords("a a a b ,./+*%$^&#@! b c a b b b c c");
    }
}