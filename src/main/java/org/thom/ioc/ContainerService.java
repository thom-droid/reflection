package org.thom.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {

        return getNewInstance(classType);

    }

    private static <T> T getNewInstance(Class<T> classType)  {
        try {
            return classType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getInjectedInstance(Class<T> tClass) {
        T newInstance = getNewInstance(tClass);

        Arrays.stream(tClass.getDeclaredFields()).forEach(f -> {
            if (f.getAnnotation(Inject.class) != null) {
                Object field = getNewInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(newInstance, field);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return newInstance;
    }
}
