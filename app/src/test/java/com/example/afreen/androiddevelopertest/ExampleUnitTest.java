package com.example.afreen.androiddevelopertest;

        import org.junit.Test;

        import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void foo() {
        String formattedNumber = TelephoneNumberAdapter.formatPhoneNumber("\n +44\n\n  1111111111");
        assertEquals("+44 (111) 111-1111", formattedNumber);

        formattedNumber = TelephoneNumberAdapter.formatPhoneNumber("          \n +44\n222   22   \n22222        ");
        assertEquals("+44 (222) 222-2222", formattedNumber);

        formattedNumber = TelephoneNumberAdapter.formatPhoneNumber("\n +44\n3333333333");
        assertEquals("+44 (333) 333-3333", formattedNumber);

    }
}