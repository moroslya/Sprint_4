package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Step;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Test
    @DisplayName("Проверка метода валидации имени владельца карты")
    public void checkingCardholderNameValidationMethod() {

        checkingComplianceRequirementsOfStringWithName(name, expected);

    }

    @Step("Проверка соответствия требованиям строки: {userName}")
    public void checkingComplianceRequirementsOfStringWithName(String userName, boolean expectedResult) {

        Account account = new Account(userName);

        boolean actual = account.checkNameToEmboss();

        Assert.assertEquals(expectedResult, actual);

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                //19 символов в строке
                {"Георгий Сергиевский", true},
                //3 символа в строке
                {"А Б", true},
                //Меньше 3х символов (2 символа)
                {"Ив", false},
                //Больше 19 символов (20 символов)
                {"Иван Александровский", false},
                //Больше одного пробела
                {"Иван Иванов Иванович", false},
                //Пробел в начале
                {" Иванов", false},
                //Пробел в конце
                {"Иванов ", false},
                //Нет пробелов
                {"ИванИванов", false}
        };
    }

}
