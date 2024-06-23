package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Taobao */
public class fr extends ContextThemeWrapper {
    private static final String[] d = {"android.widget", "android.webkit", "android.app"};
    private Resources a = fs.a();
    private LayoutInflater b;
    private ClassLoader c;
    private a e = new a();
    private LayoutInflater.Factory f = new LayoutInflater.Factory() {
        /* class com.amap.api.mapcore.util.fr.AnonymousClass1 */

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return fr.this.a(str, context, attributeSet);
        }
    };

    /* compiled from: Taobao */
    public class a {
        public HashSet<String> a = new HashSet<>();
        public HashMap<String, Constructor<?>> b = new HashMap<>();

        public a() {
        }
    }

    public fr(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.c = classLoader;
    }

    public Resources getResources() {
        Resources resources = this.a;
        if (resources != null) {
            return resources;
        }
        return super.getResources();
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.b == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.b = layoutInflater.cloneInContext(this);
            }
            this.b.setFactory(this.f);
            this.b = this.b.cloneInContext(this);
        }
        return this.b;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A[SYNTHETIC, Splitter:B:32:0x0070] */
    private final View a(String str, Context context, AttributeSet attributeSet) {
        boolean z;
        Class<?> cls;
        if (this.e.a.contains(str)) {
            return null;
        }
        Constructor<?> constructor = this.e.b.get(str);
        if (constructor == null) {
            try {
                if (!str.contains("api.navi")) {
                    String[] strArr = d;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            cls = null;
                            break;
                        }
                        String str2 = strArr[i];
                        try {
                            cls = this.c.loadClass(str2 + "." + str);
                            break;
                        } catch (Throwable unused) {
                            i++;
                        }
                    }
                } else {
                    cls = this.c.loadClass(str);
                }
                if (!(cls == null || cls == ViewStub.class)) {
                    try {
                        if (cls.getClassLoader() == this.c) {
                            z = true;
                            if (z) {
                                this.e.a.add(str);
                                return null;
                            }
                            try {
                                constructor = cls.getConstructor(Context.class, AttributeSet.class);
                                this.e.b.put(str, constructor);
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
                cls = null;
            }
            z = false;
            if (z) {
            }
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (View) constructor.newInstance(context, attributeSet);
        } catch (Throwable unused5) {
            return null;
        }
    }
}
