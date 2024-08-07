package com.taobao.android.riverlogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: Taobao */
public class a {
    private c a;
    private JSONStringer b = null;

    a(RVLLevel rVLLevel, @NonNull String str) {
        int i = rVLLevel.value;
        RVLLevel rVLLevel2 = RVLLevel.Error;
        c cVar = new c(i <= rVLLevel2.value ? rVLLevel2 : rVLLevel, str == null ? "" : str);
        this.a = cVar;
        cVar.j = true;
    }

    private void b(String str) {
        try {
            if (this.b == null) {
                this.b = new JSONStringer().object();
            }
            this.b.key(str);
        } catch (JSONException unused) {
        }
    }

    private void c(Object obj) throws JSONException {
        if (obj == null || (obj instanceof Boolean) || obj == JSONObject.NULL || (obj instanceof Number) || (obj instanceof String) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            this.b.value(obj);
        } else if (obj instanceof Character) {
            this.b.value(obj.toString());
        } else if (obj instanceof Collection) {
            this.b.array();
            for (Object obj2 : (Collection) obj) {
                c(obj2);
            }
            this.b.endArray();
        } else if (obj instanceof Map) {
            this.b.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                this.b.key((String) entry.getKey());
                c(entry.getValue());
            }
            this.b.endObject();
        } else {
            if (obj.getClass().isArray()) {
                this.b.array();
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    c(Array.get(obj, i));
                }
                this.b.endArray();
            } else if (obj.getClass().getPackage().getName().startsWith("java.")) {
                this.b.value(obj.toString());
            } else {
                this.b.value(String.format("%s@%h", obj.getClass().getName(), obj));
            }
        }
    }

    public a a(@NonNull String str, @Nullable Object obj) {
        if (!(str == null || str.length() == 0)) {
            try {
                b(str);
                c(obj);
            } catch (JSONException unused) {
            }
        }
        return this;
    }

    public void d() {
        if (this.a != null) {
            JSONStringer jSONStringer = this.b;
            if (jSONStringer != null) {
                try {
                    jSONStringer.endObject();
                    this.a.i = this.b.toString();
                } catch (JSONException unused) {
                }
            }
            RVLLog.d(this.a);
            this.a = null;
        }
    }

    public a e(int i, @Nullable String str, Object... objArr) {
        if (i != 0) {
            this.a.f = String.valueOf(i);
            if (str != null) {
                this.a.g = String.format(str, objArr);
            }
            c cVar = this.a;
            if (cVar.a.value > RVLLevel.Warn.value) {
                cVar.a = RVLLevel.Error;
            }
        }
        return this;
    }

    public a f(@NonNull String str) {
        if (str != null && str.length() > 0) {
            this.a.e = str;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        d();
        super.finalize();
    }

    public a g(@NonNull String str, @Nullable String str2) {
        if (str != null && str.length() > 0) {
            this.a.e = str;
            if (str2 != null && str2.length() > 0) {
                this.a.c = str2;
            }
        }
        return this;
    }

    public a h(long j) {
        if (j > 0) {
            this.a.h = j;
        }
        return this;
    }
}
