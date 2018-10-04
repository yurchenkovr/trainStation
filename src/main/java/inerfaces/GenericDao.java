package inerfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
    public abstract List<T> getAll();
    public abstract T getByID(Integer tN);
    public abstract void update(T entity);
    public abstract void delete(Integer id);
    public abstract void create(T entity);
}
