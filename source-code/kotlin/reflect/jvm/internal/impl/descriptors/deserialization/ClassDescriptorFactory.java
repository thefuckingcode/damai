package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.og1;
import tb.oi;

/* compiled from: Taobao */
public interface ClassDescriptorFactory {
    @Nullable
    ClassDescriptor createClass(@NotNull oi oiVar);

    @NotNull
    Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull en0 en0);

    boolean shouldCreateClass(@NotNull en0 en0, @NotNull og1 og1);
}
