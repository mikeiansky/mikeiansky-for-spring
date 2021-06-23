package com.winson.study.spring.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author winson
 * @date 2021/6/23
 **/
public class ThreadLocalScope implements Scope {

    public static final String SCOPE_NAME = "winson-thread-local";

    private NamedThreadLocal<Map<String, Object>> context = new NamedThreadLocal<Map<String, Object>>("thread-local-scope") {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    private Map<String, Object> getContext() {
        return context.get();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();

        Object object = context.get(name);

        if (object == null) {
            object = objectFactory.getObject();
            context.put(name, object);
        }

        return object;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        System.out.println("register destruction callback");
    }

    @Override
    public Object resolveContextualObject(String key) {
        System.out.println("resolve contextual object key : " + key);
        return null;
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }

}
