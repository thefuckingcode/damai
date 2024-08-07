package cn.damai.commonbusiness.dynamicx.customwidget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dg1;

/* compiled from: Taobao */
public class GradientTextView extends TextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mGIndex;
    private int mLastH;
    private int mLastW;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public int getGradientIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-317304266")) {
            return this.mGIndex;
        }
        return ((Integer) ipChange.ipc$dispatch("-317304266", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-596728967")) {
            ipChange.ipc$dispatch("-596728967", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (!(width == this.mLastW && height == this.mLastH)) {
            GradientBean a = dg1.c().a(this.mGIndex);
            getPaint().setShader(new LinearGradient(0.0f, 0.0f, (float) width, (float) height, new int[]{a.startColor, a.endColor}, (float[]) null, Shader.TileMode.REPEAT));
        }
        this.mLastW = width;
        this.mLastH = height;
        super.onDraw(canvas);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastW = -1;
        this.mLastH = -1;
        this.mGIndex = -1;
        this.mGIndex = dg1.c().b();
    }
}
