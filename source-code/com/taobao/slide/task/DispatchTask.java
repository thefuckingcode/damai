package com.taobao.slide.task;

import com.taobao.slide.api.SlideLoad;
import com.taobao.slide.api.SlideSubscriber;
import com.taobao.slide.model.ResultDO;
import java.util.Map;
import tb.if1;
import tb.o22;

/* compiled from: Taobao */
public class DispatchTask implements Runnable {
    private static final String TAG = "Dispatch";
    private Map<String, ResultDO> notifyResults;
    private SlideSubscriber subscriber;

    public DispatchTask(SlideSubscriber slideSubscriber, Map<String, ResultDO> map) {
        this.subscriber = slideSubscriber;
        this.notifyResults = map;
    }

    public void run() {
        try {
            for (Map.Entry<String, ResultDO> entry : this.notifyResults.entrySet()) {
                if1.a(if1.POINT_NOTIFY, String.format("%s:%s", entry.getValue().name, entry.getValue().version));
                if (SlideLoad.f) {
                    o22.c(TAG, "dispatch ", entry.getValue().toString());
                }
            }
            o22.g(TAG, "onNotify", this.notifyResults.keySet().toString());
            this.subscriber.f(this.notifyResults);
        } catch (Throwable th) {
            o22.d(TAG, "run", th, new Object[0]);
        }
    }
}
