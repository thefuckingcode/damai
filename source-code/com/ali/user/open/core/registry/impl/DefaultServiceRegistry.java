package com.ali.user.open.core.registry.impl;

import com.ali.user.open.core.registry.ServiceRegistration;
import com.ali.user.open.core.registry.ServiceRegistry;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class DefaultServiceRegistry implements ServiceRegistry {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Map<ServiceRegistration, ServiceEntry> registrationServiceEntries = new HashMap();
    private Map<Class<?>, List<ServiceEntry>> typeServiceEntries = new HashMap();

    /* compiled from: Taobao */
    static class InternalServiceRegistration implements ServiceRegistration {
        private Map<String, String> properties;
        private ServiceRegistry serviceRegistry;
        private final String uuid = UUID.randomUUID().toString();

        public InternalServiceRegistration(ServiceRegistry serviceRegistry2, Map<String, String> map) {
            this.serviceRegistry = serviceRegistry2;
            this.properties = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.uuid.equals(((InternalServiceRegistration) obj).uuid);
            }
            return false;
        }

        public int hashCode() {
            String str = this.uuid;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        @Override // com.ali.user.open.core.registry.ServiceRegistration
        public void setProperties(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null)) {
                        this.properties.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }

        @Override // com.ali.user.open.core.registry.ServiceRegistration
        public void unregister() {
            this.serviceRegistry.unregisterService(this);
        }
    }

    /* compiled from: Taobao */
    static class ServiceEntry {
        public Object instance;
        public Map<String, String> properties;
        public Class<?>[] types;

        ServiceEntry() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A[EDGE_INSN: B:36:0x0063->B:23:0x0063 ?: BREAK  , SYNTHETIC] */
    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public <T> T getService(Class<T> cls, Map<String, String> map) {
        T cast;
        this.lock.readLock().lock();
        try {
            List<ServiceEntry> list = this.typeServiceEntries.get(cls);
            if (list != null) {
                if (list.size() != 0) {
                    if (map != null) {
                        if (map.size() != 0) {
                            for (ServiceEntry serviceEntry : list) {
                                boolean z = true;
                                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        Map.Entry<String, String> next = it.next();
                                        String str = serviceEntry.properties.get(next.getKey());
                                        if (str == null || !str.equals(next.getValue())) {
                                            z = false;
                                        }
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                    }
                                }
                                z = false;
                                continue;
                                if (z) {
                                    cast = cls.cast(serviceEntry.instance);
                                    this.lock.readLock().unlock();
                                    return cast;
                                }
                            }
                        }
                    }
                    cast = cls.cast(list.get(0).instance);
                    this.lock.readLock().unlock();
                    return cast;
                }
            }
            return null;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006c A[SYNTHETIC] */
    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public <T> T[] getServices(Class<T> cls, Map<String, String> map) {
        T[] tArr;
        boolean z;
        this.lock.readLock().lock();
        try {
            List<ServiceEntry> list = this.typeServiceEntries.get(cls);
            if (list != null) {
                if (list.size() != 0) {
                    if (map != null) {
                        if (map.size() != 0) {
                            ArrayList arrayList = new ArrayList(list.size());
                            for (ServiceEntry serviceEntry : list) {
                                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        Map.Entry<String, String> next = it.next();
                                        String str = serviceEntry.properties.get(next.getKey());
                                        if (str == null || !str.equals(next.getValue())) {
                                            z = false;
                                        }
                                        if (!it.hasNext()) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                z = false;
                                if (z) {
                                    arrayList.add(cls.cast(serviceEntry.instance));
                                }
                            }
                            tArr = (T[]) arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
                            return tArr;
                        }
                    }
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, list.size()));
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        tArr2[i] = cls.cast(list.get(i).instance);
                    }
                    this.lock.readLock().unlock();
                    return tArr2;
                }
            }
            tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            return tArr;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public ServiceRegistration registerService(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        if (clsArr == null || clsArr.length == 0 || obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        ServiceEntry serviceEntry = new ServiceEntry();
        serviceEntry.instance = obj;
        serviceEntry.types = clsArr;
        serviceEntry.properties = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    serviceEntry.properties.put(entry.getKey(), entry.getValue());
                }
            }
        }
        this.lock.writeLock().lock();
        try {
            for (Class<?> cls : clsArr) {
                List<ServiceEntry> list = this.typeServiceEntries.get(cls);
                if (list == null) {
                    list = new ArrayList<>(2);
                    this.typeServiceEntries.put(cls, list);
                }
                list.add(serviceEntry);
            }
            InternalServiceRegistration internalServiceRegistration = new InternalServiceRegistration(this, serviceEntry.properties);
            this.registrationServiceEntries.put(internalServiceRegistration, serviceEntry);
            return internalServiceRegistration;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public Object unregisterService(ServiceRegistration serviceRegistration) {
        if (serviceRegistration == null) {
            return null;
        }
        this.lock.writeLock().lock();
        try {
            ServiceEntry remove = this.registrationServiceEntries.remove(serviceRegistration);
            if (remove == null) {
                return null;
            }
            Class<?>[] clsArr = remove.types;
            if (clsArr != null) {
                for (Class<?> cls : clsArr) {
                    List<ServiceEntry> list = this.typeServiceEntries.get(cls);
                    Iterator<ServiceEntry> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == remove) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        this.typeServiceEntries.remove(cls);
                    }
                }
            }
            Object obj = remove.instance;
            this.lock.writeLock().unlock();
            return obj;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
