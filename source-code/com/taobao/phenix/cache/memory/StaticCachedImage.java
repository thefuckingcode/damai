package com.taobao.phenix.cache.memory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.Map;
import java.util.WeakHashMap;
import tb.jl1;
import tb.me;
import tb.pb2;
import tb.pz1;
import tb.so1;
import tb.vr2;

/* compiled from: Taobao */
public class StaticCachedImage extends me {
    private static final Map<Bitmap, Map<StaticCachedImage, Boolean>> l = new WeakHashMap(300);
    final Bitmap i;
    final Rect j;
    private StaticImageRecycleListener k;

    /* compiled from: Taobao */
    public interface StaticImageRecycleListener {
        void recycle(StaticCachedImage staticCachedImage);
    }

    public StaticCachedImage(Bitmap bitmap, Rect rect, String str, String str2, int i2, int i3) {
        super(str, str2, i2, i3);
        this.i = bitmap;
        this.j = rect;
        k();
        vr2.a(a.TAG_RECYCLE, "new image=%s", this);
    }

    private void k() {
        Map<Bitmap, Map<StaticCachedImage, Boolean>> map = l;
        synchronized (map) {
            Map<StaticCachedImage, Boolean> map2 = map.get(this.i);
            if (map2 == null) {
                map2 = new WeakHashMap<>(1);
                map.put(this.i, map2);
            }
            map2.put(this, Boolean.TRUE);
        }
    }

    @Override // tb.me
    public int c() {
        return pb2.b(this.i);
    }

    /* access modifiers changed from: protected */
    @Override // tb.me
    public so1 d(String str, String str2, int i2, int i3, boolean z, Resources resources) {
        if (z) {
            return new pz1(resources, this.i, this.j, str, str2, i2, i3);
        }
        return new so1(resources, this.i, this.j, str, str2, i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // tb.me
    public void f() {
        boolean z;
        StaticImageRecycleListener staticImageRecycleListener;
        Map<Bitmap, Map<StaticCachedImage, Boolean>> map = l;
        synchronized (map) {
            Map<StaticCachedImage, Boolean> map2 = map.get(this.i);
            boolean z2 = true;
            z = false;
            if (map2 != null) {
                map2.remove(this);
                int size = map2.size();
                if (size == 0) {
                    map.remove(this.i);
                    vr2.a(a.TAG_RECYCLE, "bitmap in the image can be recycled now, image=%s", this);
                } else {
                    vr2.i(a.TAG_RECYCLE, "cannot recycled the image(bitmap referenced by %d image still), image=%s", Integer.valueOf(size), this);
                    z2 = false;
                }
                z = z2;
            } else {
                vr2.i(a.TAG_RECYCLE, "cannot recycled the image(bitmap has been recycled ever), image=%s", this);
            }
        }
        if (z && (staticImageRecycleListener = this.k) != null) {
            staticImageRecycleListener.recycle(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.me
    public void g() {
        vr2.a(a.TAG_RECYCLE, "image change to not recycled, image=%s", this);
        k();
    }

    public StaticCachedImage l(StaticImageRecycleListener staticImageRecycleListener) {
        this.k = staticImageRecycleListener;
        return this;
    }

    @Override // tb.me
    public String toString() {
        return "StaticCachedImage(" + Integer.toHexString(hashCode()) + ", bmp@" + this.i + ", key@" + b() + jl1.BRACKET_END_STR;
    }
}
