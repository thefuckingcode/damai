package cn.damai.uikit.view.avatar;

import android.content.Context;
import tb.m42;

/* compiled from: Taobao */
public enum AvatarSize {
    SIZE_30x30(30, 12, 2),
    SIZE_40x40(40, 12, 2),
    SIZE_50x50(50, 18, 3),
    SIZE_60x60(60, 24, 3),
    SIZE_80x80(80, 24, 4),
    SIZE_100x100(100, 24, 4);
    
    public final int borderWidthDp;
    public final int rbTagSizeDp;
    public final int viewSizeDp;

    private AvatarSize(int i, int i2, int i3) {
        this.viewSizeDp = i;
        this.rbTagSizeDp = i2;
        this.borderWidthDp = i3;
    }

    public static AvatarSize get(int i) {
        if (i == 0) {
            return SIZE_30x30;
        }
        if (i == 1) {
            return SIZE_40x40;
        }
        if (i == 2) {
            return SIZE_50x50;
        }
        if (i == 4) {
            return SIZE_80x80;
        }
        if (i != 5) {
            return SIZE_60x60;
        }
        return SIZE_100x100;
    }

    public int getOutBorderSizePx(Context context) {
        return m42.a(context, (float) this.borderWidthDp);
    }

    public int getRbTagSizePx(Context context) {
        return m42.a(context, (float) this.rbTagSizeDp);
    }

    public int getViewSizePx(Context context) {
        return m42.a(context, (float) this.viewSizeDp);
    }
}
