package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private final l<FieldDescriptorType, Object> a = l.o(16);
    private boolean b;
    private boolean c = false;

    /* compiled from: Taobao */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            b[WireFormat.FieldType.STRING.ordinal()] = 11;
            b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            try {
                b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            a = iArr2;
            iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            a[WireFormat.JavaType.LONG.ordinal()] = 2;
            a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            a[WireFormat.JavaType.STRING.ordinal()] = 6;
            a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            try {
                a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        new FieldSet(true);
    }

    private FieldSet() {
    }

    private Object d(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private void m(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof h) {
            value = ((h) value).i();
        }
        if (key.isRepeated()) {
            Object e = e(key);
            if (e == null) {
                e = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) e).add(d(obj));
            }
            this.a.put(key, e);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object e2 = e(key);
            if (e2 == null) {
                this.a.put(key, d(value));
                return;
            }
            this.a.put(key, key.internalMergeFrom(((MessageLite) e2).toBuilder(), (MessageLite) value).build());
        } else {
            this.a.put(key, d(value));
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> n() {
        return new FieldSet<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.protobuf.h) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.protobuf.Internal.EnumLite) == false) goto L_0x0030;
     */
    private static void q(WireFormat.FieldType fieldType, Object obj) {
        Objects.requireNonNull(obj);
        boolean z = true;
        boolean z2 = false;
        switch (a.a[fieldType.getJavaType().ordinal()]) {
            case 1:
                z2 = obj instanceof Integer;
                break;
            case 2:
                z2 = obj instanceof Long;
                break;
            case 3:
                z2 = obj instanceof Float;
                break;
            case 4:
                z2 = obj instanceof Double;
                break;
            case 5:
                z2 = obj instanceof Boolean;
                break;
            case 6:
                z2 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof ByteString)) {
                    break;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = z;
                break;
            case 9:
                if (!(obj instanceof MessageLite)) {
                    break;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.isRepeated()) {
            q(fielddescriptortype.getLiteType(), obj);
            Object e = e(fielddescriptortype);
            if (e == null) {
                list = new ArrayList();
                this.a.put(fielddescriptortype, list);
            } else {
                list = (List) e;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void b(FieldDescriptorType fielddescriptortype) {
        this.a.remove(fielddescriptortype);
        if (this.a.isEmpty()) {
            this.c = false;
        }
    }

    /* renamed from: c */
    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> n = n();
        for (int i = 0; i < this.a.i(); i++) {
            Map.Entry<FieldDescriptorType, Object> h = this.a.h(i);
            n.o(h.getKey(), h.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.k()) {
            n.o(entry.getKey(), entry.getValue());
        }
        n.c = this.c;
        return n;
    }

    public Object e(FieldDescriptorType fielddescriptortype) {
        Object obj = this.a.get(fielddescriptortype);
        return obj instanceof h ? ((h) obj).i() : obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.a.equals(((FieldSet) obj).a);
    }

    public Object f(FieldDescriptorType fielddescriptortype, int i) {
        if (fielddescriptortype.isRepeated()) {
            Object e = e(fielddescriptortype);
            if (e != null) {
                return ((List) e).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int g(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            Object e = e(fielddescriptortype);
            if (e == null) {
                return 0;
            }
            return ((List) e).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public boolean h(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            return this.a.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i() {
        return this.b;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> j() {
        if (this.c) {
            return new h.c(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    public void k() {
        if (!this.b) {
            this.a.n();
            this.b = true;
        }
    }

    public void l(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.a.i(); i++) {
            m(fieldSet.a.h(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : fieldSet.a.k()) {
            m(entry);
        }
    }

    public void o(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            q(fielddescriptortype.getLiteType(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                q(fielddescriptortype.getLiteType(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof h) {
            this.c = true;
        }
        this.a.put(fielddescriptortype, obj);
    }

    public void p(FieldDescriptorType fielddescriptortype, int i, Object obj) {
        if (fielddescriptortype.isRepeated()) {
            Object e = e(fielddescriptortype);
            if (e != null) {
                q(fielddescriptortype.getLiteType(), obj);
                ((List) e).set(i, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    private FieldSet(boolean z) {
        k();
    }
}
