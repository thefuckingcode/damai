package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet d = new FieldSet(true);
    private final g<FieldDescriptorType, Object> a = g.n(16);
    private boolean b;
    private boolean c = false;

    /* compiled from: Taobao */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
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
            b[WireFormat.FieldType.STRING.ordinal()] = 9;
            b[WireFormat.FieldType.BYTES.ordinal()] = 10;
            b[WireFormat.FieldType.UINT32.ordinal()] = 11;
            b[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            b[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            b[WireFormat.FieldType.SINT32.ordinal()] = 14;
            b[WireFormat.FieldType.SINT64.ordinal()] = 15;
            b[WireFormat.FieldType.GROUP.ordinal()] = 16;
            b[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
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

    private FieldSet() {
    }

    private Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int d(WireFormat.FieldType fieldType, int i, Object obj) {
        int D = CodedOutputStream.D(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            D *= 2;
        }
        return D + e(fieldType, obj);
    }

    private static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.g(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.m(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.F(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.p(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.k(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.j(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.b(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.C((String) obj);
            case 10:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.e((ByteString) obj);
                }
                return CodedOutputStream.c((byte[]) obj);
            case 11:
                return CodedOutputStream.E(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.z(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.B(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.n((MessageLite) obj);
            case 17:
                if (obj instanceof d) {
                    return CodedOutputStream.r((d) obj);
                }
                return CodedOutputStream.t((MessageLite) obj);
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.i(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return d(liteType, number, obj);
        }
        int i = 0;
        if (fieldDescriptorLite.isPacked()) {
            for (Object obj2 : (List) obj) {
                i += e(liteType, obj2);
            }
            return CodedOutputStream.D(number) + i + CodedOutputStream.v(i);
        }
        for (Object obj3 : (List) obj) {
            i += d(liteType, number, obj3);
        }
        return i;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> g() {
        return d;
    }

    static int l(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                for (MessageLite messageLite : (List) entry.getValue()) {
                    if (!messageLite.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof d) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof d) {
            value = ((d) value).e();
        }
        if (key.isRepeated()) {
            Object h = h(key);
            if (h == null) {
                h = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) h).add(c(obj));
            }
            this.a.o(key, h);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object h2 = h(key);
            if (h2 == null) {
                this.a.o(key, c(value));
                return;
            }
            this.a.o(key, key.internalMergeFrom(((MessageLite) h2).toBuilder(), (MessageLite) value).build());
        } else {
            this.a.o(key, c(value));
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> t() {
        return new FieldSet<>();
    }

    public static Object u(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.m());
            case 2:
                return Float.valueOf(codedInputStream.q());
            case 3:
                return Long.valueOf(codedInputStream.t());
            case 4:
                return Long.valueOf(codedInputStream.M());
            case 5:
                return Integer.valueOf(codedInputStream.s());
            case 6:
                return Long.valueOf(codedInputStream.p());
            case 7:
                return Integer.valueOf(codedInputStream.o());
            case 8:
                return Boolean.valueOf(codedInputStream.k());
            case 9:
                if (z) {
                    return codedInputStream.J();
                }
                return codedInputStream.I();
            case 10:
                return codedInputStream.l();
            case 11:
                return Integer.valueOf(codedInputStream.L());
            case 12:
                return Integer.valueOf(codedInputStream.E());
            case 13:
                return Long.valueOf(codedInputStream.F());
            case 14:
                return Integer.valueOf(codedInputStream.G());
            case 15:
                return Long.valueOf(codedInputStream.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.d) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite) == false) goto L_0x0030;
     */
    private static void w(WireFormat.FieldType fieldType, Object obj) {
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

    private static void x(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.Y(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.w0(i, l(fieldType, false));
        y(codedOutputStream, fieldType, obj);
    }

    private static void y(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.R(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.X(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.c0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.z0(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.b0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.V(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.U(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.M(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.v0((String) obj);
                return;
            case 10:
                if (obj instanceof ByteString) {
                    codedOutputStream.P((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.N((byte[]) obj);
                    return;
                }
            case 11:
                codedOutputStream.y0(((Integer) obj).intValue());
                return;
            case 12:
                codedOutputStream.q0(((Integer) obj).intValue());
                return;
            case 13:
                codedOutputStream.r0(((Long) obj).longValue());
                return;
            case 14:
                codedOutputStream.s0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.u0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.Z((MessageLite) obj);
                return;
            case 17:
                codedOutputStream.e0((MessageLite) obj);
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.T(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.T(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void z(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.w0(number, 2);
                int i = 0;
                for (Object obj2 : list) {
                    i += e(liteType, obj2);
                }
                codedOutputStream.o0(i);
                for (Object obj3 : list) {
                    y(codedOutputStream, liteType, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                x(codedOutputStream, liteType, number, obj4);
            }
        } else if (obj instanceof d) {
            x(codedOutputStream, liteType, number, ((d) obj).e());
        } else {
            x(codedOutputStream, liteType, number, obj);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.isRepeated()) {
            w(fielddescriptortype.getLiteType(), obj);
            Object h = h(fielddescriptortype);
            if (h == null) {
                list = new ArrayList();
                this.a.o(fielddescriptortype, list);
            } else {
                list = (List) h;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> t = t();
        for (int i = 0; i < this.a.i(); i++) {
            Map.Entry<FieldDescriptorType, Object> h = this.a.h(i);
            t.v(h.getKey(), h.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.j()) {
            t.v(entry.getKey(), entry.getValue());
        }
        t.c = this.c;
        return t;
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.a.get(fielddescriptortype);
        return obj instanceof d ? ((d) obj).e() : obj;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i) {
        if (fielddescriptortype.isRepeated()) {
            Object h = h(fielddescriptortype);
            if (h != null) {
                return ((List) h).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            Object h = h(fielddescriptortype);
            if (h == null) {
                return 0;
            }
            return ((List) h).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int k() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.i(); i2++) {
            Map.Entry<FieldDescriptorType, Object> h = this.a.h(i2);
            i += f(h.getKey(), h.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.j()) {
            i += f(entry.getKey(), entry.getValue());
        }
        return i;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            return this.a.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean n() {
        for (int i = 0; i < this.a.i(); i++) {
            if (!o(this.a.h(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.j()) {
            if (!o(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        if (this.c) {
            return new d.c(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    public void q() {
        if (!this.b) {
            this.a.m();
            this.b = true;
        }
    }

    public void r(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.a.i(); i++) {
            s(fieldSet.a.h(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : fieldSet.a.j()) {
            s(entry);
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            w(fielddescriptortype.getLiteType(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                w(fielddescriptortype.getLiteType(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof d) {
            this.c = true;
        }
        this.a.o(fielddescriptortype, obj);
    }

    private FieldSet(boolean z) {
        q();
    }
}
