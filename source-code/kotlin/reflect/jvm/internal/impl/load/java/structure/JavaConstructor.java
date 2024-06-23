package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface JavaConstructor extends JavaMember, JavaTypeParameterListOwner {
    @NotNull
    List<JavaValueParameter> getValueParameters();
}
