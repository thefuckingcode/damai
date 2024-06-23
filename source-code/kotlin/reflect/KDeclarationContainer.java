package kotlin.reflect;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface KDeclarationContainer {
    @NotNull
    Collection<KCallable<?>> getMembers();
}
