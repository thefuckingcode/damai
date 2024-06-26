package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.IARDetector;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Api
/* compiled from: Taobao */
public abstract class ARManager implements IARDetector.ResultListener {
    private static ARManager a;
    private static Method b;

    public static ARManager getInstance() {
        if (a == null) {
            try {
                ARManager g = CoreFactory.g();
                a = g;
                b = ReflectionUtil.getMethod(g.getClass(), "invoke");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    public void registerARDetector(String str, String str2) {
        ARManager aRManager = a;
        if (aRManager != null) {
            aRManager.registerARDetector(str, str2);
        }
    }

    public void registerARDetector(String str, String str2, HashMap<String, String> hashMap) {
        Method method;
        ARManager aRManager = a;
        if (aRManager != null && (method = b) != null) {
            try {
                method.invoke(aRManager, 2, new Object[]{str, str2, hashMap});
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void registerARDetector(Object obj) {
        Method method;
        ARManager aRManager = a;
        if (aRManager != null && (method = b) != null) {
            try {
                method.invoke(aRManager, 3, new Object[]{obj});
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
