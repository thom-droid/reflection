package org.thom.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        try {
            return getNewInstance(classType);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T getNewInstance(Class<T> classType) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return classType.getConstructor().newInstance();
    }
}
