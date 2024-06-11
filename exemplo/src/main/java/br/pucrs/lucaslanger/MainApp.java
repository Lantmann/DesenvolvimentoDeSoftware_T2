package br.pucrs.lucaslanger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        
        System.out.println("Digite a data no formato: dd/mm/yyyy:");
        String input = scanner.nextLine();
        
        Calculadora calculadora = new Calculadora();
        String validationError = calculadora.validateDate(input);
        
        if (validationError != null) {
            System.out.println(validationError);
        } else {
            LocalDate date = LocalDate.parse(input, formatter);
            LocalDate nextDate = calculadora.nextDate(date);
            System.out.println("Data seguinte: " + nextDate.format(formatter));
        }
    }
}
