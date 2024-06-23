package tb;

import androidx.collection.LruCache;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class tz2 {
    public static final boolean WriteMapNullValue = false;
    private static final boolean a = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);
    private static final ThreadLocal<char[]> b = new ThreadLocal<>();
    private static final String[] c = new String[2048];
    private static LruCache<String, List<Method>> d = new LruCache<>(128);
    private static LruCache<String, List<Field>> e = new LruCache<>(128);
    private static LruCache<String, Boolean> f = new LruCache<>(16);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        private static final ThreadLocal<byte[]> d = new ThreadLocal<>();
        private static final ThreadLocal<ArrayList> e = new ThreadLocal<>();
        private byte[] a;
        private int b;
        private ArrayList c;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void c() {
            byte[] bArr = this.a;
            if (bArr.length <= 16384) {
                d.set(bArr);
            }
            if (this.c.isEmpty()) {
                e.set(this.c);
            } else {
                this.c.clear();
            }
            this.c = null;
            this.a = null;
            this.b = 0;
        }

        private final void d(int i) {
            int i2 = i + this.b;
            byte[] bArr = this.a;
            if (i2 - bArr.length > 0) {
                int length = bArr.length << 1;
                if (length < 16384) {
                    length = 16384;
                }
                if (length - i2 >= 0) {
                    i2 = length;
                }
                this.a = Arrays.copyOf(bArr, i2);
            }
        }

        private final Map e(Object obj) {
            Object invoke;
            JSONObject jSONObject = new JSONObject();
            try {
                Class<?> cls = obj.getClass();
                String name = cls.getName();
                for (Method method : tz2.h(name, cls)) {
                    String name2 = method.getName();
                    if (name2.startsWith(gl1.TYPE_OPEN_URL_METHOD_GET)) {
                        Object invoke2 = method.invoke(obj, new Object[0]);
                        if (invoke2 != null) {
                            StringBuilder sb = new StringBuilder(method.getName().substring(3));
                            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
                            jSONObject.put((Object) sb.toString(), invoke2);
                        }
                    } else if (name2.startsWith("is") && (invoke = method.invoke(obj, new Object[0])) != null) {
                        StringBuilder sb2 = new StringBuilder(method.getName().substring(2));
                        sb2.setCharAt(0, Character.toLowerCase(sb2.charAt(0)));
                        jSONObject.put((Object) sb2.toString(), invoke);
                    }
                }
                for (Field field : tz2.g(name, cls)) {
                    String name3 = field.getName();
                    if (!jSONObject.containsKey(name3)) {
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            jSONObject.put((Object) name3, obj2);
                        }
                    }
                }
                return jSONObject;
            } catch (Exception e2) {
                if (e2 instanceof RuntimeException) {
                    throw ((RuntimeException) e2);
                }
                throw new RuntimeException(e2);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final byte[] f(Object obj) {
            o(obj);
            int i = this.b;
            byte[] bArr = new byte[i];
            System.arraycopy(this.a, 0, bArr, 0, i);
            return bArr;
        }

        private final void g(Object obj) {
            if (tz2.f.get(obj.getClass().getName()) != null) {
                o(JSON.toJSON(obj));
                return;
            }
            try {
                l(e(obj));
            } catch (Exception unused) {
                tz2.f.put(obj.getClass().getName(), Boolean.TRUE);
                o(JSON.toJSON(obj));
            }
        }

        private final void h(byte b2) {
            byte[] bArr = this.a;
            int i = this.b;
            bArr[i] = b2;
            this.b = i + 1;
        }

        private final void i(double d2) {
            k(Double.doubleToLongBits(d2));
        }

        private final void j(float f) {
            int floatToIntBits = Float.floatToIntBits(f);
            byte[] bArr = this.a;
            int i = this.b;
            bArr[i + 3] = (byte) floatToIntBits;
            bArr[i + 2] = (byte) (floatToIntBits >>> 8);
            bArr[i + 1] = (byte) (floatToIntBits >>> 16);
            bArr[i] = (byte) (floatToIntBits >>> 24);
            this.b = i + 4;
        }

        private final void k(long j) {
            byte[] bArr = this.a;
            int i = this.b;
            bArr[i + 7] = (byte) ((int) j);
            bArr[i + 6] = (byte) ((int) (j >>> 8));
            bArr[i + 5] = (byte) ((int) (j >>> 16));
            bArr[i + 4] = (byte) ((int) (j >>> 24));
            bArr[i + 3] = (byte) ((int) (j >>> 32));
            bArr[i + 2] = (byte) ((int) (j >>> 40));
            bArr[i + 1] = (byte) ((int) (j >>> 48));
            bArr[i] = (byte) ((int) (j >>> 56));
            this.b = i + 8;
        }

        private final void l(Map map) {
            Set<Map.Entry> entrySet = map.entrySet();
            int i = 0;
            for (Map.Entry entry : entrySet) {
                if (entry.getValue() == null) {
                    i++;
                }
            }
            d(8);
            h((byte) 123);
            p(map.size() - i);
            for (Map.Entry entry2 : entrySet) {
                if (entry2.getValue() != null) {
                    m(entry2.getKey().toString());
                    o(entry2.getValue());
                }
            }
        }

        private final void m(String str) {
            q(str);
        }

        private final void n(Number number) {
            d(12);
            if (number instanceof Integer) {
                h((byte) 105);
                r(number.intValue());
            } else if (number instanceof Float) {
                h((byte) 70);
                j(number.floatValue());
            } else if (number instanceof Double) {
                h((byte) 100);
                i(number.doubleValue());
            } else if (number instanceof Long) {
                h((byte) 108);
                k(number.longValue());
            } else if ((number instanceof Short) || (number instanceof Byte)) {
                h((byte) 105);
                r(number.intValue());
            } else if (number instanceof BigInteger) {
                h((byte) 103);
                q(number.toString());
            } else if (number instanceof BigDecimal) {
                String obj = number.toString();
                double doubleValue = number.doubleValue();
                if (obj.equals(Double.toString(doubleValue))) {
                    h((byte) 100);
                    i(doubleValue);
                    return;
                }
                h((byte) 101);
                q(obj);
            } else {
                h((byte) 115);
                q(number.toString());
            }
        }

        private final void o(Object obj) {
            if (obj instanceof CharSequence) {
                d(2);
                h((byte) 115);
                q((CharSequence) obj);
            } else if (obj instanceof Map) {
                if (this.c.contains(obj)) {
                    d(2);
                    h((byte) 48);
                    return;
                }
                this.c.add(obj);
                l((Map) obj);
                ArrayList arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            } else if (obj instanceof List) {
                if (this.c.contains(obj)) {
                    d(2);
                    h((byte) 48);
                    return;
                }
                this.c.add(obj);
                d(8);
                List<Object> list = (List) obj;
                h((byte) 91);
                p(list.size());
                for (Object obj2 : list) {
                    o(obj2);
                }
                ArrayList arrayList2 = this.c;
                arrayList2.remove(arrayList2.size() - 1);
            } else if (obj instanceof Number) {
                n((Number) obj);
            } else if (obj instanceof Boolean) {
                d(2);
                if (((Boolean) obj).booleanValue()) {
                    h((byte) 116);
                } else {
                    h((byte) 102);
                }
            } else if (obj == null) {
                d(2);
                h((byte) 48);
            } else if (obj.getClass().isArray()) {
                if (this.c.contains(obj)) {
                    d(2);
                    h((byte) 48);
                    return;
                }
                this.c.add(obj);
                d(8);
                int length = Array.getLength(obj);
                h((byte) 91);
                p(length);
                for (int i = 0; i < length; i++) {
                    o(Array.get(obj, i));
                }
                ArrayList arrayList3 = this.c;
                arrayList3.remove(arrayList3.size() - 1);
            } else if (obj instanceof Date) {
                d(10);
                h((byte) 100);
                i((double) ((Date) obj).getTime());
            } else if (obj instanceof Calendar) {
                d(10);
                h((byte) 100);
                i((double) ((Calendar) obj).getTime().getTime());
            } else if (obj instanceof Collection) {
                if (this.c.contains(obj)) {
                    d(2);
                    h((byte) 48);
                    return;
                }
                this.c.add(obj);
                d(8);
                Collection<Object> collection = (Collection) obj;
                h((byte) 91);
                p(collection.size());
                for (Object obj3 : collection) {
                    o(obj3);
                }
                ArrayList arrayList4 = this.c;
                arrayList4.remove(arrayList4.size() - 1);
            } else if (this.c.contains(obj)) {
                d(2);
                h((byte) 48);
            } else {
                this.c.add(obj);
                if (obj.getClass().isEnum()) {
                    o(JSON.toJSONString(obj));
                } else {
                    g(obj);
                }
                ArrayList arrayList5 = this.c;
                arrayList5.remove(arrayList5.size() - 1);
            }
        }

        private final void p(int i) {
            while ((i & com.alipay.sdk.m.n.a.g) != 0) {
                byte[] bArr = this.a;
                int i2 = this.b;
                bArr[i2] = (byte) ((i & 127) | 128);
                this.b = i2 + 1;
                i >>>= 7;
            }
            byte[] bArr2 = this.a;
            int i3 = this.b;
            bArr2[i3] = (byte) (i & 127);
            this.b = i3 + 1;
        }

        private final void q(CharSequence charSequence) {
            int length = charSequence.length();
            int i = length * 2;
            d(i + 8);
            p(i);
            int i2 = 0;
            if (tz2.a) {
                while (i2 < length) {
                    char charAt = charSequence.charAt(i2);
                    byte[] bArr = this.a;
                    int i3 = this.b;
                    bArr[i3] = (byte) charAt;
                    bArr[i3 + 1] = (byte) (charAt >>> '\b');
                    this.b = i3 + 2;
                    i2++;
                }
                return;
            }
            while (i2 < length) {
                char charAt2 = charSequence.charAt(i2);
                byte[] bArr2 = this.a;
                int i4 = this.b;
                bArr2[i4 + 1] = (byte) charAt2;
                bArr2[i4] = (byte) (charAt2 >>> '\b');
                this.b = i4 + 2;
                i2++;
            }
        }

        private final void r(int i) {
            p((i >> 31) ^ (i << 1));
        }

        private b() {
            ThreadLocal<byte[]> threadLocal = d;
            byte[] bArr = threadLocal.get();
            this.a = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.a = new byte[1024];
            }
            ThreadLocal<ArrayList> threadLocal2 = e;
            ArrayList arrayList = threadLocal2.get();
            this.c = arrayList;
            if (arrayList != null) {
                threadLocal2.set(null);
            } else {
                this.c = new ArrayList(16);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c {
        private int a;
        private byte[] b;
        private char[] c;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void c() {
            this.a = 0;
            this.b = null;
            if (this.c != null) {
                tz2.b.set(this.c);
            }
            this.c = null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final Object d() {
            return k();
        }

        private final Object e() {
            int m = m();
            JSONArray jSONArray = new JSONArray(m);
            for (int i = 0; i < m; i++) {
                jSONArray.add(k());
            }
            return jSONArray;
        }

        private final Object f() {
            double longBitsToDouble = Double.longBitsToDouble(h());
            if (longBitsToDouble > 2.147483647E9d) {
                long j = (long) longBitsToDouble;
                if (longBitsToDouble - ((double) j) < Double.MIN_NORMAL) {
                    return Long.valueOf(j);
                }
            }
            return Double.valueOf(longBitsToDouble);
        }

        private Object g() {
            byte[] bArr = this.b;
            int i = this.a;
            this.a = i + 4;
            return Float.valueOf(Float.intBitsToFloat((bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 1] & 255) << 16) + ((bArr[i] & 255) << 24)));
        }

        private final long h() {
            byte[] bArr = this.b;
            int i = this.a;
            long j = (((long) bArr[i + 7]) & 255) + ((((long) bArr[i + 6]) & 255) << 8) + ((((long) bArr[i + 5]) & 255) << 16) + ((((long) bArr[i + 4]) & 255) << 24) + ((((long) bArr[i + 3]) & 255) << 32) + ((((long) bArr[i + 2]) & 255) << 40) + ((255 & ((long) bArr[i + 1])) << 48) + (((long) bArr[i]) << 56);
            this.a = i + 8;
            return j;
        }

        private final Object i() {
            int m = m();
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < m; i++) {
                jSONObject.put((Object) j(), k());
            }
            return jSONObject;
        }

        private final String j() {
            int m = m() / 2;
            if (this.c.length < m) {
                this.c = new char[m];
            }
            int i = 5381;
            if (tz2.a) {
                for (int i2 = 0; i2 < m; i2++) {
                    byte[] bArr = this.b;
                    int i3 = this.a;
                    char c2 = (char) ((bArr[i3] & 255) + (bArr[i3 + 1] << 8));
                    this.c[i2] = c2;
                    i = (i << 5) + i + c2;
                    this.a = i3 + 2;
                }
            } else {
                for (int i4 = 0; i4 < m; i4++) {
                    byte[] bArr2 = this.b;
                    int i5 = this.a;
                    char c3 = (char) ((bArr2[i5 + 1] & 255) + (bArr2[i5] << 8));
                    this.c[i4] = c3;
                    i = (i << 5) + i + c3;
                    this.a = i5 + 2;
                }
            }
            boolean z = true;
            int length = i & (tz2.c.length - 1);
            String str = tz2.c[length];
            if (str != null && str.length() == m) {
                int i6 = 0;
                while (true) {
                    if (i6 >= m) {
                        break;
                    } else if (this.c[i6] != str.charAt(i6)) {
                        z = false;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z) {
                    return str;
                }
            }
            String str2 = new String(this.c, 0, m);
            if (m < 64) {
                tz2.c[length] = str2;
            }
            return str2;
        }

        private final Object k() {
            byte l = l();
            if (l == 48) {
                return null;
            }
            if (l == 70) {
                return g();
            }
            if (l == 91) {
                return e();
            }
            if (l == 105) {
                return Integer.valueOf(o());
            }
            if (l == 108) {
                return Long.valueOf(h());
            }
            if (l == 123) {
                return i();
            }
            if (l == 115) {
                return n();
            }
            if (l == 116) {
                return Boolean.TRUE;
            }
            switch (l) {
                case 100:
                    return f();
                case 101:
                    return new BigDecimal(n());
                case 102:
                    return Boolean.FALSE;
                case 103:
                    return new BigInteger(n());
                default:
                    throw new RuntimeException("wson unhandled type " + ((int) l) + " " + this.a + " length " + this.b.length);
            }
        }

        private final byte l() {
            byte[] bArr = this.b;
            int i = this.a;
            byte b2 = bArr[i];
            this.a = i + 1;
            return b2;
        }

        private final int m() {
            int i = 0;
            int i2 = 0;
            do {
                byte[] bArr = this.b;
                int i3 = this.a;
                byte b2 = bArr[i3];
                if ((b2 & as2.MAX_POWER_OF_TWO) != 0) {
                    i |= (b2 & z7.DEL) << i2;
                    i2 += 7;
                    this.a = i3 + 1;
                } else {
                    this.a = i3 + 1;
                    return i | (b2 << i2);
                }
            } while (i2 <= 35);
            throw new IllegalArgumentException("Variable length quantity is too long");
        }

        private final String n() {
            int m = m() / 2;
            if (this.c.length < m) {
                this.c = new char[m];
            }
            if (tz2.a) {
                for (int i = 0; i < m; i++) {
                    byte[] bArr = this.b;
                    int i2 = this.a;
                    this.c[i] = (char) ((bArr[i2] & 255) + (bArr[i2 + 1] << 8));
                    this.a = i2 + 2;
                }
            } else {
                for (int i3 = 0; i3 < m; i3++) {
                    byte[] bArr2 = this.b;
                    int i4 = this.a;
                    this.c[i3] = (char) ((bArr2[i4 + 1] & 255) + (bArr2[i4] << 8));
                    this.a = i4 + 2;
                }
            }
            return new String(this.c, 0, m);
        }

        private final int o() {
            int m = m();
            return (m & Integer.MIN_VALUE) ^ ((((m << 31) >> 31) ^ m) >> 1);
        }

        private c(byte[] bArr) {
            this.a = 0;
            this.b = bArr;
            char[] cArr = (char[]) tz2.b.get();
            this.c = cArr;
            if (cArr != null) {
                tz2.b.set(null);
            } else {
                this.c = new char[512];
            }
        }
    }

    /* access modifiers changed from: private */
    public static final List<Field> g(String str, Class cls) {
        List<Field> list = e.get(str);
        if (list == null) {
            Field[] fields = cls.getFields();
            list = new ArrayList<>(fields.length);
            for (Field field : fields) {
                if ((field.getModifiers() & 8) == 0) {
                    if (field.getAnnotation(JSONField.class) == null) {
                        list.add(field);
                    } else {
                        throw new UnsupportedOperationException("getBeanMethod JSONField Annotation Not Handled, Use toJSON");
                    }
                }
            }
            e.put(str, list);
        }
        return list;
    }

    /* access modifiers changed from: private */
    public static final List<Method> h(String str, Class cls) {
        List<Method> list = d.get(str);
        if (list == null) {
            list = new ArrayList<>();
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (method.getDeclaringClass() != Object.class && (method.getModifiers() & 8) == 0) {
                    String name = method.getName();
                    if (name.startsWith(gl1.TYPE_OPEN_URL_METHOD_GET) || name.startsWith("is")) {
                        if (method.getAnnotation(JSONField.class) == null) {
                            list.add(method);
                        } else {
                            throw new UnsupportedOperationException("getBeanMethod JSONField Annotation Not Handled, Use toJSON");
                        }
                    }
                }
            }
            d.put(str, list);
        }
        return list;
    }

    public static final Object i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            c cVar = new c(bArr);
            Object d2 = cVar.d();
            cVar.c();
            return d2;
        } catch (Exception e2) {
            WXLogUtils.e("parseWson", e2);
            return null;
        }
    }

    public static final byte[] j(Object obj) {
        if (obj == null) {
            return null;
        }
        b bVar = new b();
        byte[] f2 = bVar.f(obj);
        bVar.c();
        return f2;
    }
}
