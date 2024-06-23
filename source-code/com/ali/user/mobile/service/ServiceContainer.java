package com.ali.user.mobile.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class ServiceContainer {
    private static volatile ServiceContainer serviceContainer;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Map<Class<?>, ServiceEntry> serviceEntries = new HashMap();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class ServiceEntry {
        public Object instance;
        public Map<String, String> properties;
        public Class<?> type;

        ServiceEntry() {
        }
    }

    private ServiceContainer() {
    }

    public static ServiceContainer getInstance() {
        if (serviceContainer == null) {
            synchronized (ServiceContainer.class) {
                if (serviceContainer == null) {
                    serviceContainer = new ServiceContainer();
                }
            }
        }
        return serviceContainer;
    }

    public <T> T getService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        this.lock.readLock().lock();
        try {
            ServiceEntry serviceEntry = this.serviceEntries.get(cls);
            if (serviceEntry == null) {
                return null;
            }
            T cast = cls.cast(serviceEntry.instance);
            this.lock.readLock().unlock();
            return cast;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean registerService(Class<?> cls, Object obj) {
        if (cls == null || obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        ServiceEntry serviceEntry = new ServiceEntry();
        serviceEntry.instance = obj;
        serviceEntry.type = cls;
        serviceEntry.properties = Collections.synchronizedMap(new HashMap());
        this.lock.writeLock().lock();
        try {
            this.serviceEntries.put(cls, serviceEntry);
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
