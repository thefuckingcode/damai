package com.youku.playerservice.axp.cache;

import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import java.util.List;

/* compiled from: Taobao */
public interface IMultiGetUpsCallback {
    void onResult(List<PlayInfoResponse> list);
}
