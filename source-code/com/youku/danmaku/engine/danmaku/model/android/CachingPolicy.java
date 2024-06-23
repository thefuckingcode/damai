package com.youku.danmaku.engine.danmaku.model.android;

import android.os.Build;

/* compiled from: Taobao */
public class CachingPolicy {
    public static final int BMP_BPP_ARGB_4444 = 16;
    public static final int BMP_BPP_ARGB_8888 = 32;
    public static final int CACHE_PERIOD_AUTO = 0;
    public static final int CACHE_PERIOD_NOT_RECYCLE = -1;
    public static final CachingPolicy POLICY_DEFAULT;
    public static final CachingPolicy POLICY_GREEDY = new CachingPolicy(16, 0.5f, -1, 50, 0.005f);
    public static final CachingPolicy POLICY_LAZY;
    public int bitsPerPixelOfCache = 16;
    public float forceRecyleThreshold = 0.01f;
    public float maxCachePoolSizeFactorPercentage;
    public int maxTimesOfReusableFinds = 150;
    public int maxTimesOfStrictReusableFinds = 20;
    public long periodOfRecycle = 0;
    public int reusableOffsetPixel = 0;

    static {
        CachingPolicy cachingPolicy = new CachingPolicy(16, 0.1f, 0, 50, 0.01f);
        POLICY_LAZY = cachingPolicy;
        POLICY_DEFAULT = cachingPolicy;
    }

    public CachingPolicy(int i, float f, long j, int i2, float f2) {
        this.bitsPerPixelOfCache = i;
        if (Build.VERSION.SDK_INT >= 19) {
            this.bitsPerPixelOfCache = 32;
        }
        this.maxCachePoolSizeFactorPercentage = f;
        this.periodOfRecycle = j;
        this.reusableOffsetPixel = i2;
        this.forceRecyleThreshold = f2;
    }
}
