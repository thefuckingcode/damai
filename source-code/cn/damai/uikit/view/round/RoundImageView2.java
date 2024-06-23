package cn.damai.uikit.view.round;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a22;

/* compiled from: Taobao */
public class RoundImageView2 extends AppCompatImageView implements RoundMethodInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private a22 mHelper;

    public RoundImageView2(Context context) {
        this(context, null);
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722490897")) {
            ipChange.ipc$dispatch("-1722490897", new Object[]{this, canvas});
            return;
        }
        this.mHelper.d(canvas);
        super.draw(canvas);
        this.mHelper.a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459046588")) {
            ipChange.ipc$dispatch("1459046588", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mHelper.c(i, i2);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118058684")) {
            ipChange.ipc$dispatch("-1118058684", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.f(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103663951")) {
            ipChange.ipc$dispatch("103663951", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.h(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445486602")) {
            ipChange.ipc$dispatch("-1445486602", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.i(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825655549")) {
            ipChange.ipc$dispatch("-825655549", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.j(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46425237")) {
            ipChange.ipc$dispatch("-46425237", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.k(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404426194")) {
            ipChange.ipc$dispatch("-404426194", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.l(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTop(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018645159")) {
            ipChange.ipc$dispatch("1018645159", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.m(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836010162")) {
            ipChange.ipc$dispatch("-1836010162", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.n(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46984021")) {
            ipChange.ipc$dispatch("-46984021", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.o(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449781678")) {
            ipChange.ipc$dispatch("-449781678", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHelper.p(i);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812720114")) {
            ipChange.ipc$dispatch("1812720114", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mHelper.q(f);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidthColor(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "660174300")) {
            ipChange.ipc$dispatch("660174300", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        this.mHelper.r(f, i);
    }

    public void setStrokeWidthPx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541391459")) {
            ipChange.ipc$dispatch("-541391459", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHelper.s(i);
    }

    public RoundImageView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588500484")) {
            ipChange.ipc$dispatch("-588500484", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        this.mHelper.g(f, f2, f3, f4);
    }

    public RoundImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a22 a22 = new a22();
        this.mHelper = a22;
        a22.b(context, attributeSet, this);
    }
}
