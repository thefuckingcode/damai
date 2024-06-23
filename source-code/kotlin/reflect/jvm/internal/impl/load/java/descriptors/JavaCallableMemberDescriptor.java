package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.xu2;

/* compiled from: Taobao */
public interface JavaCallableMemberDescriptor extends CallableMemberDescriptor {
    @NotNull
    JavaCallableMemberDescriptor enhance(@Nullable g61 g61, @NotNull List<xu2> list, @NotNull g61 g612, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair);
}
