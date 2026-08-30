/**
 * Chre is a simple chatbot that manages tasks.
 * Orchestrates the Ui, Parser, and TaskList components.
 */
public class Chre {
    /**
     * Main entry point for the Chre chatbot application.
     * Coordinates user input, task management, and output.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        Parser parser = new Parser();
        TaskList taskList = new TaskList();

        ui.displayWelcome();

        boolean isRunning = true;
        while (isRunning) {
            String userInput = ui.readCommand();
            ui.showSeparator();

            String command = parser.parse(userInput);

            if (command.equals("list")) {
                ui.showTasks(taskList.getTasks());
            } else if (command.equals("bye")) {
                isRunning = false;
            } else { // "add" command
                String task = parser.getTaskContent(userInput);
                taskList.addTask(task);
                ui.showTaskAdded(task);
            }

            ui.showSeparator();
        }

        ui.displayFarewell();
        ui.close();
    }
}
