/**
 * Parser interprets user input and identifies commands.
 * Recognized commands: "list", "bye", and task additions (anything else).
 */
public class Parser {
    /**
     * Parses the user input and returns the command type.
     *
     * @param input the user's input string
     * @return the command type: "list", "bye", or "add"
     */
    public String parse(String input) {
        if (input.equals("list")) {
            return "list";
        } else if (input.equals("bye")) {
            return "bye";
        } else {
            return "add";
        }
    }

    /**
     * Extracts task content from the input.
     * For "add" commands, this returns the input as the task.
     *
     * @param input the user's input string
     * @return the task content
     */
    public String getTaskContent(String input) {
        return input;
    }
}