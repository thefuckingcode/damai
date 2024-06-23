package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016*\u00020\u0001H\u0001\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u001c\u0010\f\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003*\n\u0010\u0017\"\u00020\u00182\u00020\u0018*\u001c\u0010\u0019\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u0002H\u001a0\u001b2\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\f\b\u0002\u0010\u001c\"\u00020\u00152\u00020\u0015*\u001c\u0010\u001d\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u0002H\u001a0\u001e2\b\u0012\u0004\u0012\u0002H\u001a0\u001e¨\u0006\u001f"}, d2 = {"ALREADY_REMOVED", "", "ALREADY_REMOVED$annotations", "()V", "getALREADY_REMOVED", "()Ljava/lang/Object;", "CONDITION_FALSE", "CONDITION_FALSE$annotations", "getCONDITION_FALSE", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "REMOVE_PREPARED", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "RemoveFirstDesc", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: LockFreeLinkedList.kt */
public final class LockFreeLinkedListKt {
    private static final Object ALREADY_REMOVED = new Symbol("ALREADY_REMOVED");
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    public static final int FAILURE = 2;
    private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");
    private static final Object REMOVE_PREPARED = new Symbol("REMOVE_PREPARED");
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;

    public static /* synthetic */ void ALREADY_REMOVED$annotations() {
    }

    public static /* synthetic */ void CONDITION_FALSE$annotations() {
    }

    public static /* synthetic */ void FAILURE$annotations() {
    }

    public static /* synthetic */ void LIST_EMPTY$annotations() {
    }

    public static /* synthetic */ void SUCCESS$annotations() {
    }

    public static /* synthetic */ void UNDECIDED$annotations() {
    }

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final Object getALREADY_REMOVED() {
        return ALREADY_REMOVED;
    }

    public static final Object getLIST_EMPTY() {
        return LIST_EMPTY;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Intrinsics.checkParameterIsNotNull(obj, "$receiver");
        Removed removed = (Removed) (!(obj instanceof Removed) ? null : obj);
        return (removed == null || (lockFreeLinkedListNode = removed.ref) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
