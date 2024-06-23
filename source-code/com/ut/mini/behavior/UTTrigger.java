package com.ut.mini.behavior;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTEvent;
import com.ut.mini.behavior.trigger.Scene;
import com.ut.mini.behavior.trigger.TriggerMgr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import tb.gj2;
import tb.nt2;
import tb.zf2;

/* compiled from: Taobao */
public class UTTrigger {
    private static final String TAG = "UTTrigger";
    private nt2 mHandler;
    private Map<String, List<UTTriggerObserver>> mUTTriggerObserverMap;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        private static UTTrigger instance = new UTTrigger();

        private SingletonHolder() {
        }
    }

    public static UTTrigger getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void observeTrigger(final String str, String str2, UTEvent uTEvent) {
        if (uTEvent != null) {
            uTEvent.addSceneName(str);
            if (zf2.f(str2)) {
                observeTrigger(str);
            } else if (str2.startsWith("delay")) {
                try {
                    int parseInt = Integer.parseInt(str2.substring(6));
                    ScheduledFuture d = gj2.c().d(null, new Runnable() {
                        /* class com.ut.mini.behavior.UTTrigger.AnonymousClass3 */

                        public void run() {
                            UTTrigger.this.observeTrigger(str);
                        }
                    }, (long) parseInt);
                    Logger.f(TAG, "triggerObserverDelay", str, "delayTime", Integer.valueOf(parseInt));
                    uTEvent.addScheduledFuture(d);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void triggerEvent(Map<String, String> map) {
        List<Scene> sceneList = TriggerMgr.getInstance().getSceneList();
        if (sceneList != null) {
            for (Scene scene : sceneList) {
                if (TriggerMgr.getInstance().triggerEvent(scene, map)) {
                    observeTrigger(scene.name);
                }
            }
        }
    }

    public synchronized void registerTrigger(String str, UTTriggerObserver uTTriggerObserver) {
        if (!TextUtils.isEmpty(str)) {
            if (uTTriggerObserver != null) {
                List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.mUTTriggerObserverMap.put(str, list);
                }
                if (!list.contains(uTTriggerObserver)) {
                    list.add(uTTriggerObserver);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerEventAsync(final Map<String, String> map) {
        if (this.mHandler != null && map != null) {
            this.mHandler.b(new Runnable() {
                /* class com.ut.mini.behavior.UTTrigger.AnonymousClass1 */

                public void run() {
                    try {
                        UTTrigger.this.triggerEvent((UTTrigger) map);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public synchronized void unRegisterTrigger(String str, UTTriggerObserver uTTriggerObserver) {
        if (!TextUtils.isEmpty(str)) {
            if (uTTriggerObserver != null) {
                List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
                if (list != null) {
                    list.remove(uTTriggerObserver);
                }
            }
        }
    }

    private UTTrigger() {
        try {
            this.mHandler = new nt2();
        } catch (Exception unused) {
        }
        this.mUTTriggerObserverMap = new ConcurrentHashMap();
    }

    /* access modifiers changed from: package-private */
    public void triggerEventAsync(final UTEvent uTEvent) {
        if (this.mHandler != null && uTEvent != null) {
            this.mHandler.b(new Runnable() {
                /* class com.ut.mini.behavior.UTTrigger.AnonymousClass2 */

                public void run() {
                    try {
                        UTTrigger.this.triggerEvent((UTTrigger) uTEvent);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void triggerEvent(UTEvent uTEvent) {
        List<Scene> sceneList = TriggerMgr.getInstance().getSceneList();
        if (sceneList != null) {
            for (Scene scene : sceneList) {
                if (uTEvent.containScene(scene.name)) {
                    Logger.f(TAG, "containScene", scene.name);
                } else if (TriggerMgr.getInstance().triggerEvent(scene, uTEvent)) {
                    observeTrigger(scene.name, scene.condition, uTEvent);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void observeTrigger(String str) {
        try {
            List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
            Logger.f(TAG, "triggerObserver", str);
            if (list != null) {
                for (UTTriggerObserver uTTriggerObserver : list) {
                    uTTriggerObserver.onTrigger(str);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
