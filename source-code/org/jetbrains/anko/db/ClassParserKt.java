package org.jetbrains.anko.db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0001H\b\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0001\u001a\u0014\u0010\t\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u000b"}, d2 = {"castValue", "", "value", "type", "Ljava/lang/Class;", "classParser", "Lorg/jetbrains/anko/db/RowParser;", "T", "clazz", "hasApplicableType", "", "sqlite-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: ClassParser.kt */
public final class ClassParserKt {
    private static final <T> RowParser<T> classParser() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return classParser(Object.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r7 != false) goto L_0x0058;
     */
    public static final <T> RowParser<T> classParser(Class<T> cls) {
        Constructor constructor;
        Class<?>[] parameterTypes;
        boolean z;
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkExpressionValueIsNotNull(declaredConstructors, "clazz.declaredConstructors");
        ArrayList arrayList = new ArrayList();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = declaredConstructors[i];
            Intrinsics.checkExpressionValueIsNotNull(constructor2, "ctr");
            if (!constructor2.isVarArgs() && Modifier.isPublic(constructor2.getModifiers()) && (parameterTypes = constructor2.getParameterTypes()) != null) {
                if (!(parameterTypes.length == 0)) {
                    int length2 = parameterTypes.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = true;
                            break;
                        } else if (!hasApplicableType(parameterTypes[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            z2 = false;
            if (z2) {
                arrayList.add(constructor2);
            }
            i++;
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            if (arrayList2.size() > 1) {
                ArrayList arrayList3 = new ArrayList();
                for (T t : arrayList2) {
                    if (t.isAnnotationPresent(ClassParserConstructor.class)) {
                        arrayList3.add(t);
                    }
                }
                constructor = (Constructor) CollectionsKt.singleOrNull((List) arrayList3);
                if (constructor == null) {
                    throw new AnkoException("Several constructors are annotated with ClassParserConstructor");
                }
            } else {
                constructor = (Constructor) arrayList2.get(0);
            }
            return new ClassParserKt$classParser$1(constructor);
        }
        throw new AnkoException("Can't initialize object parser for " + cls.getCanonicalName() + ", no acceptable constructors found");
    }

    private static final boolean hasApplicableType(Class<?> cls) {
        if (!cls.isPrimitive() && !Intrinsics.areEqual(cls, String.class) && !Intrinsics.areEqual(cls, CharSequence.class) && !Intrinsics.areEqual(cls, Long.class) && !Intrinsics.areEqual(cls, Integer.class) && !Intrinsics.areEqual(cls, Byte.class) && !Intrinsics.areEqual(cls, Character.class) && !Intrinsics.areEqual(cls, Boolean.class) && !Intrinsics.areEqual(cls, Float.class) && !Intrinsics.areEqual(cls, Double.class) && !Intrinsics.areEqual(cls, Short.class)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Object castValue(Object obj, Class<?> cls) {
        if (obj == null && cls.isPrimitive()) {
            throw new AnkoException("null can't be converted to the value of primitive type " + cls.getCanonicalName());
        } else if (obj == null || Intrinsics.areEqual(cls, Object.class)) {
            return obj;
        } else {
            if (cls.isPrimitive() && Intrinsics.areEqual(JavaSqliteUtils.PRIMITIVES_TO_WRAPPERS.get(cls), obj.getClass())) {
                return obj;
            }
            if ((obj instanceof Double) && (Intrinsics.areEqual(cls, Float.TYPE) || Intrinsics.areEqual(cls, Float.class))) {
                return Float.valueOf((float) ((Number) obj).doubleValue());
            }
            if ((obj instanceof Float) && (Intrinsics.areEqual(cls, Double.TYPE) || Intrinsics.areEqual(cls, Double.class))) {
                return Double.valueOf((double) ((Number) obj).floatValue());
            }
            if ((obj instanceof Character) && CharSequence.class.isAssignableFrom(cls)) {
                return obj.toString();
            }
            if (obj instanceof Long) {
                if (Intrinsics.areEqual(cls, Integer.TYPE) || Intrinsics.areEqual(cls, Integer.class)) {
                    return Integer.valueOf((int) ((Number) obj).longValue());
                }
                if (Intrinsics.areEqual(cls, Short.TYPE) || Intrinsics.areEqual(cls, Short.class)) {
                    return Short.valueOf((short) ((int) ((Number) obj).longValue()));
                }
                if (Intrinsics.areEqual(cls, Byte.TYPE) || Intrinsics.areEqual(cls, Byte.class)) {
                    return Byte.valueOf((byte) ((int) ((Number) obj).longValue()));
                }
                if (Intrinsics.areEqual(cls, Boolean.TYPE) || Intrinsics.areEqual(cls, Boolean.class)) {
                    return Boolean.valueOf(!Intrinsics.areEqual(obj, (Object) 0L));
                }
                if (Intrinsics.areEqual(cls, Character.TYPE) || Intrinsics.areEqual(cls, Character.class)) {
                    return Character.valueOf((char) ((int) ((Number) obj).longValue()));
                }
            }
            if (obj instanceof Integer) {
                if (Intrinsics.areEqual(cls, Long.TYPE) || Intrinsics.areEqual(cls, Long.class)) {
                    return Long.valueOf((long) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual(cls, Short.TYPE) || Intrinsics.areEqual(cls, Short.class)) {
                    return Short.valueOf((short) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual(cls, Byte.TYPE) || Intrinsics.areEqual(cls, Byte.class)) {
                    return Byte.valueOf((byte) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual(cls, Boolean.TYPE) || Intrinsics.areEqual(cls, Boolean.class)) {
                    return Boolean.valueOf(!Intrinsics.areEqual(obj, (Object) 0));
                }
                if (Intrinsics.areEqual(cls, Character.TYPE) || Intrinsics.areEqual(cls, Character.class)) {
                    return Character.valueOf((char) ((Number) obj).intValue());
                }
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 1 && (Intrinsics.areEqual(cls, Character.TYPE) || Intrinsics.areEqual(cls, Character.class))) {
                    return Character.valueOf(str.charAt(0));
                }
            }
            throw new AnkoException("Value " + obj + " of type " + obj.getClass() + " can't be cast to " + cls.getCanonicalName());
        }
    }
}
