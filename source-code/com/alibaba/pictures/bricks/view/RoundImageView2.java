package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z12;

/* compiled from: Taobao */
public class RoundImageView2 extends AppCompatImageView implements RoundMethodInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private z12 mHelper;

    public RoundImageView2(Context context) {
        this(context, null);
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331153754")) {
            ipChange.ipc$dispatch("1331153754", new Object[]{this, canvas});
            return;
        }
        this.mHelper.d(canvas);
        super.draw(canvas);
        this.mHelper.a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992801447")) {
            ipChange.ipc$dispatch("1992801447", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mHelper.c(i, i2);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276752967")) {
            ipChange.ipc$dispatch("-276752967", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.f(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusBottom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680233468")) {
            ipChange.ipc$dispatch("-1680233468", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.h(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusBottomLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323411925")) {
            ipChange.ipc$dispatch("-323411925", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.i(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusBottomRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401078930")) {
            ipChange.ipc$dispatch("-401078930", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.j(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428169376")) {
            ipChange.ipc$dispatch("-428169376", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.k(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646407385")) {
            ipChange.ipc$dispatch("646407385", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.l(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusTop(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071879150")) {
            ipChange.ipc$dispatch("-1071879150", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.m(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusTopLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302255303")) {
            ipChange.ipc$dispatch("-1302255303", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.n(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadiusTopRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680452576")) {
            ipChange.ipc$dispatch("-680452576", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.o(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601051901")) {
            ipChange.ipc$dispatch("601051901", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHelper.p(i);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431413603")) {
            ipChange.ipc$dispatch("-1431413603", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.q(f);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setStrokeWidthColor(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084750919")) {
            ipChange.ipc$dispatch("1084750919", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        this.mHelper.r(f, i);
    }

    public void setStrokeWidthPx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7636600")) {
            ipChange.ipc$dispatch("-7636600", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHelper.s(i);
    }

    public RoundImageView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @Override // com.alibaba.pictures.bricks.view.RoundMethodInterface
    public void setRadius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615942503")) {
            ipChange.ipc$dispatch("1615942503", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        this.mHelper.g(f, f2, f3, f4);
    }

    public RoundImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z12 z12 = new z12();
        this.mHelper = z12;
        z12.b(context, attributeSet, this);
    }
}
