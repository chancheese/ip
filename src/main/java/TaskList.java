import java.util.ArrayList;
import java.util.List;

/**
 * TaskList manages a collection of tasks.
 * Provides methods to add tasks and retrieve the complete list.
 */
public class TaskList {
    private ArrayList<String> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param task the task description to add
     */
    public void addTask(String task) {
        this.tasks.add(task);
    }

    /**
     * Returns all tasks in the list.
     *
     * @return a list of all task descriptions
     */
    public List<String> getTasks() {
        return this.tasks;
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