package JavaTPs;
public class Calculateur {
    public static void main(String[] args) {
    
        if (args.length != 3) {
            System.out.println("java Calculateur <nb1> <nb2> <opérateur>");
            return;
        }


        double nombre1, nombre2;
        String operateur;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
            operateur = args[2];
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres");
            return;
        }

     
        double resultat = 0;
        switch (operateur) {
            case "+":
                resultat = nombre1 + nombre2;
                break;
            case "-":
                resultat = nombre1 - nombre2;
                break;
            case "*":
                resultat = nombre1 * nombre2;
                break;
            default:
                System.out.println("oprateur non valide les opérateurs valides sont +, -, *.");
                return;
        }

       
        System.out.println("Rsultat : " + resultat);
    }
}
