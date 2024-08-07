package com.alibaba.pictures.piclocation.listener;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.m81;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/piclocation/listener/LocateGpsPicListener;", "", "Ltb/m81;", "location", "Ltb/ur2;", "onLocationSuccess", "", "code", "", SocialConstants.PARAM_APP_DESC, "onFailed", "location_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface LocateGpsPicListener {
    void onFailed(int i, @Nullable String str);

    void onLocationSuccess(@Nullable m81 m81);
}
