package com.youku.kubus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final FindState[] FIND_STATE_POOL = new FindState[4];
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean strictMethodVerification;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class FindState {
        final Map<String, Object> anyMethodByEventType = new HashMap();
        Class<?> clazz;
        final StringBuilder methodKeyBuilder = new StringBuilder(128);
        boolean skipSuperClasses;
        Class<?> subscriberClass;
        final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        final List<SubscriberMethod> subscriberMethods = new ArrayList();

        FindState() {
        }

        private boolean checkAddWithMethodSignature(Method method, String str) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            StringBuilder sb = this.methodKeyBuilder;
            sb.append('>');
            sb.append(str);
            String sb2 = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.subscriberClassByMethodKey.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean checkAdd(Method method, String str) {
            Object put = this.anyMethodByEventType.put(str, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (checkAddWithMethodSignature((Method) put, str)) {
                    this.anyMethodByEventType.put(str, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return checkAddWithMethodSignature(method, str);
        }

        /* access modifiers changed from: package-private */
        public void initForSubscriber(Class<?> cls) {
            this.clazz = cls;
            this.subscriberClass = cls;
            this.skipSuperClasses = false;
        }

        /* access modifiers changed from: package-private */
        public void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class<? super Object> superclass = this.clazz.getSuperclass();
            this.clazz = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.clazz = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
        }
    }

    SubscriberMethodFinder(boolean z) {
        this.strictMethodVerification = z;
    }

    static void clearCaches() {
        METHOD_CACHE.clear();
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> cls) {
        FindState prepareFindState = prepareFindState();
        prepareFindState.initForSubscriber(cls);
        while (prepareFindState.clazz != null) {
            findUsingReflectionInSingleClass(prepareFindState);
            prepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(prepareFindState);
    }

    private void findUsingReflectionInSingleClass(FindState findState) {
        Method[] methodArr;
        String[] eventType;
        int i;
        int i2;
        int i3 = 1;
        try {
            methodArr = findState.clazz.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = findState.clazz.getMethods();
            findState.skipSuperClasses = true;
        }
        int length = methodArr.length;
        int i4 = 0;
        while (i4 < length) {
            Method method = methodArr[i4];
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == i3) {
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (!(subscribe == null || (eventType = subscribe.eventType()) == null || eventType.length <= 0)) {
                        int length2 = eventType.length;
                        int i5 = 0;
                        while (i5 < length2) {
                            String str = eventType[i5];
                            if (findState.checkAdd(method, str)) {
                                i2 = i5;
                                i = length2;
                                findState.subscriberMethods.add(new SubscriberMethod(method, str, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                            } else {
                                i2 = i5;
                                i = length2;
                            }
                            i5 = i2 + 1;
                            length2 = i;
                        }
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
            i4++;
            i3 = 1;
        }
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.subscriberMethods);
        findState.recycle();
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                FindState[] findStateArr = FIND_STATE_POOL;
                if (findStateArr[i] == null) {
                    findStateArr[i] = findState;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                FindState[] findStateArr = FIND_STATE_POOL;
                FindState findState = findStateArr[i];
                if (findState != null) {
                    findStateArr[i] = null;
                    return findState;
                }
            }
            return new FindState();
        }
    }

    /* access modifiers changed from: package-private */
    public List<SubscriberMethod> findSubscriberMethods(Class<?> cls) {
        Map<Class<?>, List<SubscriberMethod>> map = METHOD_CACHE;
        List<SubscriberMethod> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<SubscriberMethod> findUsingReflection = findUsingReflection(cls);
        if (!findUsingReflection.isEmpty()) {
            map.put(cls, findUsingReflection);
            return findUsingReflection;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
