package inerfaces;

import exceptions.PersistException;

import java.io.IOException;

public interface DaoFactoryInterface<Context> {
    public interface DaoCreator<Context>{
        public GenericDao create(Context context);
    }
    public Context getContext() throws PersistException,IOException;
    public GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
