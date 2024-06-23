package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class e61 implements SourceElement {
    @NotNull
    private final LazyJavaPackageFragment a;

    public e61(@NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        k21.i(lazyJavaPackageFragment, "packageFragment");
        this.a = lazyJavaPackageFragment;
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
        return this.a + ": " + this.a.g().keySet();
    }
}
