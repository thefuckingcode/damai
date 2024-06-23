package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public final class c {
    private final Map<Class<?>, Service> a = new HashMap();
    private final Map<Class<?>, Object> b = new HashMap();

    c(List<Service> list) {
        a(list);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        String str;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a2 = a(type, Context.class, AGConnectInstance.class);
            if (a2 != null) {
                return a2.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor a3 = a(type, Context.class);
            if (a3 == null) {
                return type.newInstance();
            }
            return a3.newInstance(aGConnectInstance.getContext());
        } catch (InstantiationException e) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (InvocationTargetException e2) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e2.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e3.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        boolean z = false;
        for (Constructor<?> constructor : declaredConstructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.a.get(cls);
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.b.get(cls)) != null) {
            return t;
        }
        T t2 = (T) a(aGConnectInstance, service);
        if (t2 != null && service.isSingleton()) {
            this.b.put(cls, t2);
        }
        return t2;
    }

    public void a(List<Service> list) {
        if (list != null) {
            for (Service service : list) {
                this.a.put(service.getInterface(), service);
            }
        }
    }
}
