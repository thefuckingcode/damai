package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTPageHitHelper;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tb.gj2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class RepeatExposureQueueMgr implements Runnable {
    private static final Map<String, String> EMPTY_MAP = new HashMap();
    private static final String TAG = "RepeatExposureQueueMgr";
    private static RepeatExposureQueueMgr mRepeatExposureQueueMgr = new RepeatExposureQueueMgr();
    private boolean isOpenLog = false;
    private boolean isRunning = false;
    private HashSet<Integer> mExposureSet = new HashSet<>();
    private BlockingQueue<Map<String, String>> mQueueCache = new LinkedBlockingQueue();
    private Map<String, String> mSortMap = new TreeMap(new Comparator<String>() {
        /* class com.ut.mini.RepeatExposureQueueMgr.AnonymousClass1 */

        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    });

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class RepeatExposurePageChangerMonitor implements UTPageHitHelper.PageChangeListener {
        RepeatExposurePageChangerMonitor() {
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageAppear(Object obj) {
            RepeatExposureQueueMgr.getInstance().putClearEvent();
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageDisAppear(Object obj) {
            RepeatExposureQueueMgr.getInstance().putClearEvent();
        }
    }

    RepeatExposureQueueMgr() {
    }

    public static RepeatExposureQueueMgr getInstance() {
        return mRepeatExposureQueueMgr;
    }

    private synchronized int getMapHashCode(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                this.mSortMap.putAll(map);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.mSortMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        sb.append(key);
                    }
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        sb.append(value);
                    }
                }
                this.mSortMap.clear();
                return sb.toString().hashCode();
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void putClearEvent() {
        if (this.isRunning) {
            this.mQueueCache.add(EMPTY_MAP);
        }
    }

    /* access modifiers changed from: package-private */
    public void putExposureEvent(Map<String, String> map) {
        if (this.isRunning && map != null && !map.isEmpty()) {
            this.mQueueCache.add(map);
        }
    }

    public void run() {
        int i;
        int i2 = 0;
        while (true) {
            if (this.isRunning || i2 > 0) {
                try {
                    if (this.isOpenLog) {
                        Logger.f(TAG, "------");
                        Logger.f(TAG, "take mQueueCache size", Integer.valueOf(this.mQueueCache.size()));
                        Logger.f(TAG, "mExposureSet size", Integer.valueOf(this.mExposureSet.size()));
                    }
                    Map<String, String> take = this.mQueueCache.take();
                    if (this.isOpenLog) {
                        long currentTimeMillis = System.currentTimeMillis();
                        i = getMapHashCode(take);
                        Logger.f(TAG, "getMapHashCode cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        i = getMapHashCode(take);
                    }
                    if (i == 0) {
                        Logger.f(TAG, "clear ExposureSet");
                        this.mExposureSet.clear();
                    } else if (this.mExposureSet.contains(Integer.valueOf(i))) {
                        Logger.f(TAG, "repeat Exposure");
                    } else {
                        this.mExposureSet.add(Integer.valueOf(i));
                        Logger.f(TAG, "send Exposure");
                        UTAnalytics.getInstance().transferLog(take);
                    }
                    i2 = this.mQueueCache.size();
                    if (this.isOpenLog) {
                        Logger.f(TAG, "isRunning", Boolean.valueOf(this.isRunning), "mQueueCache size", Integer.valueOf(i2));
                    }
                } catch (Throwable th) {
                    Logger.f("", th);
                }
            } else {
                return;
            }
        }
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            gj2.c().f(getInstance());
            UTPageHitHelper.addPageChangerListener(new RepeatExposurePageChangerMonitor());
        }
    }

    public synchronized void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            try {
                this.mQueueCache.clear();
                this.mExposureSet.clear();
            } catch (Exception unused) {
            }
        }
    }
}
