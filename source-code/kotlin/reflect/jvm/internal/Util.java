package kotlin.reflect.jvm.internal;

/* access modifiers changed from: package-private */
public class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
