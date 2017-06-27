package com.softserve.edu.dao;

public class DaoFactory {
    private static DaoFactory instance;
    private static final String DAO_CLASS_PATH = "com.softserve.edu.dao.";

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public ElementDAOImpl getDAO(Class entityClass) {
        ElementDAOImpl elementDAOImpl = null;
        try {
            String daoClassName = DAO_CLASS_PATH + entityClass.getSimpleName()
                    + "DAO";
            elementDAOImpl = (ElementDAOImpl) Class.forName(daoClassName)
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return elementDAOImpl;
    }
}
