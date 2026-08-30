import java.util.ArrayList;
import java.util.List;

/**
 * TaskList manages a collection of Task tasks.
 * Provides methods to add tasks and retrieve the complete list.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the list.
     *
     * @param description the task description to add
     */
    public void addTask(String description) {
        this.tasks.add(new Task(description));
    }

    /**
     * Returns all tasks in the list.
     *
     * @return a list of all tasks
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Marks a task as done by its 1-based index.
     *
     * @param index the 1-based index of the task to mark as done
     */
    public void markTaskDone(int index) {
        tasks.get(index - 1).setDone(true);
    }

    /**
     * Marks a task as not done by its 1-based index.
     *
     * @param index the 1-based index of the task to unmark
     */
    public void unmarkTaskDone(int index) {
        tasks.get(index - 1).setDone(false);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return the task count
     */
    public int size() {
        return this.tasks.size();
    }
}