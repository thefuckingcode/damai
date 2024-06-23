package com.uc.webview.export.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.UCCore;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

@Api
/* compiled from: Taobao */
public class MediaPlayerService extends Service {
    private Constructor<?> a;
    private boolean b;
    private IBinder c;
    private Method d;
    private Method e;

    private static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            return Class.forName(str);
        }
        try {
            return Class.forName(str, false, classLoader);
        } catch (Exception e2) {
            Log.e("ucmedia", "MPS -- getClass exception: " + e2);
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        DexClassLoader dexClassLoader;
        Objects.toString(intent);
        if (!this.b) {
            String stringExtra = intent.getStringExtra("impl.class");
            String stringExtra2 = intent.getStringExtra("dex.path");
            String stringExtra3 = intent.getStringExtra("odex.path");
            String stringExtra4 = intent.getStringExtra("lib.path");
            if (stringExtra2 == null || stringExtra2.length() == 0 || stringExtra3 == null || stringExtra3.length() == 0) {
                dexClassLoader = null;
            } else {
                File file = new File(stringExtra3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                dexClassLoader = new DexClassLoader(stringExtra2, stringExtra3, stringExtra4, MediaPlayerService.class.getClassLoader());
            }
            Class<?> a2 = a(stringExtra, dexClassLoader);
            if (a2 != null) {
                try {
                    Constructor<?> declaredConstructor = a2.getDeclaredConstructor(new Class[0]);
                    this.a = declaredConstructor;
                    if (declaredConstructor != null) {
                        declaredConstructor.setAccessible(true);
                    }
                    try {
                        Method method = a2.getMethod(UCCore.LEGACY_EVENT_INIT, Context.class);
                        this.d = method;
                        method.setAccessible(true);
                        try {
                            Method method2 = a2.getMethod("onUnbind", new Class[0]);
                            this.e = method2;
                            method2.setAccessible(true);
                            this.b = true;
                        } catch (Throwable th) {
                            Log.e("ucmedia", "MPS -- Initialize service failed, exception: " + th);
                        }
                    } catch (Throwable th2) {
                        Log.e("ucmedia", "MPS -- Initialize service failed, exception: " + th2);
                    }
                } catch (Exception e2) {
                    Log.e("ucmedia", "MPS -- Initialize service failed, exception: " + e2);
                }
            }
        }
        Constructor<?> constructor = this.a;
        if (constructor != null) {
            try {
                IBinder iBinder = (IBinder) constructor.newInstance(new Object[0]);
                this.c = iBinder;
                Method method3 = this.d;
                if (method3 != null) {
                    try {
                        method3.invoke(iBinder, getApplicationContext());
                    } catch (Exception e3) {
                        Log.e("ucmedia", "MPS -- invoke init failed, exception: " + e3);
                    }
                }
                return this.c;
            } catch (Exception e4) {
                Log.e("ucmedia", "MPS -- onBind exception: " + e4);
            }
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
    }

    public boolean onUnbind(Intent intent) {
        Objects.toString(intent);
        IBinder iBinder = this.c;
        if (iBinder != null) {
            try {
                this.e.invoke(iBinder, new Object[0]);
            } catch (Exception e2) {
                Log.e("ucmedia", "MPS -- invoke onUnbind failed, exception: " + e2);
            }
            this.c = null;
        }
        return super.onUnbind(intent);
    }
}
