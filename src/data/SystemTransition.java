package data;

/**
 * Created by XJ on 13-12-30.
 */
public class SystemTransition {
    private SystemState from;
    private SystemState to;
    private SystemCondition condition;

    @Override
    public String toString() {
        return from.toString() + " -> " + to.toString() + " on " + condition.toString();
    }

    public SystemState getFrom() {
        return from;
    }

    public void setFrom(SystemState from) {
        this.from = from;
    }

    public SystemState getTo() {
        return to;
    }

    public void setTo(SystemState to) {
        this.to = to;
    }

    public SystemCondition getCondition() {
        return condition;
    }

    public void setCondition(SystemCondition condition) {
        this.condition = condition;
    }
}
