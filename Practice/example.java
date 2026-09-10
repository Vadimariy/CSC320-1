import java.util.Scanner;

public class WhileLoopExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = "";

        while (!password.equals("Java123")) {
            System.out.print("Enter your password: ");
            password = input.nextLine();
        }

        System.out.println("Correct password! Access granted.");
        input.close();
    }
}