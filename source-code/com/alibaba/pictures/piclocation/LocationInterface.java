package com.alibaba.pictures.piclocation;

import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.alibaba.pictures.piclocation.listener.LocateMapListener;
import com.alibaba.pictures.piclocation.listener.LocateRegionPicListener;
import com.amap.api.location.AMapLocation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m81;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0006H&J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0004H&R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/alibaba/pictures/piclocation/LocationInterface;", "", "Lcom/alibaba/pictures/piclocation/listener/LocateGpsPicListener;", "locationPicListener", "Ltb/ur2;", "startLocation", "", "time", "startLocationWithCacheTime", "timeout", "cacheTime", "requestTime", "startLocationWithCacheTimeAndRequestTime", "Lcom/alibaba/pictures/piclocation/listener/LocateRegionPicListener;", "picListener", "startLocationRegion", "Lcom/alibaba/pictures/piclocation/listener/LocateMapListener;", "locateMapListener", "startLocationWithNoCache", "stop", "Lcom/amap/api/location/AMapLocation;", "getLastKnownLocation", "()Lcom/amap/api/location/AMapLocation;", "lastKnownLocation", "Ltb/m81;", "getDangerousLocationPic", "()Ltb/m81;", "dangerousLocationPic", "Companion", "a", "location_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface LocationInterface {
    @NotNull
    public static final a Companion = a.a;
    public static final long DEF_TIMEOUT = 15000;

    /* compiled from: Taobao */
    public static final class a {
        public static final long DEF_TIMEOUT = 15000;
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    @Nullable
    m81 getDangerousLocationPic();

    @Nullable
    AMapLocation getLastKnownLocation();

    void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener);

    void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener, long j);

    void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener);

    void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener, long j);

    void startLocationWithCacheTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j);

    void startLocationWithCacheTimeAndRequestTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j, long j2);

    void startLocationWithNoCache(@NotNull LocateMapListener locateMapListener);

    void stop();
}
