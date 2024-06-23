package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DashedLine extends BaseDashedLine {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mOrientation;
    private Path mPath;

    /* compiled from: Taobao */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Orientation.values().length];
            a = iArr;
            iArr[Orientation.HORIZONTAL.ordinal()] = 1;
            a[Orientation.VERTICAL.ordinal()] = 2;
        }
    }

    public DashedLine(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380571980")) {
            ipChange.ipc$dispatch("380571980", new Object[]{this});
            return;
        }
        this.mPath = new Path();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.view.BaseDashedLine
    public void initAttr(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170636458")) {
            ipChange.ipc$dispatch("-170636458", new Object[]{this, typedArray});
            return;
        }
        this.mOrientation = typedArray.getInt(R$styleable.DashedLine_dashOrientation, 0);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.view.BaseDashedLine
    public void onDrawDash(Canvas canvas, Paint paint, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961496627")) {
            ipChange.ipc$dispatch("-961496627", new Object[]{this, canvas, paint, Float.valueOf(f)});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        Paint paint2 = this.mPaint;
        float f2 = this.mStrokeWidth;
        if (f2 == 0.0f) {
            f2 = (float) (this.mOrientation == 1 ? width : height);
        }
        paint2.setStrokeWidth(f2);
        this.mPath.rewind();
        if (this.mOrientation == 1) {
            float f3 = (float) (width / 2);
            this.mPath.moveTo(f3, 0.0f);
            this.mPath.lineTo(f3, (float) height);
        } else {
            float f4 = (float) (height / 2);
            this.mPath.moveTo(0.0f, f4);
            this.mPath.lineTo((float) width, f4);
        }
        canvas.drawPath(this.mPath, paint);
    }

    public void setOrientation(Orientation orientation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46882678")) {
            ipChange.ipc$dispatch("-46882678", new Object[]{this, orientation});
            return;
        }
        int i = a.a[orientation.ordinal()];
        if (i == 1) {
            this.mOrientation = 0;
        } else if (i == 2) {
            this.mOrientation = 1;
        }
    }

    public DashedLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
