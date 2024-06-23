package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public interface JavaClassesTracker {

    /* compiled from: Taobao */
    public static final class a implements JavaClassesTracker {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor) {
            k21.i(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor);
}
