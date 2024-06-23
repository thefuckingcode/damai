package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions {
    private static GeolocationPermissions a;

    public static GeolocationPermissions getInstance() {
        return a();
    }

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (a == null) {
                a = new GeolocationPermissions();
            }
            geolocationPermissions = a;
        }
        return geolocationPermissions;
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            a2.c().b(valueCallback);
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            a2.c().c(str, valueCallback);
        }
    }

    public void clear(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            a2.c().f(str);
        }
    }

    public void allow(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            a2.c().g(str);
        }
    }

    public void clearAll() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            a2.c().o();
        }
    }
}
