package cn.damai.uikit.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScrollLineView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAnimatedValue;
    private int mHeight = 10;
    private boolean mIsMove = false;
    private float mLastStartX = 0.0f;
    private float mLastStopX = 0.0f;
    private Bitmap mLineBitmap;
    private RectF mLineDstRect = new RectF();
    private Rect mLineSrcRect;
    private Paint mPaint = new Paint();
    private Bitmap mShadleBitmap;
    private RectF mShadleDstRect = new RectF();
    private Rect mShadleSrcRect;
    private int mShadlowHeight = 7;
    private float mStartX;
    private int mStartY = 0;
    private float mStopX;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        a(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1466825598")) {
                ipChange.ipc$dispatch("-1466825598", new Object[]{this, valueAnimator});
                return;
            }
            ScrollLineView.this.mAnimatedValue = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (this.a < this.b) {
                if (ScrollLineView.this.mAnimatedValue <= 50.0f) {
                    ScrollLineView.this.mStartX = this.a;
                    ScrollLineView scrollLineView = ScrollLineView.this;
                    float f = this.c;
                    scrollLineView.mStopX = f + (((this.b - f) * scrollLineView.mAnimatedValue) / 75.0f);
                } else if (ScrollLineView.this.mAnimatedValue > 50.0f && ScrollLineView.this.mAnimatedValue <= 75.0f) {
                    ScrollLineView scrollLineView2 = ScrollLineView.this;
                    float f2 = this.a;
                    scrollLineView2.mStartX = f2 + (((this.d - f2) * (scrollLineView2.mAnimatedValue - 50.0f)) / 50.0f);
                    ScrollLineView scrollLineView3 = ScrollLineView.this;
                    float f3 = this.c;
                    scrollLineView3.mStopX = f3 + (((this.b - f3) * scrollLineView3.mAnimatedValue) / 75.0f);
                } else if (ScrollLineView.this.mAnimatedValue > 75.0f) {
                    ScrollLineView scrollLineView4 = ScrollLineView.this;
                    float f4 = this.a;
                    scrollLineView4.mStartX = f4 + (((this.d - f4) * (scrollLineView4.mAnimatedValue - 50.0f)) / 50.0f);
                    ScrollLineView.this.mStopX = this.b;
                }
            } else if (ScrollLineView.this.mAnimatedValue <= 50.0f) {
                ScrollLineView scrollLineView5 = ScrollLineView.this;
                float f5 = this.a;
                scrollLineView5.mStartX = f5 + (((this.d - f5) * scrollLineView5.mAnimatedValue) / 75.0f);
                ScrollLineView.this.mStopX = this.c;
            } else if (ScrollLineView.this.mAnimatedValue > 50.0f && ScrollLineView.this.mAnimatedValue <= 75.0f) {
                ScrollLineView scrollLineView6 = ScrollLineView.this;
                float f6 = this.a;
                scrollLineView6.mStartX = f6 + (((this.d - f6) * scrollLineView6.mAnimatedValue) / 75.0f);
                ScrollLineView scrollLineView7 = ScrollLineView.this;
                float f7 = this.c;
                scrollLineView7.mStopX = f7 + (((this.b - f7) * (scrollLineView7.mAnimatedValue - 50.0f)) / 50.0f);
            } else if (ScrollLineView.this.mAnimatedValue > 75.0f) {
                ScrollLineView.this.mStartX = this.d;
                ScrollLineView scrollLineView8 = ScrollLineView.this;
                float f8 = this.c;
                scrollLineView8.mStopX = f8 + (((this.b - f8) * (scrollLineView8.mAnimatedValue - 50.0f)) / 50.0f);
            }
            if (ScrollLineView.this.mAnimatedValue > 90.0f) {
                ScrollLineView.this.mIsMove = false;
            }
            if (ScrollLineView.this.mAnimatedValue == 100.0f) {
                ScrollLineView.this.mLastStartX = this.d;
                ScrollLineView.this.mLastStopX = this.b;
            }
            ScrollLineView.this.invalidate();
        }
    }

    public ScrollLineView(Context context) {
        super(context);
        initView();
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1186900901")) {
            return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("1186900901", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086459512")) {
            ipChange.ipc$dispatch("-2086459512", new Object[]{this});
            return;
        }
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
        this.mLineBitmap = BitmapFactory.decodeResource(getResources(), R$drawable.snake_line_rectangle);
        this.mShadleBitmap = BitmapFactory.decodeResource(getResources(), R$drawable.snake_line_shadle);
        this.mLineSrcRect = new Rect(0, 0, this.mLineBitmap.getWidth(), this.mLineBitmap.getHeight());
        this.mShadleSrcRect = new Rect(0, 0, this.mShadleBitmap.getWidth(), this.mShadleBitmap.getHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931477963")) {
            ipChange.ipc$dispatch("1931477963", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        RectF rectF = this.mLineDstRect;
        rectF.left = this.mStartX;
        rectF.right = this.mStopX;
        rectF.top = (float) (this.mStartY + dip2px(7.0f));
        this.mLineDstRect.bottom = (float) (this.mStartY + dip2px(17.0f));
        canvas.drawBitmap(this.mLineBitmap, this.mLineSrcRect, this.mLineDstRect, this.mPaint);
        if (!this.mIsMove) {
            this.mShadleDstRect.left = this.mStartX - ((float) dip2px(6.0f));
            this.mShadleDstRect.right = this.mStopX + ((float) dip2px(6.0f));
            this.mShadleDstRect.top = (float) (this.mStartY - dip2px(4.0f));
            this.mShadleDstRect.bottom = (float) (this.mStartY + dip2px(25.0f));
            canvas.drawBitmap(this.mShadleBitmap, this.mShadleSrcRect, this.mShadleDstRect, this.mPaint);
        }
    }

    public void setLineHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106116595")) {
            ipChange.ipc$dispatch("2106116595", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHeight = i;
    }

    public void startAnim(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885858566")) {
            ipChange.ipc$dispatch("-1885858566", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        this.mLastStartX = f;
        this.mLastStopX = f2;
        this.mStartX = f3;
        this.mStopX = f4;
        if (f == f3) {
            invalidate();
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new a(f, f4, f2, f3));
        ofInt.start();
        this.mIsMove = true;
    }

    public ScrollLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
