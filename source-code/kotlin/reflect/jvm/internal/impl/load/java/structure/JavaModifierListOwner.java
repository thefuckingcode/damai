package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;
import tb.qw2;

/* compiled from: Taobao */
public interface JavaModifierListOwner extends JavaElement {
    @NotNull
    qw2 getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isStatic();
}
