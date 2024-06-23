package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.uikit.view.BaseDashedLine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DashedCircleLine extends BaseDashedLine {
    private static transient /* synthetic */ IpChange $ipChange;
    private RectF mRectF = new RectF();

    /* compiled from: Taobao */
    public class a extends BaseDashedLine.a {
        private static transient /* synthetic */ IpChange $ipChange;

        public a(DashedCircleLine dashedCircleLine, int i, int i2, int i3) {
            super(dashedCircleLine, i, i2, i3);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void e(int i, int i2, float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-192364407")) {
                ipChange.ipc$dispatch("-192364407", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)});
                return;
            }
            float min = (float) (((double) (((float) Math.min(i, i2)) - f)) * 3.141592653589793d);
            float round = min / ((float) Math.round(min / ((float) (this.b + this.a))));
            int i3 = this.a;
            int i4 = this.b;
            this.d = new DashPathEffect(new float[]{(((float) i3) * round) / ((float) (i4 + i3)), (round * ((float) i4)) / ((float) (i4 + i3))}, (float) this.c);
        }
    }

    public DashedCircleLine(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223266052")) {
            ipChange.ipc$dispatch("-223266052", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.view.BaseDashedLine
    public void initAttr(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585671418")) {
            ipChange.ipc$dispatch("-585671418", new Object[]{this, typedArray});
            return;
        }
        BaseDashedLine.a aVar = this.mDashEffect;
        this.mDashEffect = new a(this, aVar.a, aVar.b, aVar.c);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.view.BaseDashedLine
    public void onDrawDash(Canvas canvas, Paint paint, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072305021")) {
            ipChange.ipc$dispatch("1072305021", new Object[]{this, canvas, paint, Float.valueOf(f)});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(width, height);
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = (float) min;
            if (f * 2.0f > f2) {
                f = f2 / 2.0f;
            }
        }
        paint.setStrokeWidth(f);
        float f3 = f / 2.0f;
        RectF rectF = this.mRectF;
        rectF.top = (((float) (height - min)) / 2.0f) + f3;
        rectF.left = (((float) (width - min)) / 2.0f) + f3;
        rectF.bottom = (((float) (height + min)) / 2.0f) - f3;
        rectF.right = (((float) (width + min)) / 2.0f) - f3;
        canvas.drawOval(rectF, paint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436445953")) {
            ipChange.ipc$dispatch("-436445953", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int min = Math.min(size, size2);
        float f = this.mStrokeWidth;
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = (float) min;
            if (f * 2.0f > f2) {
                f = f2 / 2.0f;
            }
        }
        ((a) this.mDashEffect).e(size, size2, f);
    }

    public DashedCircleLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
