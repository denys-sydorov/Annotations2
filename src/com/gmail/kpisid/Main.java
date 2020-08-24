package com.gmail.kpisid;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{
        TextContainer cont = new TextContainer();
        Class<?> cls = cont.getClass();

        if (! cls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Error!");
            return;
        }

        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Saver.class)) {
                m.invoke(cont, path);
                break;

            }
        }
        System.out.println("Done!");
    }
}

