package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

/* compiled from: Taobao */
public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private void appendArray(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
        } else if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
        } else if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
        } else if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
        } else if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
        } else if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length && compareToBuilder.comparison == 0; i++) {
            Field field = declaredFields[i];
            if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder appendSuper(int i) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i;
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.comparison = -1;
            return this;
        } else if (obj2 == null) {
            this.comparison = 1;
            return this;
        } else {
            if (obj.getClass().isArray()) {
                appendArray(obj, obj2, comparator);
            } else if (comparator == null) {
                this.comparison = ((Comparable) obj).compareTo(obj2);
            } else {
                this.comparison = comparator.compare(obj, obj2);
            }
            return this;
        }
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            throw null;
        } else if (obj2 != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2.isInstance(obj2)) {
                CompareToBuilder compareToBuilder = new CompareToBuilder();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
                while (cls2.getSuperclass() != null && cls2 != cls) {
                    cls2 = cls2.getSuperclass();
                    reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
                }
                return compareToBuilder.toComparison();
            }
            throw new ClassCastException();
        } else {
            throw null;
        }
    }

    public CompareToBuilder append(long j, long j2) {
        if (this.comparison != 0) {
            return this;
        }
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        this.comparison = i < 0 ? -1 : i > 0 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(int i, int i2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i < i2 ? -1 : i > i2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s < s2 ? -1 : s > s2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(char c, char c2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c < c2 ? -1 : c > c2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(byte b, byte b2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b < b2 ? -1 : b > b2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(double d, double d2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d, d2);
        return this;
    }

    public CompareToBuilder append(float f, float f2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f, f2);
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.comparison != 0 || z == z2) {
            return this;
        }
        if (!z) {
            this.comparison = -1;
        } else {
            this.comparison = 1;
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.comparison != 0 || objArr == objArr2) {
            return this;
        }
        int i = -1;
        if (objArr == null) {
            this.comparison = -1;
            return this;
        } else if (objArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (objArr.length != objArr2.length) {
            if (objArr.length >= objArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < objArr.length && this.comparison == 0; i2++) {
                append(objArr[i2], objArr2[i2], comparator);
            }
            return this;
        }
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison != 0 || jArr == jArr2) {
            return this;
        }
        int i = -1;
        if (jArr == null) {
            this.comparison = -1;
            return this;
        } else if (jArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (jArr.length != jArr2.length) {
            if (jArr.length >= jArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < jArr.length && this.comparison == 0; i2++) {
                append(jArr[i2], jArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison != 0 || iArr == iArr2) {
            return this;
        }
        int i = -1;
        if (iArr == null) {
            this.comparison = -1;
            return this;
        } else if (iArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (iArr.length != iArr2.length) {
            if (iArr.length >= iArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < iArr.length && this.comparison == 0; i2++) {
                append(iArr[i2], iArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison != 0 || sArr == sArr2) {
            return this;
        }
        int i = -1;
        if (sArr == null) {
            this.comparison = -1;
            return this;
        } else if (sArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (sArr.length != sArr2.length) {
            if (sArr.length >= sArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < sArr.length && this.comparison == 0; i2++) {
                append(sArr[i2], sArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison != 0 || cArr == cArr2) {
            return this;
        }
        int i = -1;
        if (cArr == null) {
            this.comparison = -1;
            return this;
        } else if (cArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (cArr.length != cArr2.length) {
            if (cArr.length >= cArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < cArr.length && this.comparison == 0; i2++) {
                append(cArr[i2], cArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison != 0 || bArr == bArr2) {
            return this;
        }
        int i = -1;
        if (bArr == null) {
            this.comparison = -1;
            return this;
        } else if (bArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (bArr.length != bArr2.length) {
            if (bArr.length >= bArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < bArr.length && this.comparison == 0; i2++) {
                append(bArr[i2], bArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison != 0 || dArr == dArr2) {
            return this;
        }
        int i = -1;
        if (dArr == null) {
            this.comparison = -1;
            return this;
        } else if (dArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (dArr.length != dArr2.length) {
            if (dArr.length >= dArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < dArr.length && this.comparison == 0; i2++) {
                append(dArr[i2], dArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison != 0 || fArr == fArr2) {
            return this;
        }
        int i = -1;
        if (fArr == null) {
            this.comparison = -1;
            return this;
        } else if (fArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (fArr.length != fArr2.length) {
            if (fArr.length >= fArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < fArr.length && this.comparison == 0; i2++) {
                append(fArr[i2], fArr2[i2]);
            }
            return this;
        }
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison != 0 || zArr == zArr2) {
            return this;
        }
        int i = -1;
        if (zArr == null) {
            this.comparison = -1;
            return this;
        } else if (zArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (zArr.length != zArr2.length) {
            if (zArr.length >= zArr2.length) {
                i = 1;
            }
            this.comparison = i;
            return this;
        } else {
            for (int i2 = 0; i2 < zArr.length && this.comparison == 0; i2++) {
                append(zArr[i2], zArr2[i2]);
            }
            return this;
        }
    }
}
