/**
 * Deadline represents a task that needs to be done by a specific date/time.
 */
public class Deadline extends Task {
    private String by;

    /**
     * Constructs a Deadline with the given name and deadline.
     *
     * @param name the task description
     * @param by the deadline as a string
     */
    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    /**
     * Returns the deadline.
     *
     * @return the deadline string
     */
    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
