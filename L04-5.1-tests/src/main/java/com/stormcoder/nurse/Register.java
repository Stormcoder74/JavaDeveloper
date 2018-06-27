package com.stormcoder.nurse;
// видео 1:33

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Register {

    private Map<String, Object> register = new HashMap<>();
    private Map<Field, String> fieldsToInject = new HashMap<>();

    public Object get(String name) {
        return register.get(name);
    }

    void add(String name, Object something) {
        if (get(name) != null)
            throw new RuntimeException("This object already exist");

        for(Field field: something.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Injection.class)){
                Object injection = get(field.getType());
                field.setAccessible(true);
                try {
                    field.set(something, injection);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        register.put(name, something);
    }

    void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public <T> T get(Class<T> className) {
        return (T) get(className.getName());
    }

    void inject() {

    }
}
