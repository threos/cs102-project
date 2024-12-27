package co.xreos.lms.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class IRepository <T>  {
    List<Runnable> listeners = new ArrayList<>();

    abstract T add(T entity);
    abstract List<T> addAll(List<T> entities);
    abstract T update(T entity);
    abstract T delete(T entity);

    abstract List<T> getAll();

    public void addListener(Runnable listener) {
        listeners.add(listener);
    }

    public void removeListener(Runnable listener) {
        listeners.remove(listener);
    }

    void notifyListeners() {
        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    <E> E mutationContract(MutationRunnable<E> mutation) {
        E e = mutation.run();
        notifyListeners();
        return e;
    }
}

