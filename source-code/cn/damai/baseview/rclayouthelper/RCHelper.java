package cn.damai.baseview.rclayouthelper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class RCHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    public float[] a = new float[8];
    public Path b;
    public Paint c;
    public boolean d = false;
    public int e;
    public int f;
    public ColorStateList g;
    public int h;
    public boolean i;
    public Region j;
    public RectF k;
    public boolean l;
    public OnCheckedChangeListener m;

    /* compiled from: Taobao */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(View view, boolean z);
    }

    public void a(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1519307793")) {
            ipChange.ipc$dispatch("-1519307793", new Object[]{this, view});
        } else if (view instanceof RCAttrs) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof Checkable) {
                arrayList.add(16842911);
                if (((Checkable) view).isChecked()) {
                    arrayList.add(16842912);
                }
            }
            if (view.isEnabled()) {
                arrayList.add(16842910);
            }
            if (view.isFocused()) {
                arrayList.add(16842908);
            }
            if (view.isPressed()) {
                arrayList.add(16842919);
            }
            if (view.isHovered()) {
                arrayList.add(16843623);
            }
            if (view.isSelected()) {
                arrayList.add(16842913);
            }
            if (view.isActivated()) {
                arrayList.add(16843518);
            }
            if (view.hasWindowFocus()) {
                arrayList.add(16842909);
            }
            ColorStateList colorStateList = this.g;
            if (colorStateList != null && colorStateList.isStateful()) {
                int[] iArr = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
                ((RCAttrs) view).setStrokeColor(this.g.getColorForState(iArr, this.e));
            }
        }
    }

    public void b(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198004582")) {
            ipChange.ipc$dispatch("-198004582", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RCRelativeLayoutView);
        this.d = obtainStyledAttributes.getBoolean(R$styleable.RCRelativeLayoutView_round_as_circle, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R$styleable.RCRelativeLayoutView_stroke_color);
        this.g = colorStateList;
        if (colorStateList != null) {
            this.f = colorStateList.getDefaultColor();
            this.e = this.g.getDefaultColor();
        } else {
            this.f = -1;
            this.e = -1;
        }
        this.h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_stroke_width, 0);
        this.i = obtainStyledAttributes.getBoolean(R$styleable.RCRelativeLayoutView_clip_background, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_round_corner, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_round_corner_top_left, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_round_corner_top_right, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_round_corner_bottom_left, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RCRelativeLayoutView_round_corner_bottom_right, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.a;
        float f2 = (float) dimensionPixelSize2;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = (float) dimensionPixelSize3;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = (float) dimensionPixelSize5;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = (float) dimensionPixelSize4;
        fArr[6] = f5;
        fArr[7] = f5;
        this.k = new RectF();
        this.b = new Path();
        this.j = new Region();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1);
        this.c.setAntiAlias(true);
    }

    public void c(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1349170196")) {
            ipChange.ipc$dispatch("1349170196", new Object[]{this, canvas});
            return;
        }
        if (this.h > 0) {
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.c.setColor(-1);
            this.c.setStrokeWidth((float) (this.h * 2));
            this.c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.b, this.c);
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.c.setColor(this.f);
            this.c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.b, this.c);
        }
        this.c.setColor(-1);
        this.c.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 27) {
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.b, this.c);
            return;
        }
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, (float) ((int) this.k.width()), (float) ((int) this.k.height()), Path.Direction.CW);
        path.op(this.b, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.c);
    }

    public void d(View view, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580904192")) {
            ipChange.ipc$dispatch("1580904192", new Object[]{this, view, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.k.set(0.0f, 0.0f, (float) i2, (float) i3);
        e(view);
    }

    public void e(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317883899")) {
            ipChange.ipc$dispatch("317883899", new Object[]{this, view});
            return;
        }
        int width = (int) this.k.width();
        int height = (int) this.k.height();
        RectF rectF = new RectF();
        rectF.left = (float) view.getPaddingLeft();
        rectF.top = (float) view.getPaddingTop();
        rectF.right = (float) (width - view.getPaddingRight());
        rectF.bottom = (float) (height - view.getPaddingBottom());
        this.b.reset();
        if (this.d) {
            float height2 = (rectF.width() >= rectF.height() ? rectF.height() : rectF.width()) / 2.0f;
            float f2 = (float) (height / 2);
            PointF pointF = new PointF((float) (width / 2), f2);
            if (Build.VERSION.SDK_INT <= 27) {
                this.b.addCircle(pointF.x, pointF.y, height2, Path.Direction.CW);
                this.b.moveTo(0.0f, 0.0f);
                this.b.moveTo((float) width, (float) height);
            } else {
                float f3 = f2 - height2;
                this.b.moveTo(rectF.left, f3);
                this.b.addCircle(pointF.x, f3 + height2, height2, Path.Direction.CW);
            }
        } else {
            this.b.addRoundRect(rectF, this.a, Path.Direction.CW);
        }
        this.j.setPath(this.b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
