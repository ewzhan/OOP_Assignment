import java.util.*;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    // Validate non-empty string input
    public static String validateStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

   
    
    // Method to check if input is an integer
    public static boolean checkInt(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim(); // Get input as a string

        try {
            Integer.parseInt(input); // Try to parse the string to an integer
            return true; // Return true if parsing is successful
        } catch (NumberFormatException e) {
            return false; // Return false if the input is not a valid integer
        }
    }


    // Validate integer input within a specific range
    public static int validateIntegerInRange(String prompt, int min, int max) {
        int input;
        while (true) {
            input = validateIntegerInput(prompt);
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Input must be between " + min + " and " + max + ". Please try again.");
            }
        }
    }

    // Validate phone number (for simplicity, validate 10-digit phone numbers)
    public static String validatePhoneNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (Pattern.matches("\\d{10}", input)) { // Validating a 10-digit number
                return input;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit number.");
            }
        }
    }

    // Validate if input contains only letters (for names, etc.)
    public static String validateName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Invalid input. Name should only contain letters and spaces.");
            }
        }
    }

    // Validate yes/no input
    public static boolean validateYesNoInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = sc.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    // Validate product quantity input (positive integers)
    public static int validateQuantity(String prompt) {
        int quantity;
        while (true) {
            quantity = validateIntegerInput(prompt);
            if (quantity > 0) {
                return quantity;
            } else {
                System.out.println("Quantity must be a positive integer. Please try again.");
            }
        }
    }

    // Validate email address
    public static String validateEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (Pattern.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$", input)) {
                return input;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
    }



// Method to check if input is a valid string (contains only letters and spaces)
    public static boolean checkString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        
        // Regex to check if the input contains only letters and spaces
        return input.matches("[a-zA-Z\\s]+");
    }

    // Method to check if input is empty
    public static boolean checkEmpty(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        
        // Return true if the input is empty, otherwise false
        return input.isEmpty();
    }

    // Method to check if input contains symbols (characters other than letters, digits, and spaces)
    public static boolean checkSymbol(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        
        // Regex to check if the input contains any symbol (non-alphanumeric characters)
        return input.matches(".*[^a-zA-Z0-9\\s].*");
    }
}