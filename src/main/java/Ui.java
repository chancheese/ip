import java.util.Scanner;
import java.util.List;

/**
 * Ui handles all user interface interactions.
 * Manages input reading and output display.
 */
public class Ui {
    private Scanner scanner;
    private String separator;
    private String banner;

    /**
     * Constructs a Ui object and initializes the scanner and display elements.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
        this.separator = "____________________________________________________________";
        this.banner = " _____ _               \n"
                + "/ ____| |              \n"
                + "| |    | |__  _ __ ___ \n"
                + "| |    | '_ \\| '__/ _ \\\n"
                + "| |____| | | | | |  __/\n"
                + " \\_____|_| |_|_|  \\___|";
    }

    /**
     * Displays the welcome message and banner.
     */
    public void displayWelcome() {
        System.out.println(separator);
        System.out.println(banner);
        System.out.println();
        System.out.println("Hello! I'm Chre.");
        System.out.println("What can I do for you?");
        System.out.println(separator);
    }

    /**
     * Displays the farewell message.
     */
    public void displayFarewell() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(separator);
    }

    /**
     * Reads a command from the user.
     *
     * @return the user's input
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays all tasks in the list with 1-based numbering.
     *
     * @param tasks the list of tasks to display
     */
    public void showTasks(List<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Displays a confirmation message when a task is added.
     *
     * @param task the task that was added
     */
    public void showTaskAdded(String task) {
        System.out.println("added: " + task);
    }

    /**
     * Displays the separator line.
     */
    public void showSeparator() {
        System.out.println(separator);
    }

    /**
     * Closes the scanner resource.
     */
    public void close() {
        scanner.close();
    }
}