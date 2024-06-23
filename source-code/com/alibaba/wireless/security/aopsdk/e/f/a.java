package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.e.e.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseAopConfig */
public abstract class a {
    public static final String c = "AOP-CONFIG";
    public List<Field> a = new ArrayList();
    private a b;

    /* renamed from: com.alibaba.wireless.security.aopsdk.e.f.a$a  reason: collision with other inner class name */
    /* compiled from: BaseAopConfig */
    public static /* synthetic */ class C0115a {
        public static final /* synthetic */ int[] a;

        static {
            b.values();
            int[] iArr = new int[7];
            a = iArr;
            try {
                b bVar = b.INT;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = a;
                b bVar2 = b.DOUBLE;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = a;
                b bVar3 = b.STRING;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = a;
                b bVar4 = b.BOOLEAN;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = a;
                b bVar5 = b.JSON;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = a;
                b bVar6 = b.JSON_ARRAY;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = a;
                b bVar7 = b.OBJECT;
                iArr7[6] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public a() {
        Field[] fields = getClass().getFields();
        for (Field field : fields) {
            com.alibaba.wireless.security.aopsdk.e.e.a aVar = (com.alibaba.wireless.security.aopsdk.e.e.a) field.getAnnotation(com.alibaba.wireless.security.aopsdk.e.e.a.class);
            if (aVar != null && !TextUtils.isEmpty(aVar.key())) {
                this.a.add(field);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        com.alibaba.wireless.security.aopsdk.e.e.a aVar;
        for (Field field : this.a) {
            if (!(field == null || (aVar = (com.alibaba.wireless.security.aopsdk.e.e.a) field.getAnnotation(com.alibaba.wireless.security.aopsdk.e.e.a.class)) == null || !jSONObject.has(aVar.key()))) {
                try {
                    switch (aVar.type().ordinal()) {
                        case 0:
                            field.setDouble(this, jSONObject.getDouble(aVar.key()));
                            continue;
                        case 1:
                            field.setInt(this, jSONObject.getInt(aVar.key()));
                            continue;
                        case 2:
                            field.set(this, jSONObject.getString(aVar.key()));
                            continue;
                        case 3:
                            field.setBoolean(this, jSONObject.getBoolean(aVar.key()));
                            continue;
                        case 4:
                            a aVar2 = (a) aVar.handler().newInstance();
                            aVar2.a(this);
                            aVar2.b(jSONObject.getJSONObject(aVar.key()));
                            field.set(this, aVar2);
                            continue;
                        case 5:
                            Class<? extends a> handler = aVar.handler();
                            JSONArray optJSONArray = jSONObject.optJSONArray(aVar.key());
                            if (optJSONArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    a aVar3 = (a) handler.newInstance();
                                    aVar3.a(this);
                                    aVar3.b(optJSONArray.optJSONObject(i));
                                    arrayList.add(aVar3);
                                }
                                field.set(this, arrayList);
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            field.set(this, jSONObject.get(aVar.key()));
                            continue;
                        default:
                            continue;
                    }
                } catch (Throwable th) {
                    com.alibaba.wireless.security.aopsdk.i.a.a("AOP-Config", "" + this, th);
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public a a() {
        return this.b;
    }
}
