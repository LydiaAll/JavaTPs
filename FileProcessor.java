package CoursJava;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileProcessor <chemin_dossier>");
            return;
        }

        File folder = new File(args[0]);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Le dossier spécifié est invalide.");
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".op")) {
                processFile(file);
            }
        }
    }

    private static void processFile(File inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            File outputFile = new File(inputFile.getParent(), inputFile.getName().replace(".op", ".res"));
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length != 3) {
                        writer.write("ERROR: Opération mal formée - " + line);
                        writer.newLine();
                        continue;
                    }

                    try {
                        double operand1 = Double.parseDouble(parts[0]);
                        double operand2 = Double.parseDouble(parts[1]);
                        String operator = parts[2];

                        double result;
                        switch (operator) {
                            case "+":
                                result = operand1 + operand2;
                                break;
                            case "-":
                                result = operand1 - operand2;
                                break;
                            case "*":
                                result = operand1 * operand2;
                                break;
                            default:
                                throw new UnsupportedOperationException("Opérateur non supporté: " + operator);
                        }
                        writer.write(String.valueOf(result));
                    } catch (NumberFormatException e) {
                        writer.write("ERROR: L'un des opérandes n'est pas un nombre valide - " + line);
                    } catch (UnsupportedOperationException e) {
                        writer.write("ERROR: Opérateur non supporté - " + line);
                    }
                    writer.newLine();
                }
            }
            System.out.println("Le traitement du fichier " + inputFile.getName() + " est terminé.");
        } catch (IOException e) {
            System.out.println("Erreur lors du traitement du fichier " + inputFile.getName() + ": " + e.getMessage());
        }
    }
}
