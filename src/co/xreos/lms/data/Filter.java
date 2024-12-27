package co.xreos.lms.data;

public interface Filter<T> {
    public boolean filter(T item);
}
