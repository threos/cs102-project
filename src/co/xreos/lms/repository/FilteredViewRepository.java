package co.xreos.lms.repository;

import co.xreos.lms.data.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilteredViewRepository<T> extends IRepository<T> {
    private IRepository<T> repository;
    private Filter<T> filter;
    private List<T> data = new ArrayList<>();

    public FilteredViewRepository(IRepository<T> repository, Filter<T> filter) {
        this.repository = repository;
        this.filter = filter;
        this.repository.addListener(this::sync);
        sync();
    }

    void sync() {
        System.out.println("Syncing");
        mutationContract(() -> {
            data.clear();
            data.addAll(repository.getAll().stream().filter(filter::filter).toList());
            return null;
        });
    }

    @Override
    public T add(T entity) {
        return repository.add(entity);
    }

    @Override
    public List<T> addAll(List<T> entities) {
        return repository.addAll(entities);
    }

    @Override
    public T update(T entity) {
        return repository.update(entity);
    }

    @Override
    public T delete(T entity) {
        return repository.delete(entity);
    }

    @Override
    public List<T> getAll() {
        return data;
    }
}

