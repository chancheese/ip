import java.util.Scanner;

/**
 * Chre is a simple chatbot that greets the user, waits for input, and exits with a farewell message.
 * This is a Level-0 implementation demonstrating basic user interaction.
 */
public class Chre {
    /**
     * Main entry point for the Chre chatbot application.
     * Displays a greeting banner, prompts the user for input, and displays a farewell message.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        String banner = " _____ _               \n"
                + "/ ____| |              \n"
                + "| |    | |__  _ __ ___ \n"
                + "| |    | '_ \\| '__/ _ \\\n"
                + "| |____| | | | | |  __/\n"
                + " \\_____|_| |_|_|  \\___|";

        String separator = "____________________________________________________________";

        System.out.println(separator);
        System.out.println(banner);
        System.out.println();
        System.out.println("Hello! I'm Chre.");
        System.out.println("What can I do for you?");
        System.out.println(separator);

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Main loop to continuously read and echo user commands until they type "bye"
        while (true) {
            // Read the command from the user
            userInput = scanner.nextLine();

            // Print the separator to show boundary
            System.out.println(separator);

            // Echo the command back to the user
            System.out.println(" " + userInput);

            // Print separator after the echoed command
            System.out.println(separator);

            // Check if user typed "bye", if so, exit the loop
            if (userInput.equals("bye")) {
                break;
            }
        }

        // Display farewell message when user exits with "bye"
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(separator);

        // Clean up resources
        scanner.close();
    }
}
