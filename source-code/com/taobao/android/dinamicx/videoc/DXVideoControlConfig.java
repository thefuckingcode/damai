package com.taobao.android.dinamicx.videoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.n10;
import tb.xv2;

/* compiled from: Taobao */
public class DXVideoControlConfig<VideoData> {
    public static final int DEFAULT_MAX_PLAYING_VIDEO = 1;
    public static final long DEFAULT_PLAY_DELAY = 300;
    public static final String DEFAULT_SCENE_NAME = "video";
    public static final float DEFAULT_VIEW_AREA_PERCENT = 0.8f;
    public static final int PLAY_ORDER_POSITIVE = 0;
    public static final int PLAY_ORDER_REVERSE = 1;
    private float a;
    private long b;
    private final Map<String, List<Class<? extends DXWidgetNode>>> c = new HashMap();
    private Comparator<VideoData> d;
    private int e;
    private boolean f = false;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface PlayOrder {
    }

    private DXVideoControlConfig() {
    }

    public static DXVideoControlConfig<xv2> j() {
        return k().h(new n10());
    }

    public static <VideoData> DXVideoControlConfig<VideoData> k() {
        return new DXVideoControlConfig().i(0.8f).b(1).c(300).d(0);
    }

    public DXVideoControlConfig<VideoData> a(boolean z) {
        this.f = z;
        return this;
    }

    public DXVideoControlConfig<VideoData> b(int i2) {
        this.g = Math.max(1, i2);
        return this;
    }

    public DXVideoControlConfig<VideoData> c(long j2) {
        this.b = Math.max(j2, 0L);
        return this;
    }

    public DXVideoControlConfig<VideoData> d(int i2) {
        this.e = i2;
        return this;
    }

    public DXVideoControlConfig<VideoData> e(boolean z) {
        this.j = z;
        return this;
    }

    @SafeVarargs
    public final DXVideoControlConfig<VideoData> f(@NonNull String str, Class<? extends DXWidgetNode>... clsArr) {
        List<Class<? extends DXWidgetNode>> list = this.c.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(Arrays.asList(clsArr));
        this.c.put(str, list);
        return this;
    }

    @SafeVarargs
    public final DXVideoControlConfig<VideoData> g(Class<? extends DXWidgetNode>... clsArr) {
        return f("video", clsArr);
    }

    public DXVideoControlConfig<VideoData> h(@NonNull Comparator<VideoData> comparator) {
        this.d = comparator;
        return this;
    }

    public DXVideoControlConfig<VideoData> i(float f2) {
        if (f2 > 1.0f || f2 < 0.0f) {
            f2 = 0.8f;
        }
        this.a = f2;
        return this;
    }

    public int l() {
        return this.g;
    }

    public long m() {
        return this.b;
    }

    public int n() {
        return this.e;
    }

    @NonNull
    public Map<String, List<Class<? extends DXWidgetNode>>> o() {
        return this.c;
    }

    @Nullable
    public Comparator<VideoData> p() {
        return this.d;
    }

    public float q() {
        return this.a;
    }

    public boolean r() {
        return this.i;
    }

    public boolean s() {
        return this.h;
    }

    public boolean t() {
        return this.f;
    }

    public boolean u() {
        return this.j;
    }

    public DXVideoControlConfig<VideoData> v(@NonNull String str) {
        HashSet hashSet = new HashSet();
        for (List<Class<? extends DXWidgetNode>> list : this.c.values()) {
            hashSet.addAll(list);
        }
        this.c.clear();
        this.c.put(str, new ArrayList(hashSet));
        return this;
    }
}
