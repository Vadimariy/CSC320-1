import java.util.Scanner;

public class loop {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double total = 0;
			double maximum = 0;
			double minimum = 0;
			int count = 0;

			System.out.println("Enter five floating-point values:");

			while (count < 5) {
				System.out.print("Value " + (count + 1) + ": ");

				if (!scanner.hasNextDouble()) {
					System.out.println("Please enter a valid floating-point value.");
					scanner.next();
					continue;
				}

				double value = scanner.nextDouble();

				if (count == 0) {
					maximum = value;
					minimum = value;
				} else {
					maximum = Math.max(maximum, value);
					minimum = Math.min(minimum, value);
				}

				total += value;
				count++;
			}

			double average = total / 5;
			double interest = total * 0.20;

			System.out.printf("%nTotal: %.2f%n", total);
			System.out.printf("Average: %.2f%n", average);
			System.out.printf("Maximum: %.2f%n", maximum);
			System.out.printf("Minimum: %.2f%n", minimum);
			System.out.printf("Interest on total at 20%%: %.2f%n", interest);
		}
	}
}
