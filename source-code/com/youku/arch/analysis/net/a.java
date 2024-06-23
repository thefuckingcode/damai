package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    private int g;

    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2059168322")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("-2059168322", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007b  */
    public void b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059138518")) {
            ipChange.ipc$dispatch("-2059138518", new Object[]{this});
            return;
        }
        int i8 = this.a;
        if (i8 == 1) {
            i3 = 1;
        } else if (i8 == 2) {
            i3 = 0;
            i2 = 1;
            i = 0;
            i4 = this.b;
            if (i4 == 1) {
            }
            i5 = this.c;
            if (i5 == 1) {
            }
            i6 = this.d;
            if (i6 == 1) {
            }
            i7 = this.e;
            if (i7 == 1) {
            }
            if (i3 >= 1) {
            }
        } else if (i8 != 3) {
            i3 = 0;
        } else {
            i3 = 0;
            i2 = 0;
            i = 1;
            i4 = this.b;
            if (i4 == 1) {
                i3++;
            } else if (i4 == 2) {
                i2++;
            } else if (i4 == 3) {
                i++;
            }
            i5 = this.c;
            if (i5 == 1) {
                i3++;
            } else if (i5 == 2) {
                i2++;
            } else if (i5 == 3) {
                i++;
            }
            i6 = this.d;
            if (i6 == 1) {
                i3++;
            } else if (i6 == 2) {
                i2++;
            } else if (i6 == 3) {
                i++;
            }
            i7 = this.e;
            if (i7 == 1) {
                i3++;
            } else if (i7 == 2) {
                i2++;
            } else if (i7 == 3) {
                i++;
            }
            if (i3 >= 1) {
                com.youku.b.a.a.a("NetQualityInfo", "get final network quality:1");
                this.g = 1;
                return;
            } else if (i > i2 && i3 == 0) {
                com.youku.b.a.a.a("NetQualityInfo", "get final network quality:3");
                this.g = 3;
                return;
            } else if (i + i2 + i3 == 0) {
                com.youku.b.a.a.a("NetQualityInfo", "get final network quality:0");
                this.g = 0;
                return;
            } else {
                com.youku.b.a.a.a("NetQualityInfo", "get final network quality:2");
                this.g = 2;
                return;
            }
        }
        i2 = 0;
        i = 0;
        i4 = this.b;
        if (i4 == 1) {
        }
        i5 = this.c;
        if (i5 == 1) {
        }
        i6 = this.d;
        if (i6 == 1) {
        }
        i7 = this.e;
        if (i7 == 1) {
        }
        if (i3 >= 1) {
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629867406")) {
            return (String) ipChange.ipc$dispatch("629867406", new Object[]{this});
        }
        return this.a + this.b + this.c + this.d + this.e + ",netscore:" + this.g;
    }
}
