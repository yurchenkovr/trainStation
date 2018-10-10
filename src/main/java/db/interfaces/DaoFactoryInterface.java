package db.interfaces;

import db.dao_exception.PersistException;

import java.io.IOException;

public interface DaoFactoryInterface<Context> {
    interface DaoCreator<Context> {
        GenericDao create(Context context);
    }

    Context getContext() throws PersistException, IOException;

    GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
