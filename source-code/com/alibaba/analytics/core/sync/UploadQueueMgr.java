package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tb.gj2;

/* compiled from: Taobao */
public class UploadQueueMgr implements Runnable {
    public static final String MSGTYPE_INTERVAL = "i";
    public static final String MSGTYPE_REALTIME = "r";
    private static UploadQueueMgr mUploadQueueMgr = new UploadQueueMgr();
    private static BlockingQueue<String> queueCache = new LinkedBlockingQueue();
    private boolean isRunning = false;

    public static UploadQueueMgr getInstance() {
        return mUploadQueueMgr;
    }

    public void add(String str) {
        if (!queueCache.contains(str)) {
            try {
                queueCache.put(str);
                Logger.f("", "queueCache put", str, "queueCache size", Integer.valueOf(queueCache.size()));
            } catch (Exception e) {
                Logger.f("", e);
            }
        } else {
            Logger.f("", "queueCache contains", str);
        }
    }

    public void run() {
        while (this.isRunning) {
            try {
                String take = queueCache.take();
                Logger.f("", "take queueCache size", Integer.valueOf(queueCache.size()));
                if ("i".equals(take)) {
                    f.i().m();
                } else if (MSGTYPE_REALTIME.equals(take)) {
                    e.h().j();
                }
            } catch (Throwable th) {
                Logger.f("", th);
            }
        }
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            gj2.c().d(null, getInstance(), 0);
        }
    }
}
