package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import tb.jl1;

/* compiled from: Taobao */
public class a {
    public ArrayList a;

    public a() {
        this.a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.a.add(Array.get(obj, i));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c;
        Object obj;
        ArrayList arrayList;
        char c2 = cVar.c();
        if (c2 == '[') {
            c = jl1.ARRAY_END;
        } else if (c2 == '(') {
            c = ')';
        } else {
            throw cVar.a("A JSONArray text must start with '['");
        }
        if (cVar.c() != ']') {
            do {
                cVar.a();
                char c3 = cVar.c();
                cVar.a();
                if (c3 == ',') {
                    arrayList = this.a;
                    obj = null;
                } else {
                    arrayList = this.a;
                    obj = cVar.d();
                }
                arrayList.add(obj);
                char c4 = cVar.c();
                if (c4 != ')') {
                    if (c4 != ',' && c4 != ';') {
                        if (c4 != ']') {
                            throw cVar.a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c != c4) {
                    throw cVar.a("Expected a '" + new Character(c) + "'");
                }
                return;
            } while (cVar.c() != ']');
        }
    }

    private String a(String str) {
        int size = this.a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.a.size();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.a.size()) ? null : this.a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return jl1.ARRAY_START_STR + a(",") + jl1.ARRAY_END;
        } catch (Exception unused) {
            return null;
        }
    }
}
