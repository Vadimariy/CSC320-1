import java.util.ArrayList;
import java.util.Scanner;

public class weekly {
	public static void main(String[] args) {
            try (Scanner input = new Scanner(System.in)) {
                ArrayList<String> days = new ArrayList<>();
                ArrayList<Double> temperatures = new ArrayList<>();
                
                String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday",
                    "Friday", "Saturday", "Sunday"};
                
                for (String day : weekDays) {
                    days.add(day);
                    System.out.print("Enter the average temperature for " + day + ": ");
                    temperatures.add(input.nextDouble());
                }
                input.nextLine(); // Consume the remaining newline.
                
                System.out.print("Enter a day of the week, or 'week' for all days: ");
                String selection = input.nextLine().trim();
                boolean found = false;
                double total = 0;
                
                if (selection.equalsIgnoreCase("week")) {
                    for (int i = 0; i < days.size(); i++) {
                        System.out.println(days.get(i) + ": " + temperatures.get(i));
                        total += temperatures.get(i);
                    }
                    System.out.printf("Weekly average: %.2f%n", total / temperatures.size());
                } else {
                    for (int i = 0; i < days.size(); i++) {
                        if (days.get(i).equalsIgnoreCase(selection)) {
                            System.out.println(days.get(i) + ": " + temperatures.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid day.");
                    }
                }
            }
	}
}
