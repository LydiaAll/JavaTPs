package EXO04;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculateur {
    private static final Map<String, BinaryOperator<Double>> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", (a, b) -> a + b);
        OPERATORS.put("-", (a, b) -> a - b);
        OPERATORS.put("*", (a, b) -> a * b);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <numérique> <numérique> <opérateur>");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operator = args[2];

            BinaryOperator<Double> operation = OPERATORS.get(operator);

            if (operation == null) {
                System.out.println("Opérateur non supporté.");
                return;
            }

            double result = operation.apply(num1, num2);

            System.out.println("Résultat : " + result);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers paramètres doivent être numériques.");
        }
    }
}

