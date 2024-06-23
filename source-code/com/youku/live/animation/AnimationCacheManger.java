package com.youku.live.animation;

import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGAVideoEntity;

/* compiled from: Taobao */
public class AnimationCacheManger {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile AnimationCacheManger sInstance;
    private final int CACHE_SIZE = 52428800;
    private LruCache<String, SVGAVideoEntity> mLruCache = new LruCache<String, SVGAVideoEntity>(52428800) {
        /* class com.youku.live.animation.AnimationCacheManger.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* access modifiers changed from: protected */
        public int sizeOf(String str, SVGAVideoEntity sVGAVideoEntity) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1473588602")) {
                return super.sizeOf((Object) str, (Object) sVGAVideoEntity);
            }
            return ((Integer) ipChange.ipc$dispatch("1473588602", new Object[]{this, str, sVGAVideoEntity})).intValue();
        }
    };

    private AnimationCacheManger() {
    }

    public static AnimationCacheManger getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102429233")) {
            return (AnimationCacheManger) ipChange.ipc$dispatch("-1102429233", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (AnimationCacheManger.class) {
                if (sInstance == null) {
                    sInstance = new AnimationCacheManger();
                }
            }
        }
        return sInstance;
    }

    public void addCache(String str, SVGAVideoEntity sVGAVideoEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48721437")) {
            ipChange.ipc$dispatch("48721437", new Object[]{this, str, sVGAVideoEntity});
            return;
        }
        this.mLruCache.put(str, sVGAVideoEntity);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450648462")) {
            ipChange.ipc$dispatch("1450648462", new Object[]{this});
            return;
        }
        this.mLruCache.evictAll();
    }

    public SVGAVideoEntity getDrawableFromCache(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1169497862")) {
            return this.mLruCache.get(str);
        }
        return (SVGAVideoEntity) ipChange.ipc$dispatch("-1169497862", new Object[]{this, str});
    }

    public void removeDrawable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752492873")) {
            ipChange.ipc$dispatch("-1752492873", new Object[]{this, str});
            return;
        }
        this.mLruCache.remove(str);
    }
}
