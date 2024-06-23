package tb;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class rn2 extends c2 {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public rn2(@NotNull g61 g61) {
        this(g61, null);
        if (g61 == null) {
            a(0);
        }
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private rn2(@NotNull g61 g61, @Nullable ReceiverValue receiverValue) {
        super(g61, receiverValue);
        if (g61 == null) {
            a(1);
        }
    }
}
