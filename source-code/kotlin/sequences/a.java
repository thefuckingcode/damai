package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import tb.id0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a implements DropTakeSequence, Sequence {
    @NotNull
    public static final a INSTANCE = new a();

    private a() {
    }

    @NotNull
    /* renamed from: a */
    public a drop(int i) {
        return INSTANCE;
    }

    @NotNull
    /* renamed from: b */
    public a take(int i) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator iterator() {
        return id0.INSTANCE;
    }
}
