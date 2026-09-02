/**
 * Event represents a task that starts at a specific date/time and ends at another.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Constructs an Event with the given name, start time, and end time.
     *
     * @param name the task description
     * @param from the start date/time as a string
     * @param to the end date/time as a string
     */
    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start time.
     *
     * @return the start date/time string
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the end time.
     *
     * @return the end date/time string
     */
    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
