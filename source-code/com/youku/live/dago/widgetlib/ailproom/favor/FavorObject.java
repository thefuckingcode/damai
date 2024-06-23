package com.youku.live.dago.widgetlib.ailproom.favor;

import android.graphics.drawable.Drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FavorObject {
    private static transient /* synthetic */ IpChange $ipChange;
    private float alpha;
    private Drawable drawable;
    private float scaleX;
    private float scaleY;
    private float x;
    private float y;

    public float getAlpha() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2031062550")) {
            return this.alpha;
        }
        return ((Float) ipChange.ipc$dispatch("-2031062550", new Object[]{this})).floatValue();
    }

    public Drawable getDrawable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-934386010")) {
            return this.drawable;
        }
        return (Drawable) ipChange.ipc$dispatch("-934386010", new Object[]{this});
    }

    public float getScaleX() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178722836")) {
            return this.scaleX;
        }
        return ((Float) ipChange.ipc$dispatch("178722836", new Object[]{this})).floatValue();
    }

    public float getScaleY() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178752627")) {
            return this.scaleY;
        }
        return ((Float) ipChange.ipc$dispatch("178752627", new Object[]{this})).floatValue();
    }

    public float getX() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1422745104")) {
            return this.x;
        }
        return ((Float) ipChange.ipc$dispatch("1422745104", new Object[]{this})).floatValue();
    }

    public float getY() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1422774895")) {
            return this.y;
        }
        return ((Float) ipChange.ipc$dispatch("1422774895", new Object[]{this})).floatValue();
    }

    public void setAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284377222")) {
            ipChange.ipc$dispatch("-1284377222", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.alpha = f;
    }

    public void setDrawable(Drawable drawable2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043706580")) {
            ipChange.ipc$dispatch("-1043706580", new Object[]{this, drawable2});
            return;
        }
        this.drawable = drawable2;
    }

    public void setScaleX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019598888")) {
            ipChange.ipc$dispatch("2019598888", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.scaleX = f;
    }

    public void setScaleY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020522409")) {
            ipChange.ipc$dispatch("2020522409", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.scaleY = f;
    }

    public void setX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594339860")) {
            ipChange.ipc$dispatch("594339860", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.x = f;
    }

    public void setY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595263381")) {
            ipChange.ipc$dispatch("595263381", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.y = f;
    }
}
