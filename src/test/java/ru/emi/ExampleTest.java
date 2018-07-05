package ru.emi;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Example e = new Example();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void fizzBuzzTest() {
        String expectedOut = String.format("1%1$sTwo%1$s3%1$sTwo%1$s5%1$sTwo%1$sSeven%1$sTwo%1$s9%1$sTwo%1$s11%1$sTwo" +
                "%1$s13%1$sTwoSeven%1$s15%1$sTwo%1$s17%1$sTwo%1$s19%1$sTwo%1$sSeven%1$sTwo%1$s23%1$sTwo%1$s25%1$sTwo" +
                "%1$s27%1$sTwoSeven%1$s29%1$sTwo%1$s31%1$sTwo%1$s33%1$sTwo%1$sSeven%1$sTwo%1$s37%1$sTwo%1$s39%1$sTwo" +
                "%1$s41%1$sTwoSeven%1$s43%1$sTwo%1$s45%1$sTwo%1$s47%1$sTwo%1$sSeven%1$sTwo%1$s51%1$sTwo%1$s53%1$sTwo" +
                "%1$s55%1$sTwoSeven%1$s57%1$sTwo%1$s59%1$sTwo%1$s61%1$sTwo%1$sSeven%1$sTwo%1$s65%1$sTwo%1$s67%1$sTwo" +
                "%1$s69%1$sTwoSeven%1$s71%1$sTwo%1$s73%1$sTwo%1$s75%1$sTwo%1$sSeven%1$sTwo%1$s79%1$sTwo%1$s81%1$sTwo" +
                "%1$s83%1$sTwoSeven%1$s85%1$sTwo%1$s87%1$sTwo%1$s89%1$sTwo%1$sSeven%1$sTwo%1$s93%1$sTwo%1$s95%1$sTwo" +
                "%1$s97%1$sTwoSeven%1$s99%1$sTwo%1$s", System.lineSeparator());

        e.fizzBuzz();

        assertThat(outContent.toString(), is(expectedOut));
    }

    @Test
    public void functionTest() {
        int m = 7;
        int r = 3;

        long expectedValue1 = CombinatoricsUtils.factorial(m);
        long expectedValue2 = CombinatoricsUtils.factorial(r);
        long expectedValue3 = CombinatoricsUtils.factorial(m) /
                (CombinatoricsUtils.factorial(r) * CombinatoricsUtils.factorial(m - r));

        long result1 = e.factorial(m);
        long result2 = e.factorial(r);
        long result3 = e.function(m, r);

        assertThat(expectedValue1, is(5040L));  // 7! = 5040
        assertThat(expectedValue2, is(6L));     // 3! = 6

        assertThat(result1, is(expectedValue1));
        assertThat(result2, is(expectedValue2));
        assertThat(result3, is(expectedValue3));
    }

    @Test
    public void countTheWordsTest() {
        String expectedOut = String.format("{b=5, a=4, c=3}%s", System.lineSeparator());

        e.countTheWords("a a a b ,./+*%$^&#@! b c a b b b c c");

        assertThat(outContent.toString(), is(expectedOut));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}