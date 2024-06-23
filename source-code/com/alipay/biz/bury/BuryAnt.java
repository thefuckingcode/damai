package com.alipay.biz.bury;

/* compiled from: Taobao */
public class BuryAnt {
    public long signature = System.currentTimeMillis();

    public void forceToDeath() {
        this.signature = -1;
    }
}
