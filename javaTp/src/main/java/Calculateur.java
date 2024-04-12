public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <numérique> <numérique> <opérateur>");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operator = args[2];

            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                default:
                    System.out.println("Opérateur non supporté.");
                    return;
            }

            System.out.println("Résultat : " + result);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers paramètres doivent être numériques.");
        }
    }
}

