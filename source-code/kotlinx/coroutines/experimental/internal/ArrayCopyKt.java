package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"arraycopy", "", "E", "source", "", "srcPos", "", "destination", "destinationStart", "length", "([Ljava/lang/Object;I[Ljava/lang/Object;II)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: ArrayCopy.kt */
public final class ArrayCopyKt {
    public static final <E> void arraycopy(E[] eArr, int i, E[] eArr2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(eArr, "source");
        Intrinsics.checkParameterIsNotNull(eArr2, "destination");
        System.arraycopy(eArr, i, eArr2, i2, i3);
    }
}
