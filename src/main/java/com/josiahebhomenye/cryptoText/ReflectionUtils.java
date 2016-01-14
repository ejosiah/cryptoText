package com.josiahebhomenye.cryptoText;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Josiah on 12/12/2015.
 */
public final class ReflectionUtils {

    private ReflectionUtils(){

    }

    @SuppressWarnings("unchecked")
    public static <T> T createInstance(String typeName, Object...args){
        try {
            Class<T> type = (Class<T>)Class.forName(typeName);
            return createInstance(type, args);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T createInstance( Class<T> type, Object...args) {
        Constructor<T> constructor;
        try {
            constructor = type.getDeclaredConstructor(typesFor(args));
            return constructor.newInstance(args);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class[] typesFor(Object...args){
        Class types[] = new Class[args.length];
        for(int i = 0; i < types.length; i++){
            types[i] = args[i].getClass();
        }
        return types;
    }
}
