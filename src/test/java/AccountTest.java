import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class AccountTest {

    private final String name;
    private final boolean expected;
    private final String message;

    public AccountTest(String name, boolean expected, String message) {

        this.name = name;
        this.expected = expected;
        this.message = message;

    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Я А", true, "Ошибка проверки минимальной длины корректной строки"}, //корректная строка, 3 символа
                {"Яна Высокополянская", true, "Ошибка проверки максимальной длины корректной строки"}, //корректная строка, 19 символов
                {"Ян", false, "Ошибка проверки минимальной длины корректной строки"}, //некорректная строка, 3 символа
                {"Яна Высокоостровская", false, "Ошибка проверки длины строки, количество символов больше допустимого"}, //некорректная строка, 20 символов
                {"ЯнаАбанина", false, "Ошибка проверки наличия пробела в строке"}, //некорректная строка без пробела
                {"Яна Аба нина", false, "Ошибка проверки отсутствия более одного пробела в строке"}, //некорректная строка с двумя пробелами
                {" Яна Абанина", false, "Ошибка проверки отсутствия пробела в начале строки"}, //некорректная строка с пробелом в начале
                {"Яна Абанина ", false, "Ошибка проверки отсутствия пробела в конце строки"}, //некорректная строка с пробелом в конце
                {null, false, "Ошибка проверки на null"} //null вместо строки
        };
    }

    @Test
    public void testCheckNameToEmboss() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(message, expected, actual);
        System.out.println(actual);
    }

}
