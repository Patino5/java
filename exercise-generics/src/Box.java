public class Box <T> {
    private T value;
    private T label;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T getName() {
        return label;
    }

    public void setName(T name) {
        this.label = name;
    }
}
