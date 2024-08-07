package cn.damai.player.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ResizeFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float H_W_RATE = 0.5625f;

    public ResizeFrameLayout(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163979062")) {
            ipChange.ipc$dispatch("163979062", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * H_W_RATE), 1073741824);
            } else if (mode2 == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec((int) (((float) size2) / H_W_RATE), 1073741824);
            } else {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * H_W_RATE), 1073741824);
                i = makeMeasureSpec;
            }
        }
        super.onMeasure(i, i2);
    }

    public ResizeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResizeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
