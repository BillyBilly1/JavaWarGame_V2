package domain.service.id;

import domain.service.id.SingletonIDGenerator;

public class SingletonIntegerIDGenerator implements SingletonIDGenerator {

    private static SingletonIntegerIDGenerator instance;
    private int id;

    private SingletonIntegerIDGenerator() {
        id = 0;
    }

    public static synchronized SingletonIntegerIDGenerator getInstance() {
        if (instance == null) {
            instance = new SingletonIntegerIDGenerator();
        }
        return instance;
    }

    public synchronized String getID() {
        id++;
        return "ID" + String.valueOf(id);
    }

}
