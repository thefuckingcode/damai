package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LazyDrawable extends BitmapDrawable {
    private static transient /* synthetic */ IpChange $ipChange;
    public Drawable drawable;

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078439473")) {
            ipChange.ipc$dispatch("-1078439473", new Object[]{this, canvas});
            return;
        }
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705951001")) {
            ipChange.ipc$dispatch("705951001", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.setBounds(i, i2, i3, i4);
        if (this.drawable == null) {
            ColorDrawable colorDrawable = new ColorDrawable(SupportMenu.CATEGORY_MASK);
            this.drawable = colorDrawable;
            colorDrawable.setBounds(i, i2, i3, i4);
        }
    }
}
