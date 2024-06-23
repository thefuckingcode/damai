package com.taobao.android.launcher.biz.task;

/* compiled from: Taobao */
class Helpers {
    Helpers() {
    }

    static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
