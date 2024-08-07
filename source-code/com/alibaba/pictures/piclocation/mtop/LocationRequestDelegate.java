package com.alibaba.pictures.piclocation.mtop;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.m81;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/piclocation/mtop/LocationRequestDelegate;", "", "Ltb/m81;", "infoPic", "Lcom/alibaba/pictures/piclocation/mtop/RegionRequestHandler;", "regionRequest", "Ltb/ur2;", "requestRegionData", "location_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface LocationRequestDelegate {
    void requestRegionData(@NotNull m81 m81, @NotNull RegionRequestHandler regionRequestHandler);
}
