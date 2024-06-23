package tb;

import kotlin.jvm.JvmField;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class sq1 {
    @JvmField
    @NotNull
    public static final rq1 IMPLEMENTATIONS;

    static {
        rq1 rq1;
        Object newInstance;
        Object newInstance2;
        int a = a();
        if (a >= 65544 || a < 65536) {
            try {
                Object newInstance3 = a31.class.newInstance();
                k21.h(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                if (newInstance3 != null) {
                    try {
                        rq1 = (rq1) newInstance3;
                        IMPLEMENTATIONS = rq1;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader2 = rq1.class.getClassLoader();
                        if (!k21.d(classLoader, classLoader2)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                        }
                        throw e;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused) {
                try {
                    newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    k21.h(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (newInstance2 != null) {
                        rq1 = (rq1) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader4 = rq1.class.getClassLoader();
                if (!k21.d(classLoader3, classLoader4)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
                throw e2;
            }
        }
        if (a >= 65543 || a < 65536) {
            try {
                Object newInstance4 = z21.class.newInstance();
                k21.h(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                if (newInstance4 != null) {
                    try {
                        rq1 = (rq1) newInstance4;
                        IMPLEMENTATIONS = rq1;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = rq1.class.getClassLoader();
                        if (!k21.d(classLoader5, classLoader6)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                        }
                        throw e3;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused3) {
                try {
                    newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    k21.h(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (newInstance != null) {
                        rq1 = (rq1) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                }
            } catch (ClassCastException e4) {
                ClassLoader classLoader7 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader8 = rq1.class.getClassLoader();
                if (!k21.d(classLoader7, classLoader8)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                }
                throw e4;
            }
        }
        rq1 = new rq1();
        IMPLEMENTATIONS = rq1;
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int i = StringsKt__StringsKt.e0(property, '.', 0, false, 6, null);
        if (i < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        } else {
            int i2 = i + 1;
            int i3 = StringsKt__StringsKt.e0(property, '.', i2, false, 4, null);
            if (i3 < 0) {
                i3 = property.length();
            }
            String substring = property.substring(0, i);
            k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = property.substring(i2, i3);
            k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
    }
}
