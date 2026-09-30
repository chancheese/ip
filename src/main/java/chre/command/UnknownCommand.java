package chre.command;

import chre.data.TaskList;
import chre.ui.Ui;
import chre.storage.Storage;
import chre.exception.ChreException;

/**
 * Represents an unknown or invalid command.
 */
public class UnknownCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws ChreException {
        throw new ChreException("I'm not sure what you mean, but I'm here to help! You can use: list, todo, deadline, event, mark, unmark, delete, or bye.");
    }
}
