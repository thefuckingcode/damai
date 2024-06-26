package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = new a();

    /* compiled from: Taobao */
    static class a implements SourceElement {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            if (sourceFile == null) {
                a(0);
            }
            return sourceFile;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    @NotNull
    SourceFile getContainingFile();
}
