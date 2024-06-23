package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class h22 implements JavaSourceElementFactory {
    @NotNull
    public static final h22 INSTANCE = new h22();

    /* compiled from: Taobao */
    public static final class a implements JavaSourceElement {
        @NotNull
        private final jy1 a;

        public a(@NotNull jy1 jy1) {
            k21.i(jy1, "javaElement");
            this.a = jy1;
        }

        @NotNull
        /* renamed from: a */
        public jy1 getJavaElement() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            k21.h(sourceFile, "NO_SOURCE_FILE");
            return sourceFile;
        }

        @NotNull
        public String toString() {
            return a.class.getName() + ": " + getJavaElement();
        }
    }

    private h22() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    @NotNull
    public JavaSourceElement source(@NotNull JavaElement javaElement) {
        k21.i(javaElement, "javaElement");
        return new a((jy1) javaElement);
    }
}
