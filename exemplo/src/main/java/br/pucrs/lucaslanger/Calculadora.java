package br.pucrs.lucaslanger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Calculadora {

    public String validateDate(String dateStr) {
        // Verificação do tamanho
        if (dateStr.length() != 10) {
            return "ERRO: tamanho invalido.";
        }
        
        // Verificação do formato e barra "/"
        if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            if (!dateStr.contains("/")) {
                return "ERRO: nao utilizou '/'.";
            }
            return "ERRO: nao utilizou digito.";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            if (date.isBefore(LocalDate.of(1600, 1, 1)) || date.isAfter(LocalDate.of(9998, 12, 31))) {
                return "ERRO: data invalida.";
            }

        } catch (DateTimeParseException e) {
            return "ERRO: data invalida.";
        }

        return null;
    }

    public LocalDate nextDate(LocalDate currentDate) {
        return currentDate.plusDays(1);
    }
}
