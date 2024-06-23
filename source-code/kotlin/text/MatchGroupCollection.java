package kotlin.text;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;
import tb.pb1;

/* compiled from: Taobao */
public interface MatchGroupCollection extends Collection<pb1>, KMappedMarker {
    @Nullable
    pb1 get(int i);
}
