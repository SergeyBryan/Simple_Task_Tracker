package objective;

public enum TaskType {
    PRIVATE(0),
    WORK(1);
    public final int type;

    TaskType(int type) {
        this.type = type;
    }
}
