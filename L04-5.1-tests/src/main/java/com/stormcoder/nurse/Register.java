package com.stormcoder.nurse;
// видео 1:14
import java.util.HashMap;
import java.util.Map;

public class Register {

    private Map<String, Object> register = new HashMap<>();

    public Object get(String name) {
        return register.get(name);
    }

    public void add(String name, Object something) {
        register.put(name, something);
    }

    public void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public <T> T get(Class<T> className) {
        return (T) get(className.getName());
    }
}
