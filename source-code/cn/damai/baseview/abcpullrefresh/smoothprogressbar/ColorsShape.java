package cn.damai.baseview.abcpullrefresh.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ColorsShape extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] mColors;
    private float mStrokeWidth;

    public ColorsShape(float f, int[] iArr) {
        this.mStrokeWidth = f;
        this.mColors = iArr;
    }

    public void draw(Canvas canvas, Paint paint) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1541617708")) {
            ipChange.ipc$dispatch("1541617708", new Object[]{this, canvas, paint});
            return;
        }
        float length = 1.0f / ((float) this.mColors.length);
        paint.setStrokeWidth(this.mStrokeWidth);
        int[] iArr = this.mColors;
        int length2 = iArr.length;
        int i2 = 0;
        while (i2 < length2) {
            paint.setColor(iArr[i2]);
            int i3 = i + 1;
            canvas.drawLine(getWidth() * ((float) i) * length, getHeight() / 2.0f, getWidth() * ((float) i3) * length, getHeight() / 2.0f, paint);
            i2++;
            i = i3;
        }
    }

    public int[] getColors() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1183899666")) {
            return this.mColors;
        }
        return (int[]) ipChange.ipc$dispatch("1183899666", new Object[]{this});
    }

    public float getStrokeWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1556313930")) {
            return this.mStrokeWidth;
        }
        return ((Float) ipChange.ipc$dispatch("1556313930", new Object[]{this})).floatValue();
    }

    public void setColors(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570886420")) {
            ipChange.ipc$dispatch("570886420", new Object[]{this, iArr});
            return;
        }
        this.mColors = iArr;
    }

    public void setStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921152282")) {
            ipChange.ipc$dispatch("1921152282", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mStrokeWidth = f;
    }
}
