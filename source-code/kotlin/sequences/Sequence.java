package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface Sequence<T> {
    @NotNull
    Iterator<T> iterator();
}
