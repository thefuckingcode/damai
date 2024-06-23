package com.alient.oneservice.provider.impl;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
public class OneContext {
    private static final String TAG = "OneContext";
    private static Application application = null;
    private static Context applicationContext = null;
    public static boolean enableLog = true;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x008b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[SYNTHETIC, Splitter:B:21:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0  */
    private static void checkApplication() {
        Application application2;
        Exception e;
        Application application3;
        Application application4;
        if (application == null) {
            try {
                application3 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
                if (application3 != null) {
                    try {
                        Log.e(TAG, "get current application from AppGlobals " + application3);
                        application = application3;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Log.e(TAG, "Failed to get current application from AppGlobals." + e.getMessage());
                            try {
                                application4 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                                if (application4 != null) {
                                    Log.e(TAG, "get current application from android.app.ActivityThread.currentApplication app: " + application4);
                                    Log.e(TAG, "Failed to get current application from ActivityThread." + e.getMessage());
                                }
                            } catch (Exception unused) {
                                application4 = application3;
                            }
                            application = application4;
                            application2 = application;
                            if (application2 != null) {
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            application4 = application3;
                            application = application4;
                            throw th2;
                        }
                    }
                    application2 = application;
                    if (application2 != null) {
                        applicationContext = application2.getApplicationContext();
                    } else {
                        Log.e(TAG, "sApplication == null");
                    }
                } else {
                    throw new IllegalStateException("Failed to get current application from android.app.AppGlobals.getInitialApplication");
                }
            } catch (Exception e3) {
                e = e3;
                application3 = null;
                Log.e(TAG, "Failed to get current application from AppGlobals." + e.getMessage());
                application4 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                if (application4 != null) {
                }
                application = application4;
                application2 = application;
                if (application2 != null) {
                }
            }
        }
    }

    public static Application getApplication() {
        checkApplication();
        return application;
    }

    public static Context getApplicationContext() {
        checkApplication();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Context applicationContext2 = getApplication().getApplicationContext();
        applicationContext = applicationContext2;
        return applicationContext2;
    }

    public static boolean isDebuggable() {
        if (enableLog) {
            Log.d(TAG, ">>>isDebuggable()");
        }
        return (getApplication().getApplicationInfo().flags & 2) != 0;
    }

    public static void setApplication(Application application2) {
        application = application2;
    }
}
