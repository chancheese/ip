/**
 * Parser interprets user input and identifies commands.
 * Recognizes commands: "list", "bye", "mark", "unmark", and task additions.
 */
public class Parser {
    /**
     * Parses the user input and returns the command type.
     * Extracts the first word as the command.
     *
     * @param input the user's input string
     * @return the command type: "list", "bye", "mark", "unmark", or "add"
     */
    public String getCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        if (command.equals("list") || command.equals("bye") ||
            command.equals("mark") || command.equals("unmark")) {
            return command;
        }
        return "add";
    }

    /**
     * Extracts the task index from a mark/unmark command.
     * For "mark 1", this returns "1".
     *
     * @param input the user's input string
     * @return the task index as a string, or empty if no index found
     */
    public String getTaskIndex(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length > 1) {
            return parts[1].trim();
        }
        return "";
    }

    /**
     * Extracts the task description from an "add" command.
     * For "add Buy groceries" or just "Buy groceries", returns the task text.
     *
     * @param input the user's input string
     * @return the task description
     */
    public String getTaskContent(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length > 1 && parts[0].toLowerCase().equals("add")) {
            return parts[1].trim();
        }
        return input;
    }
}