package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TrueLoveMedalSpan extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386956612")) {
            ipChange.ipc$dispatch("-386956612", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
        }
    }

    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1975871244")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1975871244", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
    }
}
