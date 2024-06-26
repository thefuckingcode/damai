package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;

/* compiled from: Taobao */
public class GifCareImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mParentScrollState = 0;

    public GifCareImageView(Context context) {
        super(context);
    }

    private void tryAnimateGifOrNot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045051140")) {
            ipChange.ipc$dispatch("-2045051140", new Object[]{this});
            return;
        }
        try {
            Drawable drawable = getDrawable();
            if (drawable instanceof AnimatedImageDrawable) {
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
                boolean p = animatedImageDrawable.p();
                if (this.mParentScrollState == 0) {
                    if (!p) {
                        animatedImageDrawable.w();
                    }
                } else if (p) {
                    animatedImageDrawable.t(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processParentScrollState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2079903104")) {
            ipChange.ipc$dispatch("-2079903104", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mParentScrollState = i;
        tryAnimateGifOrNot();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558062533")) {
            ipChange.ipc$dispatch("-558062533", new Object[]{this, drawable});
            return;
        }
        super.setImageDrawable(drawable);
        tryAnimateGifOrNot();
    }

    public void setImageResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766979908")) {
            ipChange.ipc$dispatch("-766979908", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        tryAnimateGifOrNot();
    }

    public void setImageURI(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378195550")) {
            ipChange.ipc$dispatch("1378195550", new Object[]{this, uri});
            return;
        }
        super.setImageURI(uri);
        tryAnimateGifOrNot();
    }

    public GifCareImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GifCareImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
