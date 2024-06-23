package androidx.core.location;

import android.location.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\n¨\u0006\u0004"}, d2 = {"Landroid/location/Location;", "", "component1", "component2", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class LocationKt {
    public static final double component1(@NotNull Location location) {
        k21.i(location, "$this$component1");
        return com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location);
    }

    public static final double component2(@NotNull Location location) {
        k21.i(location, "$this$component2");
        return com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location);
    }
}
