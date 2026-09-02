/**
 * Parser interprets user input and identifies commands.
 * Recognizes commands: "list", "bye", "mark", "unmark", "todo", "deadline", "event".
 */
public class Parser {
    /**
     * Parses the user input and returns the command type.
     * Extracts the first word as the command.
     *
     * @param input the user's input string
     * @return the command type: "list", "bye", "mark", "unmark", "todo", "deadline", "event"
     */
    public String getCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        if (command.equals("list") || command.equals("bye") ||
            command.equals("mark") || command.equals("unmark") ||
            command.equals("todo") || command.equals("deadline") ||
            command.equals("event")) {
            return command;
        }
        return "unknown";
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
     * Extracts the task name from a todo command.
     * For "todo borrow book", returns "borrow book".
     *
     * @param input the user's input string
     * @return the task name
     */
    public String getTodoName(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length > 1) {
            return parts[1].trim();
        }
        return "";
    }

    /**
     * Extracts the task name and deadline from a deadline command.
     * For "deadline return book /by Sunday", extracts both the name and deadline.
     *
     * @param input the user's input string
     * @return an array [name, deadline], or empty strings if parsing fails
     */
    public String[] getDeadlineInfo(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            return new String[]{"", ""};
        }

        String content = parts[1];
        String[] taskParts = content.split("/by", 2);

        if (taskParts.length != 2) {
            return new String[]{"", ""};
        }

        String name = taskParts[0].trim();
        String by = taskParts[1].trim();
        return new String[]{name, by};
    }

    /**
     * Extracts the task name, start time, and end time from an event command.
     * For "event project meeting /from Mon 2pm /to 4pm", extracts all three.
     *
     * @param input the user's input string
     * @return an array [name, from, to], or empty strings if parsing fails
     */
    public String[] getEventInfo(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            return new String[]{"", "", ""};
        }

        String content = parts[1];
        String[] nameAndRest = content.split("/from", 2);

        if (nameAndRest.length != 2) {
            return new String[]{"", "", ""};
        }

        String name = nameAndRest[0].trim();
        String[] timeInfo = nameAndRest[1].split("/to", 2);

        if (timeInfo.length != 2) {
            return new String[]{"", "", ""};
        }

        String from = timeInfo[0].trim();
        String to = timeInfo[1].trim();
        return new String[]{name, from, to};
    }
}