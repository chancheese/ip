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
     * Adds a new Todo to the list.
     *
     * @param name the todo description
     */
    public void addTodo(String name) {
        this.tasks.add(new Todo(name));
    }

    /**
     * Adds a new Deadline to the list.
     *
     * @param name the deadline description
     * @param by the deadline as a string
     */
    public void addDeadline(String name, String by) {
        this.tasks.add(new Deadline(name, by));
    }

    /**
     * Adds a new Event to the list.
     *
     * @param name the event description
     * @param from the start date/time
     * @param to the end date/time
     */
    public void addEvent(String name, String from, String to) {
        this.tasks.add(new Event(name, from, to));
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
        this.tasks.get(index - 1).setDone(true);
    }

    /**
     * Marks a task as not done by its 1-based index.
     *
     * @param index the 1-based index of the task to unmark
     */
    public void unmarkTaskDone(int index) {
        this.tasks.get(index - 1).setDone(false);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return the task count
     */
    public int size() {
        return this.tasks.size();
    }

    /**
     * Returns the last task added to the list.
     *
     * @return the most recently added task
     */
    public Task getLastTask() {
        return this.tasks.get(this.tasks.size() - 1);
    }
}