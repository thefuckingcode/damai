package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuiltInsResourceLoader.kt */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        InputStream resourceAsStream;
        Intrinsics.checkParameterIsNotNull(str, "path");
        ClassLoader classLoader = getClass().getClassLoader();
        return (classLoader == null || (resourceAsStream = classLoader.getResourceAsStream(str)) == null) ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
