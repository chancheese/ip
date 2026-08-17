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

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(separator);

        scanner.close();
    }
}
