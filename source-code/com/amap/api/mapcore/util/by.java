package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gd;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public abstract class by<T, V> {
    protected T a;
    protected int b = 3;
    protected Context c;

    public by(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.c = context;
        this.a = t;
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract JSONObject a(gd.a aVar);

    /* access modifiers changed from: protected */
    public abstract V b(JSONObject jSONObject) throws AMapException;

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    public V c() throws AMapException {
        if (this.a != null) {
            return d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public V d() throws AMapException {
        int i = 0;
        V v = null;
        gd.a aVar = null;
        while (i < this.b) {
            try {
                aVar = gd.a(this.c, eq.e(), a(), b());
                v = b(a(aVar));
                i = this.b;
            } catch (Throwable th) {
                hd.c(th, "AbstractProtocalHandler", "getDataMayThrow AMapException");
                th.printStackTrace();
                i++;
                if (i < this.b) {
                    continue;
                } else if (aVar == null || aVar.a == null) {
                    v = null;
                } else {
                    throw new AMapException(aVar.a);
                }
            }
        }
        return v;
    }
}
