package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import android.os.Process;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.i91;

/* compiled from: Taobao */
public class EngineThread extends Thread {
    private String TAG = "WSEngineThread";
    private ExecutorService executorService;
    private ArrayBlockingQueue<a.C0086a> jobQueue = new ArrayBlockingQueue<>(10);
    private boolean stop;

    /* access modifiers changed from: package-private */
    public void add(final a.C0086a aVar) {
        if (!this.jobQueue.offer(aVar)) {
            i91.b(this.TAG, "Offer response to Engine failed!start an thread to put.");
            if (this.executorService == null) {
                this.executorService = Executors.newCachedThreadPool();
            }
            this.executorService.execute(new Runnable() {
                /* class com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.EngineThread.AnonymousClass1 */

                public void run() {
                    if (!EngineThread.this.stop) {
                        try {
                            EngineThread.this.jobQueue.put(aVar);
                        } catch (Exception e) {
                            if (EngineThread.this.stop) {
                                i91.c(EngineThread.this.TAG, "put response failed!", e);
                            } else {
                                EngineThread.this.interrupt();
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void quit() {
        this.stop = true;
        this.jobQueue.clear();
        interrupt();
    }

    public void run() {
        super.run();
        Process.setThreadPriority(10);
        while (!this.stop) {
            try {
                a.C0086a take = this.jobQueue.take();
                if (take.a) {
                    take.d.onSendDataError(take.c, take.e);
                } else {
                    take.b.onResponse(take.d, take.e);
                }
                a.C0086a.b(take);
            } catch (InterruptedException unused) {
                if (this.stop) {
                    return;
                }
            } catch (Exception e) {
                i91.c(this.TAG, "run()->Exception", e);
            }
        }
    }

    public synchronized void start() {
        this.stop = false;
        super.start();
    }
}
