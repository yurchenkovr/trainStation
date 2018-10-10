package db.interfaces;

import db.dao_exception.PersistException;

import java.io.Serializable;
import java.util.LinkedList;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
    T create(T entity) throws PersistException;
    T persist(T entity)throws PersistException;
    T getByID(Integer tN) throws PersistException;
    void update(T entity)throws PersistException;
    void delete(Integer id)throws PersistException;
    LinkedList<T> getAll() throws PersistException;
    T getByUserName(String username)throws PersistException;
}
