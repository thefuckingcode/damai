package cn.damai.uikit.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import tb.uf2;

/* compiled from: Taobao */
public class NumberFlipView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATION_DURATION = 300;
    private static final char MARKER = '_';
    private boolean isAttachedToWindow;
    private Runnable mAnimationTrigger;
    private ValueAnimator mAnimator;
    private String mCurText;
    private INumberFormat mFormat;
    private String mLastText;
    private TextPaint mPaint;
    private c mSuffixBottom;
    private c mSuffixTop;
    private int mTextColor;
    private String mTextPrefix;

    /* compiled from: Taobao */
    public interface INumberFormat {
        String numberToText(int i);
    }

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "690668984")) {
                ipChange.ipc$dispatch("690668984", new Object[]{this, valueAnimator});
                return;
            }
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (NumberFlipView.this.mSuffixTop != null) {
                NumberFlipView.this.mSuffixTop.c = NumberFlipView.this.mSuffixTop.a + (NumberFlipView.this.mSuffixTop.b() * animatedFraction);
            }
            if (NumberFlipView.this.mSuffixBottom != null) {
                NumberFlipView.this.mSuffixBottom.c = NumberFlipView.this.mSuffixBottom.a + (animatedFraction * NumberFlipView.this.mSuffixBottom.b());
            }
            NumberFlipView.this.invalidate();
        }
    }

    /* compiled from: Taobao */
    public static class b implements INumberFormat {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.uikit.view.NumberFlipView.INumberFormat
        public String numberToText(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1644714017")) {
                return (String) ipChange.ipc$dispatch("-1644714017", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return "";
            } else {
                return i + "";
            }
        }
    }

    /* compiled from: Taobao */
    public class c {
        private static transient /* synthetic */ IpChange $ipChange;
        public float a;
        public float b;
        public float c;
        public String d;

        public c(float f, float f2, String str) {
            this.a = f;
            this.b = f2;
            this.d = str;
            this.c = f;
        }

        public float a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "674051055")) {
                return this.c - NumberFlipView.this.mPaint.ascent();
            }
            return ((Float) ipChange.ipc$dispatch("674051055", new Object[]{this})).floatValue();
        }

        public float b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1766053983")) {
                return this.b - this.a;
            }
            return ((Float) ipChange.ipc$dispatch("1766053983", new Object[]{this})).floatValue();
        }
    }

    public NumberFlipView(Context context) {
        this(context, null);
    }

    private String[] getSplitFix() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682794742")) {
            return (String[]) ipChange.ipc$dispatch("1682794742", new Object[]{this});
        }
        try {
            int length = this.mCurText.length();
            int length2 = this.mLastText.length();
            int max = Math.max(length, length2);
            StringBuilder sb = new StringBuilder(this.mCurText);
            StringBuilder sb2 = new StringBuilder(this.mLastText);
            if (length < max) {
                markerInsert(sb, max - length);
            }
            if (length2 < max) {
                markerInsert(sb2, max - length2);
            }
            String sb3 = sb.toString();
            String sb4 = sb2.toString();
            StringBuilder sb5 = new StringBuilder();
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 < max) {
                    char charAt = sb3.charAt(i2);
                    if (sb4.charAt(i2) != charAt) {
                        i = i2;
                        break;
                    }
                    sb5.append(charAt);
                    i2++;
                } else {
                    break;
                }
            }
            if (i >= 0) {
                str = sb3.substring(i, max).replaceAll(JSMethod.NOT_SET, "");
                str2 = sb4.substring(i, max).replaceAll(JSMethod.NOT_SET, "");
            } else {
                str2 = null;
                str = null;
            }
            return new String[]{sb5.toString(), str, str2};
        } catch (Exception unused) {
            return null;
        }
    }

    private String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1078342229")) {
            return TextUtils.isEmpty(this.mCurText) ? "" : this.mCurText;
        }
        return (String) ipChange.ipc$dispatch("-1078342229", new Object[]{this});
    }

    private float getTextHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "917124318")) {
            return this.mPaint.descent() - this.mPaint.ascent();
        }
        return ((Float) ipChange.ipc$dispatch("917124318", new Object[]{this})).floatValue();
    }

    private boolean isAnimationUp(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328220261")) {
            return ((Boolean) ipChange.ipc$dispatch("-1328220261", new Object[]{this, str, str2})).booleanValue();
        }
        try {
            if (Integer.parseInt(str) > Integer.parseInt(str2)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean isTextPartCanDraw(c cVar) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953330032")) {
            return ((Boolean) ipChange.ipc$dispatch("-1953330032", new Object[]{this, cVar})).booleanValue();
        }
        return (cVar == null || (str = cVar.d) == null || str.length() <= 0) ? false : true;
    }

    private boolean isTextSupportAnimation(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097180926")) {
            return ((Boolean) ipChange.ipc$dispatch("1097180926", new Object[]{this, str, str2})).booleanValue();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    boolean d = uf2.d(str);
                    if (!uf2.d(str2) || !d || Integer.parseInt(str) == Integer.parseInt(str2)) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void markerInsert(StringBuilder sb, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121849271")) {
            ipChange.ipc$dispatch("1121849271", new Object[]{this, sb, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.insert(0, MARKER);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startAnimationIfNeed() {
        float f;
        float f2;
        float f3;
        float f4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485343837")) {
            ipChange.ipc$dispatch("1485343837", new Object[]{this});
            return;
        }
        this.mTextPrefix = null;
        this.mSuffixTop = null;
        this.mSuffixBottom = null;
        if (!isTextSupportAnimation(this.mCurText, this.mLastText) || !this.isAttachedToWindow) {
            this.mTextPrefix = this.mCurText;
            this.mSuffixTop = null;
            this.mSuffixBottom = null;
            invalidate();
            return;
        }
        boolean isAnimationUp = isAnimationUp(this.mCurText, this.mLastText);
        String[] splitFix = getSplitFix();
        if (splitFix == null) {
            this.mTextPrefix = this.mCurText;
            this.mSuffixTop = null;
            this.mSuffixBottom = null;
            invalidate();
            return;
        }
        if (isAnimationUp) {
            f4 = (float) getPaddingTop();
            f3 = -getTextHeight();
            f2 = (float) getHeight();
            f = f4;
        } else {
            f4 = -getTextHeight();
            f3 = (float) getPaddingTop();
            f2 = (float) getPaddingTop();
            f = (float) getHeight();
        }
        String str = isAnimationUp ? splitFix[2] : splitFix[1];
        String str2 = isAnimationUp ? splitFix[1] : splitFix[2];
        this.mTextPrefix = splitFix[0];
        this.mSuffixTop = new c(f4, f3, str);
        this.mSuffixBottom = new c(f2, f, str2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 100.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(300L);
        this.mAnimator.addUpdateListener(new a());
        this.mAnimator.start();
    }

    private void stopAnimationIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917656093")) {
            ipChange.ipc$dispatch("-1917656093", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator = null;
        }
        removeCallbacks(this.mAnimationTrigger);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29100068")) {
            ipChange.ipc$dispatch("29100068", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285809735")) {
            ipChange.ipc$dispatch("1285809735", new Object[]{this});
            return;
        }
        this.isAttachedToWindow = false;
        stopAnimationIfNeed();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723192714")) {
            ipChange.ipc$dispatch("-723192714", new Object[]{this, canvas});
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = (int) (((float) getPaddingTop()) - this.mPaint.ascent());
        if (!TextUtils.isEmpty(this.mTextPrefix)) {
            float measureText = this.mPaint.measureText(this.mTextPrefix);
            float f = (float) paddingLeft;
            canvas.drawText(this.mTextPrefix, f, (float) paddingTop, this.mPaint);
            paddingLeft = (int) (f + measureText);
        }
        if (isTextPartCanDraw(this.mSuffixTop)) {
            c cVar = this.mSuffixTop;
            canvas.drawText(cVar.d, (float) paddingLeft, cVar.a(), this.mPaint);
        }
        if (isTextPartCanDraw(this.mSuffixBottom)) {
            c cVar2 = this.mSuffixBottom;
            canvas.drawText(cVar2.d, (float) paddingLeft, cVar2.a(), this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315246951")) {
            ipChange.ipc$dispatch("-315246951", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + this.mPaint.measureText(getText()));
            size = mode == Integer.MIN_VALUE ? Math.min(size, paddingLeft) : paddingLeft;
        }
        if (mode2 != 1073741824) {
            int textHeight = (int) (getTextHeight() + ((float) getPaddingBottom()) + ((float) getPaddingTop()));
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(textHeight, size2) : textHeight;
        }
        setMeasuredDimension(size, size2);
    }

    public void setFormat(@NonNull INumberFormat iNumberFormat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813945772")) {
            ipChange.ipc$dispatch("813945772", new Object[]{this, iNumberFormat});
            return;
        }
        this.mFormat = iNumberFormat;
    }

    public void setNumber(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685567350")) {
            ipChange.ipc$dispatch("1685567350", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setText(this.mFormat.numberToText(i));
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638372499")) {
            ipChange.ipc$dispatch("638372499", new Object[]{this, str});
            return;
        }
        stopAnimationIfNeed();
        this.mLastText = this.mCurText;
        this.mCurText = str;
        this.mTextPrefix = null;
        this.mSuffixTop = null;
        this.mSuffixBottom = null;
        if (!this.isAttachedToWindow) {
            this.mTextPrefix = str;
        }
        requestLayout();
        if (this.isAttachedToWindow) {
            post(this.mAnimationTrigger);
        }
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615166843")) {
            ipChange.ipc$dispatch("-1615166843", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mTextColor != i) {
            this.mTextColor = i;
            this.mPaint.setColor(i);
            invalidate();
        }
    }

    public NumberFlipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberFlipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new TextPaint(1);
        this.mFormat = new b();
        this.isAttachedToWindow = false;
        this.mAnimationTrigger = new Runnable() {
            /* class cn.damai.uikit.view.NumberFlipView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1072332928")) {
                    ipChange.ipc$dispatch("-1072332928", new Object[]{this});
                    return;
                }
                NumberFlipView.this.startAnimationIfNeed();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NumberFlipView);
        this.mTextColor = obtainStyledAttributes.getColor(R$styleable.NumberFlipView_nfv_text_color, -16777216);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberFlipView_nfv_text_size, 36);
        obtainStyledAttributes.recycle();
        this.mPaint.setTextSize((float) dimensionPixelSize);
        this.mPaint.setColor(this.mTextColor);
        this.mPaint.setTextAlign(Paint.Align.LEFT);
    }
}
