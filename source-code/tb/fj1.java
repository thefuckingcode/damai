package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class fj1 extends gn1 {
    @Override // tb.gn1
    public void b(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        k21.i(callableMemberDescriptor, ShareperfenceConstants.FIRST);
        k21.i(callableMemberDescriptor2, "second");
        e(callableMemberDescriptor, callableMemberDescriptor2);
    }

    @Override // tb.gn1
    public void c(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        k21.i(callableMemberDescriptor, "fromSuper");
        k21.i(callableMemberDescriptor2, "fromCurrent");
        e(callableMemberDescriptor, callableMemberDescriptor2);
    }

    /* access modifiers changed from: protected */
    public abstract void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);
}
