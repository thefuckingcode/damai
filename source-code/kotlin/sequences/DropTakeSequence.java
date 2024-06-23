package kotlin.sequences;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface DropTakeSequence<T> extends Sequence<T> {
    @NotNull
    Sequence<T> drop(int i);

    @NotNull
    Sequence<T> take(int i);
}
