package com.ut.mini.behavior.trigger;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.UTEvent;
import com.ut.mini.behavior.config.UTBehaviorConfigMgr;
import java.util.List;
import java.util.Map;
import tb.zf2;

/* compiled from: Taobao */
public class TriggerMgr {
    private static final String TAG = "TriggerMgr";
    private final Object Lock_Object;
    private TriggerConfig mTriggerConfig;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        private static TriggerMgr instance = new TriggerMgr();

        private SingletonHolder() {
        }
    }

    public static TriggerMgr getInstance() {
        return SingletonHolder.instance;
    }

    public List<Scene> getSceneList() {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null) {
                if (UTBehaviorConfigMgr.enableSample((long) triggerConfig.enableSample)) {
                    return this.mTriggerConfig.sceneList;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void init(String str) {
        if (zf2.f(str)) {
            this.mTriggerConfig = null;
            return;
        }
        try {
            this.mTriggerConfig = (TriggerConfig) JSON.parseObject(str, TriggerConfig.class);
        } catch (Exception e) {
            Logger.h(TAG, e, new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r6.event == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (com.ut.mini.behavior.data.DataType.Event.getValue().equals(r6.event.type) != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return com.ut.mini.behavior.expression.ExpressionEvaluator.getInstance().evaluateData(r6.event.data, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r6 == null) goto L_0x0037;
     */
    public boolean triggerEvent(Scene scene, Map<String, String> map) {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null) {
                if (!UTBehaviorConfigMgr.enableSample((long) triggerConfig.enableSample)) {
                }
            }
            return false;
        }
    }

    private TriggerMgr() {
        this.Lock_Object = new Object();
    }

    public void init(TriggerConfig triggerConfig) {
        synchronized (this.Lock_Object) {
            this.mTriggerConfig = triggerConfig;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r6.event == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (com.ut.mini.behavior.data.DataType.Begin.getValue().equals(r6.event.type) != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return com.ut.mini.behavior.expression.ExpressionEvaluator.getInstance().evaluateData(r6.event.data, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r6 == null) goto L_0x0037;
     */
    public boolean triggerEvent(Scene scene, UTEvent uTEvent) {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null) {
                if (!UTBehaviorConfigMgr.enableSample((long) triggerConfig.enableSample)) {
                }
            }
            return false;
        }
    }
}
