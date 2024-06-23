package cn.damai.tetris.component.discover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NIndicator extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int mBgEColor = Color.parseColor("#EBEAFB");
    private final Paint mBgPaint = new Paint(1);
    private final RectF mBgRect = new RectF();
    private final int mBgSColor = Color.parseColor("#EFEFEF");
    LinearGradient mGradient;
    private final int mIndicatorEColor = Color.parseColor("#FFBEED");
    private final int mIndicatorSColor = Color.parseColor("#FF70B8");
    private final Paint mPaint = new Paint(1);
    private Float mRadius = Float.valueOf(0.0f);
    private final RectF mRect = new RectF();
    private final Matrix matrix = new Matrix();
    private float progress = 0.0f;
    private float ratio = 0.5f;
    private int viewWidth = 0;

    public NIndicator(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070781588")) {
            ipChange.ipc$dispatch("-1070781588", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.progress = f;
        invalidate();
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346634511")) {
            ipChange.ipc$dispatch("-346634511", new Object[]{this, recyclerView});
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.tetris.component.discover.view.NIndicator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1651238510")) {
                    ipChange.ipc$dispatch("1651238510", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                NIndicator.this.setProgress((((float) recyclerView.computeHorizontalScrollOffset()) * 1.0f) / ((float) (recyclerView.computeHorizontalScrollRange() - recyclerView.computeHorizontalScrollExtent())));
            }
        });
    }

    public void bindViewPager(final ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2147174315")) {
            ipChange.ipc$dispatch("-2147174315", new Object[]{this, viewPager});
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.tetris.component.discover.view.NIndicator.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1136824396")) {
                    ipChange.ipc$dispatch("1136824396", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1413753067")) {
                    ipChange.ipc$dispatch("1413753067", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    return;
                }
                NIndicator.this.setProgress((((float) i) + f) / ((float) viewPager.getChildCount()));
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1925177705")) {
                    ipChange.ipc$dispatch("-1925177705", new Object[]{this, Integer.valueOf(i)});
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10386497")) {
            ipChange.ipc$dispatch("10386497", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawRoundRect(this.mBgRect, this.mRadius.floatValue(), this.mRadius.floatValue(), this.mBgPaint);
        }
        int i = this.viewWidth;
        float f = this.ratio;
        float f2 = ((float) i) * (1.0f - f) * this.progress;
        RectF rectF = this.mBgRect;
        float f3 = rectF.left + f2;
        this.mRect.set(f3, rectF.top, (((float) i) * f) + f3, rectF.bottom);
        this.matrix.setTranslate(f3, 0.0f);
        this.mGradient.setLocalMatrix(this.matrix);
        if (canvas != null) {
            canvas.drawRoundRect(this.mRect, this.mRadius.floatValue(), this.mRadius.floatValue(), this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945686769")) {
            ipChange.ipc$dispatch("-945686769", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        float f = (float) i;
        float f2 = (float) i2;
        this.mBgRect.set(0.0f, 0.0f, f * 1.0f, 1.0f * f2);
        this.mRadius = Float.valueOf(f2 / 2.0f);
        this.mGradient = new LinearGradient(this.mRadius.floatValue(), 0.0f, f / 2.0f, this.mRadius.floatValue(), this.mIndicatorSColor, this.mIndicatorEColor, Shader.TileMode.MIRROR);
        this.mBgPaint.setShader(new LinearGradient(this.mRadius.floatValue(), 0.0f, f, this.mRadius.floatValue(), this.mBgSColor, this.mBgEColor, Shader.TileMode.CLAMP));
        this.mPaint.setShader(this.mGradient);
    }

    public void setRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067331294")) {
            ipChange.ipc$dispatch("-1067331294", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.ratio = f;
        invalidate();
    }

    public NIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
