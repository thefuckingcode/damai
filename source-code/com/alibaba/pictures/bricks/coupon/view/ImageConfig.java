package com.alibaba.pictures.bricks.coupon.view;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ImageConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;
    private boolean b;
    private boolean c;
    @Nullable
    private DMImageCropType d;
    private int e;
    private boolean f;
    private int g = -1;
    private int h = -1;
    @Nullable
    private DMImageQuality i;

    /* compiled from: Taobao */
    public enum DMImageCropType {
        cy500,
        cy100
    }

    /* compiled from: Taobao */
    public enum DMImageQuality {
        q90,
        q75,
        q60,
        q50,
        q30,
        non
    }

    /* compiled from: Taobao */
    public enum DMImageSizeLimitType {
        WIDTH_LIMIT,
        HEIGHT_LIMIT,
        ALL_LIMIT
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-730500638")) {
            return this.e;
        }
        return ((Integer) ipChange.ipc$dispatch("-730500638", new Object[]{this})).intValue();
    }

    @Nullable
    public final DMImageCropType b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-244231152")) {
            return this.d;
        }
        return (DMImageCropType) ipChange.ipc$dispatch("-244231152", new Object[]{this});
    }

    @Nullable
    public final DMImageQuality c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1154618586")) {
            return this.i;
        }
        return (DMImageQuality) ipChange.ipc$dispatch("1154618586", new Object[]{this});
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1823514561")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1823514561", new Object[]{this})).booleanValue();
    }

    public final boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-844181148")) {
            return this.a;
        }
        return ((Boolean) ipChange.ipc$dispatch("-844181148", new Object[]{this})).booleanValue();
    }

    public final boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1160370110")) {
            return this.c;
        }
        return ((Boolean) ipChange.ipc$dispatch("1160370110", new Object[]{this})).booleanValue();
    }

    public final boolean g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1437869787")) {
            return this.f;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1437869787", new Object[]{this})).booleanValue();
    }

    public final int h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "621262795")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("621262795", new Object[]{this})).intValue();
    }

    public final int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "624605112")) {
            return this.h;
        }
        return ((Integer) ipChange.ipc$dispatch("624605112", new Object[]{this})).intValue();
    }

    public final void j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "584056419")) {
            ipChange.ipc$dispatch("584056419", new Object[]{this, str});
        }
    }

    public final void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881618432")) {
            ipChange.ipc$dispatch("881618432", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.e = i2;
    }

    public final void l(@Nullable DMImageCropType dMImageCropType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107186026")) {
            ipChange.ipc$dispatch("-2107186026", new Object[]{this, dMImageCropType});
            return;
        }
        this.d = dMImageCropType;
    }

    public final void m(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305254291")) {
            ipChange.ipc$dispatch("-1305254291", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.b = z;
    }

    public final void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339918976")) {
            ipChange.ipc$dispatch("-1339918976", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.a = z;
    }

    public final void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1763152946")) {
            ipChange.ipc$dispatch("-1763152946", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.c = z;
    }

    public final void p(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911966175")) {
            ipChange.ipc$dispatch("911966175", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.f = z;
    }

    public final void q(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441528777")) {
            ipChange.ipc$dispatch("-1441528777", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
    }

    public final void r(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563055534")) {
            ipChange.ipc$dispatch("-563055534", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h = i2;
    }
}
