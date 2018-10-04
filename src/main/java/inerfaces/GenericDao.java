package inerfaces;

import com.mysql.jdbc.PacketTooBigException;
import exceptions.PersistException;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
    public T create(T entity) throws PersistException;
    public T persist(T entity)throws PersistException;
    public T getByID(Integer tN) throws PersistException;
    public void update(T entity)throws PersistException;
    public void delete(Integer id)throws PersistException;
    public  List<T> getAll() throws PersistException;
}
