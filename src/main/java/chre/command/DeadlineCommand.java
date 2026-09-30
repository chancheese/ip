package chre.command;

import chre.data.TaskList;
import chre.ui.Ui;
import chre.storage.Storage;
import chre.exception.ChreException;

/**
 * Adds a deadline task to the task list.
 */
public class DeadlineCommand extends Command {
    private String name;
    private String by;

    /**
     * Creates a DeadlineCommand with the given task name and deadline.
     *
     * @param name the name of the deadline task
     * @param by the deadline
     */
    public DeadlineCommand(String name, String by) {
        this.name = name;
        this.by = by;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws ChreException {
        taskList.addDeadline(name, by);
        ui.showTaskAdded(taskList.getLastTask(), taskList.size());
        storage.save(taskList.getTasks());
    }
}
