package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new a();

    /* compiled from: Taobao */
    static class a implements SourceFile {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
        @Nullable
        public String getName() {
            return null;
        }
    }

    @Nullable
    String getName();
}
