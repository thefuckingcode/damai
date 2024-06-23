package com.youku.asyncview;

import java.io.Serializable;

/* compiled from: Taobao */
public final class AsyncViewSetting implements Serializable {
    private int mCacheSize;
    private int mInitNum;
    private int mLayoutId;
    private AsyncViewPriority mPriority;
    private IViewCreator mViewCreator;

    /* compiled from: Taobao */
    public enum AsyncViewPriority {
        LOW,
        NORMAL,
        HIGH
    }

    public AsyncViewSetting(int i, int i2, int i3, AsyncViewPriority asyncViewPriority, IViewCreator iViewCreator) {
        this.mLayoutId = i;
        this.mInitNum = i2;
        this.mPriority = asyncViewPriority;
        this.mCacheSize = i3;
        this.mViewCreator = iViewCreator;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public int getInitNum() {
        return this.mInitNum;
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }

    public AsyncViewPriority getPriority() {
        return this.mPriority;
    }

    public IViewCreator getViewCreater() {
        return this.mViewCreator;
    }
}
