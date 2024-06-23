package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface JavaTypeParameterListOwner extends JavaElement {
    @NotNull
    List<JavaTypeParameter> getTypeParameters();
}
