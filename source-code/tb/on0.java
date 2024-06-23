package tb;

import java.util.List;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class on0 extends GivenFunctionsMemberScope {

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public on0(@NotNull StorageManager storageManager, @NotNull nn0 nn0) {
        super(storageManager, nn0);
        k21.i(storageManager, "storageManager");
        k21.i(nn0, "containingClass");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    public List<FunctionDescriptor> b() {
        int i = a.$EnumSwitchMapping$0[((nn0) e()).o().ordinal()];
        if (i == 1) {
            return l.e(pn0.Factory.a((nn0) e(), false));
        }
        if (i != 2) {
            return m.g();
        }
        return l.e(pn0.Factory.a((nn0) e(), true));
    }
}
