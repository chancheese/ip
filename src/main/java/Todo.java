/**
 * Todo represents a task without any date/time attached.
 */
public class Todo extends Task {
    /**
     * Constructs a Todo with the given name.
     *
     * @param name the task description
     */
    public Todo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
