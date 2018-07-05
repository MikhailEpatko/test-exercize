package ru.emi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Example {

    /*
    Написать программу, которая выводит числа от 1 до 100, но вместо чисел кратных 2 нужно выводить строку Two,
    вместо чисел кратных 7 - строку Seven, вместо чисел кратных 2 и 7 - строку TwoSeven.
     */
    public void fizzBuzz() {
        Stream<String> str = IntStream.rangeClosed(1, 100).mapToObj(i ->
        i % 2 == 0 && i % 7 == 0 ? "TwoSeven" :
                i % 2 == 0 ? "Two" :
                        i % 7 == 0 ? "Seven" :
                                Integer.toString(i));
        str.forEach( System.out::println);
    }

    /*
    Написать программу, вычисляющую для любых натуральных m и r, таких что r ≤ m, значение функции
    f(m,r)=m!/r!(m-r)!
     */
    public long function(int m, int r) {
        if (r <= m) {
            return factorial(m) / (factorial(r) * factorial(m - r));
        } else {
            throw  new IllegalArgumentException("'r' must to be less or equal 'm'!");
        }
    }

    public long factorial(int number) {
        return LongStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
    }

    /*
    На вход программе подается литературный текст. Программа должна вывести список слов, встречающихся в тексте,
    в котором для каждого слова указывается количество вхождений этого слова в текст, а слова выводятся в порядке
    убывания частоты вхождения.
     */
    public void countTheWords(String text) {
        Map<String, Long> map = Arrays.stream(text.replaceAll("\\p{Punct}", "").split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                                          Map.Entry::getValue,
                                          (v1, v2) -> {
                                                        throw new IllegalStateException();
                                          },
                                          LinkedHashMap::new));
        System.out.println(map);
    }
}