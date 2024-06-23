package com.alibaba.pictures.bricks.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.bean.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t71;

/* compiled from: Taobao */
public class EqualLinearView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAnimatedValue;
    private Context mContext;
    private int mDaSize = 16;
    private int mHeight = 45;
    private boolean mIsShowLine = true;
    private float mLastStartX = 0.0f;
    private float mLastStopX = 0.0f;
    private float mLineWidth = 0.0f;
    private View.OnClickListener mOnClickListener;
    private Paint mPaint = new Paint();
    public int mSelectIndex = -1;
    private int mSelectedFontColor = R$color.bricks_000000;
    private boolean mSrcollStart;
    private float mStartX;
    private int mStartY = 0;
    private float mStopX;
    private List<ScrollTitleBean> mTitleList;
    private TextView mTv;
    private int mUnSelectedFontColor = R$color.bricks_999999;
    private int mXiaoSize = 16;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "742320683")) {
                ipChange.ipc$dispatch("742320683", new Object[]{this, view});
                return;
            }
            EqualLinearView.this.mOnClickListener.onClick(this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1009778100")) {
                ipChange.ipc$dispatch("1009778100", new Object[]{this, valueAnimator});
                return;
            }
            EqualLinearView.this.mAnimatedValue = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
            EqualLinearView.this.mTv.setTextSize(1, ((float) EqualLinearView.this.mXiaoSize) + ((((float) (EqualLinearView.this.mDaSize - EqualLinearView.this.mXiaoSize)) * EqualLinearView.this.mAnimatedValue) / 100.0f));
            EqualLinearView.this.mTv.setGravity(17);
            float f = EqualLinearView.this.mAnimatedValue / 100.0f;
            float f2 = this.a;
            float f3 = this.b;
            if (f2 < f3) {
                EqualLinearView.this.mStartX = f2 + ((f3 - f2) * f);
                EqualLinearView equalLinearView = EqualLinearView.this;
                equalLinearView.mStopX = equalLinearView.mStartX + EqualLinearView.this.mLineWidth;
            } else {
                EqualLinearView.this.mStartX = f2 - ((f2 - f3) * f);
                EqualLinearView equalLinearView2 = EqualLinearView.this;
                equalLinearView2.mStopX = equalLinearView2.mStartX + EqualLinearView.this.mLineWidth;
            }
            if (EqualLinearView.this.mAnimatedValue == 100.0f) {
                EqualLinearView.this.mLastStartX = this.b;
                EqualLinearView.this.mLastStopX = this.c;
                EqualLinearView.this.mSrcollStart = false;
            }
            EqualLinearView.this.invalidate();
        }
    }

    public EqualLinearView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "61871733")) {
            return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("61871733", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692341944")) {
            ipChange.ipc$dispatch("1692341944", new Object[]{this});
            return;
        }
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(16);
        this.mPaint.setStrokeWidth((float) dip2px(4.0f));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setColor(this.mContext.getResources().getColor(R$color.bricks_FF2869));
        this.mPaint.setAntiAlias(true);
        this.mLineWidth = (float) dip2px(18.0f);
    }

    public void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598565354")) {
            ipChange.ipc$dispatch("-1598565354", new Object[]{this});
        } else if (!t71.b(this.mTitleList) && this.mTitleList.size() <= 5) {
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextSize((float) this.mXiaoSize);
                    textView.setGravity(17);
                    textView.setTag(scrollTitleBean);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.gravity = 16;
                    layoutParams.weight = 1.0f;
                    textView.setLayoutParams(layoutParams);
                    textView.setOnClickListener(new a(textView));
                    addView(textView);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338820763")) {
            ipChange.ipc$dispatch("338820763", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mIsShowLine) {
            this.mStartY = dip2px((float) (this.mHeight - 2));
            float f = this.mStartX;
            int i = this.mStartY;
            this.mPaint.setShader(new LinearGradient(f, (float) i, this.mStopX, (float) i, Color.parseColor("#FFFF70B8"), Color.parseColor("#FFFFBEED"), Shader.TileMode.CLAMP));
            Paint paint = this.mPaint;
            if (paint != null) {
                float f2 = this.mStartX;
                int i2 = this.mStartY;
                canvas.drawLine(f2, (float) i2, this.mStopX, (float) i2, paint);
            }
        }
    }

    public void selectTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226212830")) {
            ipChange.ipc$dispatch("-1226212830", new Object[]{this, Integer.valueOf(i)});
        } else if (!t71.b(this.mTitleList) && this.mSelectIndex != i && !this.mSrcollStart) {
            this.mSrcollStart = true;
            this.mSelectIndex = i;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                TextView textView = (TextView) getChildAt(i2);
                if (i == i2) {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView.setTextSize(1, (float) this.mXiaoSize);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
            this.mTv = (TextView) getChildAt(i);
            post(new Runnable() {
                /* class com.alibaba.pictures.bricks.view.EqualLinearView.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1788731140")) {
                        ipChange.ipc$dispatch("1788731140", new Object[]{this});
                    } else if (EqualLinearView.this.mTv != null) {
                        EqualLinearView equalLinearView = EqualLinearView.this;
                        equalLinearView.mStartX = ((float) equalLinearView.mTv.getLeft()) + ((((float) EqualLinearView.this.mTv.getWidth()) - EqualLinearView.this.mLineWidth) / 2.0f);
                        EqualLinearView equalLinearView2 = EqualLinearView.this;
                        equalLinearView2.mStopX = equalLinearView2.mStartX + EqualLinearView.this.mLineWidth;
                        if (EqualLinearView.this.mLastStartX == 0.0f && EqualLinearView.this.mLastStopX == 0.0f) {
                            EqualLinearView equalLinearView3 = EqualLinearView.this;
                            equalLinearView3.mLastStartX = equalLinearView3.mStartX;
                            EqualLinearView equalLinearView4 = EqualLinearView.this;
                            equalLinearView4.mLastStopX = equalLinearView4.mStopX;
                        }
                        EqualLinearView equalLinearView5 = EqualLinearView.this;
                        equalLinearView5.startAnim(equalLinearView5.mLastStartX, EqualLinearView.this.mLastStopX, EqualLinearView.this.mStartX, EqualLinearView.this.mStopX);
                    }
                }
            });
        }
    }

    public EqualLinearView setFontColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983724389")) {
            return (EqualLinearView) ipChange.ipc$dispatch("1983724389", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        return this;
    }

    public EqualLinearView setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145514146")) {
            return (EqualLinearView) ipChange.ipc$dispatch("2145514146", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
        return this;
    }

    public EqualLinearView setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306129858")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1306129858", new Object[]{this, Integer.valueOf(i)});
        }
        this.mHeight = i;
        return this;
    }

    public EqualLinearView setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6182045")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-6182045", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsShowLine = z;
        return this;
    }

    public EqualLinearView setOnTitleClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912149300")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1912149300", new Object[]{this, onClickListener});
        }
        this.mOnClickListener = onClickListener;
        return this;
    }

    public EqualLinearView setTitle(List<ScrollTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529109595")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1529109595", new Object[]{this, list});
        }
        this.mTitleList = list;
        return this;
    }

    public void startAnim(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667376074")) {
            ipChange.ipc$dispatch("1667376074", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        } else if (f == f3) {
            this.mStartX = f3;
            this.mStopX = f4;
            this.mTv.setTextSize(1, (float) this.mDaSize);
            this.mSrcollStart = false;
            invalidate();
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new b(f, f3, f4));
            ofInt.start();
        }
    }

    public EqualLinearView setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313552338")) {
            return (EqualLinearView) ipChange.ipc$dispatch("313552338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public EqualLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}
