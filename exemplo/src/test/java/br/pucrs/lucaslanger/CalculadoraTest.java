package br.pucrs.lucaslanger;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculadoraTest {
    @Test
    public void testNextDateRegularDay() {
        Calculadora calculadora = new Calculadora();
        LocalDate date = LocalDate.of(2024, 6, 6);
        LocalDate expected = LocalDate.of(2024, 6, 7);
        assertEquals(expected, calculadora.nextDate(date));
    }

    @Test
    public void testNextDateEndOfMonth() {
        Calculadora calculadora = new Calculadora();
        LocalDate date = LocalDate.of(2024, 1, 31);
        LocalDate expected = LocalDate.of(2024, 2, 1);
        assertEquals(expected, calculadora.nextDate(date));
    }

    @Test
    public void testNextDateEndOfYear() {
        Calculadora calculadora = new Calculadora();
        LocalDate date = LocalDate.of(2023, 12, 31);
        LocalDate expected = LocalDate.of(2024, 1, 1);
        assertEquals(expected, calculadora.nextDate(date));
    }

    @Test
    public void testNextDateLeapYear() {
        Calculadora calculadora = new Calculadora();
        LocalDate date = LocalDate.of(2024, 2, 28);
        LocalDate expected = LocalDate.of(2024, 2, 29);
        assertEquals(expected, calculadora.nextDate(date));
    }

    @Test
    public void testNextDateNonLeapYear() {
        Calculadora calculadora = new Calculadora();
        LocalDate date = LocalDate.of(2023, 2, 28);
        LocalDate expected = LocalDate.of(2023, 3, 1);
        assertEquals(expected, calculadora.nextDate(date));
    }

    @Test
    public void testValidateDateCorrect() {
        Calculadora calculadora = new Calculadora();
        String dateStr = "11/08/2024";
        assertNull(calculadora.validateDate(dateStr));
    }

    @Test
    public void testValidateDateIncorrectLength() {
        Calculadora calculadora = new Calculadora();
        String dateStr = "20/6/2024";
        assertEquals("ERRO: tamanho invalido.", calculadora.validateDate(dateStr));
    }

    @Test
    public void testValidateDateNoDigit() {
        Calculadora calculadora = new Calculadora();
        String dateStr = "ab/cd/efgh";
        assertEquals("ERRO: nao utilizou digito.", calculadora.validateDate(dateStr));
    }

    @Test
    public void testValidateDateNoSlash() {
        Calculadora calculadora = new Calculadora();
        String dateStr = "2300220022";
        assertEquals("ERRO: nao utilizou '/'.", calculadora.validateDate(dateStr));
    }

    @Test
    public void testValidateDateInvalid() {
        Calculadora calculadora = new Calculadora();
        String dateStr = "32/05/2019";
        assertEquals("ERRO: data invalida.", calculadora.validateDate(dateStr));
    }
}
