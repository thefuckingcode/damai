package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GiftCheckableImageView extends ImageView implements Checkable {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] CheckedStateSet = {16842912};
    private boolean mChecked = false;

    public GiftCheckableImageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530699357")) {
            ipChange.ipc$dispatch("-1530699357", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        invalidate();
    }

    public boolean isChecked() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "68777005")) {
            return this.mChecked;
        }
        return ((Boolean) ipChange.ipc$dispatch("68777005", new Object[]{this})).booleanValue();
    }

    public int[] onCreateDrawableState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899323377")) {
            return (int[]) ipChange.ipc$dispatch("-1899323377", new Object[]{this, Integer.valueOf(i)});
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            ImageView.mergeDrawableStates(onCreateDrawableState, CheckedStateSet);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667061525")) {
            ipChange.ipc$dispatch("667061525", new Object[]{this, Boolean.valueOf(z)});
        } else if (z != this.mChecked) {
            this.mChecked = z;
            refreshDrawableState();
        }
    }

    public void toggle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618680912")) {
            ipChange.ipc$dispatch("1618680912", new Object[]{this});
            return;
        }
        setChecked(!this.mChecked);
    }

    public GiftCheckableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GiftCheckableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
