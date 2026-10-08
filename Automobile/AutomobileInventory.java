import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AutomobileInventory {
    private static final Path OUTPUT_FILE = Paths.get("C:\\Temp\\Autos.txt");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Automobile automobile = new Automobile("Toyota", "Camry", "Blue", 2020, 35000);

            System.out.println("Initial vehicle information:");
            printVehicleInformation(automobile.listVehicleInformation());

            System.out.println(automobile.removeVehicle());

            System.out.println("\nEnter the new vehicle information:");
            String make = readText(scanner, "Make: ");
            String model = readText(scanner, "Model: ");
            String color = readText(scanner, "Color: ");
            int year = readInteger(scanner, "Year: ");
            int mileage = readInteger(scanner, "Mileage: ");

            System.out.println(automobile.addNewVehicle(make, model, color, year, mileage));
            System.out.println("\nNew vehicle information:");
            String[] vehicleInformation = automobile.listVehicleInformation();
            printVehicleInformation(vehicleInformation);

            System.out.println("\nEnter the updated vehicle information:");
            make = readText(scanner, "Make: ");
            model = readText(scanner, "Model: ");
            color = readText(scanner, "Color: ");
            year = readInteger(scanner, "Year: ");
            mileage = readInteger(scanner, "Mileage: ");

            System.out.println(automobile.updateVehicleAttributes(make, model, color, year, mileage));
            System.out.println("\nUpdated vehicle information:");
            vehicleInformation = automobile.listVehicleInformation();
            printVehicleInformation(vehicleInformation);

            System.out.print("\nWould you like to print the information to a file? (Y or N): ");
            String response = scanner.nextLine().trim();
            if ("Y".equalsIgnoreCase(response)) {
                System.out.println(printVehicleInformationToFile(vehicleInformation));
            } else if ("N".equalsIgnoreCase(response)) {
                System.out.println("A file will not be printed.");
            } else {
                System.out.println("Invalid response. A file will not be printed.");
            }
        } catch (RuntimeException e) {
            System.out.println("Unable to complete the inventory program: " + e.getMessage());
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        try {
            System.out.print(prompt);
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Failed to read vehicle information: " + e.getMessage(), e);
        }
    }

    private static int readInteger(Scanner scanner, String prompt) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to read a valid integer for " + prompt.trim(), e);
        }
    }

    private static void printVehicleInformation(String[] vehicleInformation) {
        try {
            for (String detail : vehicleInformation) {
                System.out.println(detail);
            }
        } catch (RuntimeException e) {
            throw new IllegalStateException("Failed to print vehicle information: " + e.getMessage(), e);
        }
    }

    private static String printVehicleInformationToFile(String[] vehicleInformation) {
        try {
            Files.createDirectories(OUTPUT_FILE.getParent());
            Files.write(OUTPUT_FILE, Arrays.asList(vehicleInformation), StandardCharsets.UTF_8);
            return "Vehicle information was written to " + OUTPUT_FILE + ".";
        } catch (IOException e) {
            return "Failed to write vehicle information to " + OUTPUT_FILE + ": " + e.getMessage();
        } catch (RuntimeException e) {
            return "Failed to write vehicle information to file: " + e.getMessage();
        }
    }
}
