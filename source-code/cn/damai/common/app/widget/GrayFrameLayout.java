package cn.damai.common.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GrayFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint mPaint = new Paint(5);

    public GrayFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "250400526")) {
            ipChange.ipc$dispatch("250400526", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(null, this.mPaint, 31);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668569204")) {
            ipChange.ipc$dispatch("668569204", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(null, this.mPaint, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
