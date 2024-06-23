package com.youku.resource.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.widget.YKTitleTabIndicator;

/* compiled from: Taobao */
public abstract class YKTitleTabItemViewRv extends RelativeLayout implements YKTitleTabIndicator.ItemSelectListener {
    protected ValueAnimator bigToSmall;
    protected int endColor = Integer.MAX_VALUE;
    protected YKTitleTabIndicatorRv indicator;
    protected boolean isSelected = false;
    protected int mPosition;
    protected String mText;
    protected TextView mTextView;
    protected ValueAnimator smallToBig;
    protected int startColor = Integer.MAX_VALUE;

    /* compiled from: Taobao */
    public class LinearGradientFontSpan extends ReplacementSpan {
        private int endColor;
        LinearGradient lg = null;
        private int mSize;
        private int startColor;

        public LinearGradientFontSpan(int i, int i2) {
            this.startColor = i;
            this.endColor = i2;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabItemViewRv.this.indicator;
            if (yKTitleTabIndicatorRv != null && yKTitleTabIndicatorRv.isDefaultColor) {
                this.lg = null;
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, (float) this.mSize, 0.0f, this.startColor, this.endColor, Shader.TileMode.CLAMP);
                this.lg = linearGradient;
                paint.setShader(linearGradient);
            } else if (yKTitleTabIndicatorRv != null) {
                this.lg = null;
                paint.setShader(null);
            }
            canvas.drawText(charSequence, i, i2, f, (float) i4, paint);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            this.mSize = (int) paint.measureText(charSequence, i, i2);
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            if (fontMetricsInt != null) {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            }
            return this.mSize;
        }
    }

    public YKTitleTabItemViewRv(Context context) {
        super(context);
    }

    public abstract void bindData(Object obj);

    public abstract TextView findTextView();

    public SpannableStringBuilder getRadiusGradientSpan(String str, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new LinearGradientFontSpan(i, i2), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    /* access modifiers changed from: protected */
    public boolean hasGradientText() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean hasImage() {
        return false;
    }

    public void initView(YKTitleTabIndicatorRv yKTitleTabIndicatorRv) {
        this.indicator = yKTitleTabIndicatorRv;
        TextView findTextView = findTextView();
        this.mTextView = findTextView;
        findTextView.setGravity(17);
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setTextSize(0, (float) yKTitleTabIndicatorRv.getTextSizeDef());
        this.mTextView.setPadding(0, 0, 0, 0);
    }

    public boolean needUpdate(Object obj) {
        return true;
    }

    @Override // com.youku.resource.widget.YKTitleTabIndicator.ItemSelectListener
    public void onSelected() {
        ValueAnimator valueAnimator;
        if (!this.isSelected) {
            this.isSelected = true;
            if (AppPerfABUtils.isOpenDegrade()) {
                getTextView().setTextSize(0, (float) this.indicator.mTextSizeSelected);
                return;
            }
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = this.indicator;
            if (yKTitleTabIndicatorRv.ableTextAnim) {
                final int i = yKTitleTabIndicatorRv.mTextSizeDef;
                final int i2 = yKTitleTabIndicatorRv.mTextSizeSelected;
                if (!hasImage() && ((valueAnimator = this.smallToBig) == null || !valueAnimator.isRunning())) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i2);
                    this.smallToBig = ofFloat;
                    ofFloat.setDuration((long) this.indicator.textAnimDuring);
                    this.smallToBig.setInterpolator(new LinearInterpolator());
                    this.smallToBig.setRepeatCount(0);
                    this.smallToBig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.youku.resource.widget.YKTitleTabItemViewRv.AnonymousClass1 */

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                    this.smallToBig.addListener(new AnimatorListenerAdapter() {
                        /* class com.youku.resource.widget.YKTitleTabItemViewRv.AnonymousClass2 */

                        public void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i2);
                            YKTitleTabItemViewRv.this.smallToBig = null;
                        }

                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i2);
                            YKTitleTabItemViewRv.this.smallToBig = null;
                        }

                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i);
                        }
                    });
                    this.smallToBig.start();
                }
                this.mTextView.setGravity(80);
                this.mTextView.setPadding(0, 0, 0, this.indicator.mTextSelectedBottomPadding);
            }
            if (!hasImage() && this.mTextView != null && hasGradientText() && !TextUtils.isEmpty(this.mText)) {
                this.mTextView.setText(getRadiusGradientSpan(this.mText, this.startColor, this.endColor));
            }
        }
    }

    @Override // com.youku.resource.widget.YKTitleTabIndicator.ItemSelectListener
    public void onUnSelected() {
        TextView textView;
        ValueAnimator valueAnimator;
        if (this.isSelected) {
            this.isSelected = false;
            if (AppPerfABUtils.isOpenDegrade()) {
                getTextView().setTextSize(0, (float) this.indicator.mTextSizeDef);
                return;
            }
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = this.indicator;
            if (yKTitleTabIndicatorRv.ableTextAnim) {
                final int i = yKTitleTabIndicatorRv.mTextSizeSelected;
                final int i2 = yKTitleTabIndicatorRv.mTextSizeDef;
                if (!hasImage() && ((valueAnimator = this.bigToSmall) == null || !valueAnimator.isRunning())) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i2);
                    this.bigToSmall = ofFloat;
                    ofFloat.setDuration((long) this.indicator.textAnimDuring);
                    this.bigToSmall.setInterpolator(new LinearInterpolator());
                    this.bigToSmall.setRepeatCount(0);
                    this.bigToSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.youku.resource.widget.YKTitleTabItemViewRv.AnonymousClass3 */

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                    this.bigToSmall.addListener(new AnimatorListenerAdapter() {
                        /* class com.youku.resource.widget.YKTitleTabItemViewRv.AnonymousClass4 */

                        public void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i2);
                            YKTitleTabItemViewRv.this.bigToSmall = null;
                        }

                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i2);
                            YKTitleTabItemViewRv.this.bigToSmall = null;
                        }

                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, (float) i);
                        }
                    });
                    this.bigToSmall.start();
                }
                this.mTextView.setGravity(17);
                this.mTextView.setPadding(0, 0, 0, 0);
            }
            if (!hasImage() && (textView = this.mTextView) != null && (textView.getText() instanceof SpannedString) && !TextUtils.isEmpty(this.mText)) {
                this.mTextView.setText(this.mText);
            }
        }
    }

    public void sendClickTracker(int i, int i2) {
    }

    public void setText(String str) {
        this.mText = str;
        this.mTextView.setText(str);
    }

    public void setTextGradientColors(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
    }

    public YKTitleTabItemViewRv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public YKTitleTabItemViewRv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
