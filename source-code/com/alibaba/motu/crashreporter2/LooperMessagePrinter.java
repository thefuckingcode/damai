package com.alibaba.motu.crashreporter2;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.util.Printer;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class LooperMessagePrinter implements Printer {
    private final Callback callback;
    private long cpuTime = SystemClock.currentThreadTimeMillis();
    private MessageMaker maker = new MessageMaker();
    private long startedTime = SystemClock.uptimeMillis();

    /* compiled from: Taobao */
    public interface Callback {
        void onLongMessage(String str);

        void onMessage(String str);
    }

    public LooperMessagePrinter(Callback callback2) {
        this.callback = callback2;
    }

    @TargetApi(23)
    public void println(String str) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.startedTime;
        String createMessage = this.maker.createMessage(str, uptimeMillis, SystemClock.currentThreadTimeMillis() - this.cpuTime);
        if (uptimeMillis > 500 && !str.startsWith(">>")) {
            this.callback.onLongMessage(createMessage);
        }
        this.callback.onMessage(createMessage);
        this.startedTime = SystemClock.uptimeMillis();
        this.cpuTime = SystemClock.currentThreadTimeMillis();
    }
}
