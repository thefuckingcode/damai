package com.youku.danmaku.engine.controller;

/* compiled from: Taobao */
public class UpdateThread extends Thread {
    volatile boolean mIsQuited;

    public UpdateThread(String str) {
        super(str);
    }

    public boolean isQuited() {
        return this.mIsQuited;
    }

    public void quit() {
        this.mIsQuited = true;
    }

    public void run() {
    }
}
