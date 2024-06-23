package com.youku.playerservice.axp.cellular;

import com.youku.phone.freeflow.YKFreeFlowResult;
import com.youku.phone.freeflow.YoukuFreeFlowApi;

/* compiled from: Taobao */
public class Player3gUtil {
    private static final String TAG = "Player3gUtil";
    private static final String VIDEO_NORMAL_TYPE = "onDemand";

    public static YKFreeFlowResult getYKFreeFlowResult() {
        return YoukuFreeFlowApi.getFreeFlowResult("onDemand");
    }
}
