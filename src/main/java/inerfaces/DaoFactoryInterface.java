package inerfaces;

public interface DaoFactoryInterface<Context> {
    public interface DaoCreator<Context>{
        public GenericDao create(Context context);
    }
    public Context getContext();
    public GenericDao getDao(Context context, Class dtoClass);
}
