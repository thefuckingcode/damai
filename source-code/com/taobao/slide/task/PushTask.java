package com.taobao.slide.task;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.core.b;
import com.taobao.slide.model.PodDO;
import com.taobao.slide.model.PushDO;
import com.taobao.slide.model.TraceDO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tb.o22;

/* compiled from: Taobao */
public class PushTask implements Runnable {
    public static final int PUSH_TYPE_POD = 1;
    public static final int PUSH_TYPE_TRACE = 2;
    private static final String TAG = "PushTask";
    public static Set<PodDO> waitingPods;
    public static Set<String> waitingTracePod;
    private b engine;
    private String podInfo;

    public PushTask(String str, b bVar) {
        this.podInfo = str;
        this.engine = bVar;
    }

    public void run() {
        List<String> list;
        try {
            o22.g(TAG, TAG, "pushinfo", this.podInfo);
            if (!TextUtils.isEmpty(this.podInfo)) {
                PushDO pushDO = (PushDO) JSON.parseObject(this.podInfo, PushDO.class);
                if (pushDO == null || !pushDO.isValid()) {
                    throw new SlideException(1030, "pod null or invalid");
                }
                int i = pushDO.type;
                if (i == 2) {
                    TraceDO.PodNames podNames = (TraceDO.PodNames) JSON.parseObject(pushDO.payload, TraceDO.PodNames.class);
                    if (podNames == null || (list = podNames.pods) == null || list.size() == 0) {
                        o22.e(TAG, "PushTask trace no pods", new Object[0]);
                        return;
                    }
                    if (waitingTracePod == null) {
                        waitingTracePod = new HashSet(podNames.pods);
                    }
                    b bVar = this.engine;
                    if (bVar == null || bVar.d() == null) {
                        o22.g(TAG, "PushTask trace add waiting  pod", "pod", podNames.pods.toString());
                        waitingTracePod.addAll(podNames.pods);
                        return;
                    }
                    this.engine.n(podNames.pods);
                } else if (i == 1) {
                    PodDO podDO = (PodDO) JSON.parseObject(pushDO.payload, PodDO.class);
                    podDO.pushType = pushDO.type;
                    b bVar2 = this.engine;
                    if (bVar2 == null || bVar2.d() == null) {
                        if (waitingPods == null) {
                            waitingPods = new HashSet();
                        }
                        o22.g(TAG, "PushTask add waiting push pod", "pod", podDO);
                        waitingPods.add(podDO);
                        return;
                    }
                    this.engine.m(podDO);
                }
            } else {
                throw new SlideException(1030, "pod null");
            }
        } catch (Throwable th) {
            o22.d(TAG, "push task handle error!", th, new Object[0]);
        }
    }
}
