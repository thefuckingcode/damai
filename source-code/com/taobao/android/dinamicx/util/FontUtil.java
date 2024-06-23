package com.taobao.android.dinamicx.util;

import android.graphics.Typeface;
import android.os.Looper;
import android.util.LruCache;
import com.taobao.android.dinamicx.DinamicXEngine;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.c00;

/* compiled from: Taobao */
public class FontUtil {
    private LruCache<String, Typeface> a;

    /* compiled from: Taobao */
    private class FontRunnable implements Runnable {
        String font;
        int fontStyle;
        CountDownLatch latch;
        Typeface tf;

        public FontRunnable(CountDownLatch countDownLatch, String str, int i) {
            this.latch = countDownLatch;
            this.font = str;
            this.fontStyle = i;
        }

        public void run() {
            try {
                Typeface createFromAsset = Typeface.createFromAsset(DinamicXEngine.i().getAssets(), this.font);
                FontUtil.this.a.put(this.font, createFromAsset);
                this.tf = Typeface.create(createFromAsset, this.fontStyle);
            } catch (Throwable th) {
                this.latch.countDown();
                throw th;
            }
            this.latch.countDown();
        }
    }

    /* compiled from: Taobao */
    private static class b {
        private static final FontUtil a = new FontUtil();
    }

    public static final FontUtil c() {
        return b.a;
    }

    public Typeface b(String str, int i) throws InterruptedException {
        Typeface typeface = this.a.get(str);
        if (typeface != null) {
            return typeface;
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            Typeface createFromAsset = Typeface.createFromAsset(DinamicXEngine.i().getAssets(), str);
            this.a.put(str, createFromAsset);
            return Typeface.create(createFromAsset, i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        FontRunnable fontRunnable = new FontRunnable(countDownLatch, str, i);
        c00.o(fontRunnable);
        countDownLatch.await(2, TimeUnit.SECONDS);
        return fontRunnable.tf;
    }

    private FontUtil() {
        this.a = null;
        this.a = new LruCache<>(5);
    }
}
