package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.og1;

/* compiled from: Taobao */
public interface JavaPackage extends JavaAnnotationOwner, JavaElement {
    @NotNull
    Collection<JavaClass> getClasses(@NotNull Function1<? super og1, Boolean> function1);

    @NotNull
    en0 getFqName();

    @NotNull
    Collection<JavaPackage> getSubPackages();
}
