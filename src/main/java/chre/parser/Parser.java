package chre.parser;

import chre.exception.ChreException;

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
     * @return the task index as a string
     * @throws ChreException if the index is missing or invalid
     */
    public String getTaskIndex(String input) throws ChreException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            throw new ChreException("Which task would you like me to help with? Just tell me the task number!");
        }
        String index = parts[1].trim();
        if (index.isEmpty()) {
            throw new ChreException("Which task would you like me to help with? Just tell me the task number!");
        }
        try {
            Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new ChreException("The task number needs to be a number. Could you try again?");
        }
        return index;
    }

    /**
     * Extracts the task name from a todo command.
     * For "todo borrow book", returns "borrow book".
     *
     * @param input the user's input string
     * @return the task name
     * @throws ChreException if the todo description is empty
     */
    public String getTodoName(String input) throws ChreException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            throw new ChreException("Let me help you with that! Could you tell me what task you'd like to add?");
        }
        String name = parts[1].trim();
        if (name.isEmpty()) {
            throw new ChreException("Let me help you with that! Could you tell me what task you'd like to add?");
        }
        return name;
    }

    /**
     * Extracts the task name and deadline from a deadline command.
     * For "deadline return book /by Sunday", extracts both the name and deadline.
     *
     * @param input the user's input string
     * @return an array [name, deadline]
     * @throws ChreException if the description is empty or format is invalid
     */
    public String[] getDeadlineInfo(String input) throws ChreException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            throw new ChreException("I'd love to help you set a deadline! Could you tell me what task you need to complete?");
        }

        String content = parts[1];
        String[] taskParts = content.split("/by", 2);

        if (taskParts.length != 2) {
            throw new ChreException("Just to help you better, please format it like this: deadline <task> /by <date>");
        }

        String name = taskParts[0].trim();
        String by = taskParts[1].trim();

        if (name.isEmpty()) {
            throw new ChreException("I'd love to help you set a deadline! Could you tell me what task you need to complete?");
        }
        if (by.isEmpty()) {
            throw new ChreException("When do you need to finish this? Please add a deadline like this: deadline <task> /by <date>");
        }

        return new String[]{name, by};
    }

    /**
     * Extracts the task name, start time, and end time from an event command.
     * For "event project meeting /from Mon 2pm /to 4pm", extracts all three.
     *
     * @param input the user's input string
     * @return an array [name, from, to]
     * @throws ChreException if the description is empty or format is invalid
     */
    public String[] getEventInfo(String input) throws ChreException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            throw new ChreException("I'm here to help you keep track! What event would you like to add?");
        }

        String content = parts[1];
        String[] nameAndRest = content.split("/from", 2);

        if (nameAndRest.length != 2) {
            throw new ChreException("Let me help you organize this! Please format it like: event <name> /from <start> /to <end>");
        }

        String name = nameAndRest[0].trim();
        String[] timeInfo = nameAndRest[1].split("/to", 2);

        if (timeInfo.length != 2) {
            throw new ChreException("Let me help you organize this! Please format it like: event <name> /from <start> /to <end>");
        }

        String from = timeInfo[0].trim();
        String to = timeInfo[1].trim();

        if (name.isEmpty()) {
            throw new ChreException("I'm here to help you keep track! What event would you like to add?");
        }
        if (from.isEmpty()) {
            throw new ChreException("When does your event start? Please let me know the start time.");
        }
        if (to.isEmpty()) {
            throw new ChreException("When does your event end? Please let me know the end time.");
        }

        return new String[]{name, from, to};
    }
}
