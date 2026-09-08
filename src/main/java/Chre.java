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
            try {
                String userInput = ui.readCommand();
                ui.showSeparator();

                String command = parser.getCommand(userInput);

                if (command.equals("list")) {
                    ui.showTasks(taskList.getTasks());
                } else if (command.equals("bye")) {
                    isRunning = false;
                } else if (command.equals("mark")) {
                    if (taskList.size() == 0) {
                        throw new ChreException("You don't have any tasks yet! Would you like to add one?");
                    }
                    int index = Integer.parseInt(parser.getTaskIndex(userInput));
                    if (index <= 0 || index > taskList.size()) {
                        throw new ChreException("I couldn't find that task. Could you check the task number and try again?");
                    }
                    taskList.markTaskDone(index);
                    ui.showTaskMarked(taskList.getTasks().get(index - 1));
                } else if (command.equals("unmark")) {
                    if (taskList.size() == 0) {
                        throw new ChreException("You don't have any tasks yet! Would you like to add one?");
                    }
                    int index = Integer.parseInt(parser.getTaskIndex(userInput));
                    if (index <= 0 || index > taskList.size()) {
                        throw new ChreException("I couldn't find that task. Could you check the task number and try again?");
                    }
                    taskList.unmarkTaskDone(index);
                    ui.showTaskUnmarked(taskList.getTasks().get(index - 1));
                } else if (command.equals("todo")) {
                    String name = parser.getTodoName(userInput);
                    taskList.addTodo(name);
                    ui.showTaskAdded(taskList.getLastTask(), taskList.size());
                } else if (command.equals("deadline")) {
                    String[] info = parser.getDeadlineInfo(userInput);
                    taskList.addDeadline(info[0], info[1]);
                    ui.showTaskAdded(taskList.getLastTask(), taskList.size());
                } else if (command.equals("event")) {
                    String[] info = parser.getEventInfo(userInput);
                    taskList.addEvent(info[0], info[1], info[2]);
                    ui.showTaskAdded(taskList.getLastTask(), taskList.size());
                } else {
                    throw new ChreException("I'm not sure what you mean, but I'm here to help! You can use: list, todo, deadline, event, mark, unmark, or bye.");
                }

                ui.showSeparator();
            } catch (ChreException e) {
                ui.showError(e.getMessage());
                ui.showSeparator();
            }
        }

        ui.displayFarewell();
        ui.close();
    }
}
