package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import com.youku.css.setter.CssSetter;
import com.youku.css.setter.ICssSetter2;
import com.youku.css.util.ColorUtil;
import com.youku.resource.R;
import com.youku.resource.utils.TextLine;
import com.youku.resource.utils.Utils;
import tb.tp1;
import tb.ug2;

/* compiled from: Taobao */
public class DoubleFeedReserveWidget extends View implements ICssSetter2 {
    private static final String ELLIPSIZE_TEXT = "…";
    private static final int LINE_INDEX_SUBTITLE = 1;
    private static final int LINE_INDEX_TITLE = 0;
    private static final String TAG = "DoubleFeedTagWidget";
    private static float descBaseline = 0.0f;
    private static int height = 0;
    private static Rect iconRect = null;
    private static int imageHeight = 0;
    private static int imageWidth = 0;
    private static int mBgColor = 0;
    private static Paint mBgPaint = null;
    private static int mDescTextColor = 0;
    private static int mDescTextSize = 0;
    private static int maxTitleWidth = 0;
    private static int sArrowWidth = 0;
    private static int sDefaultPadding = 0;
    private static int sDefaultTitleTextColor = 0;
    private static int sDefaultTitleTextSize = -1;
    private static float titleBaseline;
    private Drawable arrowDrawable;
    private Drawable iconDrawable;
    protected String mDesc;
    private float mDescEllipsizeWidth;
    private Paint.FontMetrics mDescFontMetrics;
    private TextPaint mDescPaint;
    private TextLine[] mLines;
    private int[] mLinesWidth;
    private float[] mTextWidth;
    protected String mTitle;
    private float mTitleEllipsizeWidth;
    private Paint.FontMetrics mTitleFontMetrics;
    private TextPaint mTitlePaint;
    private int mTitleStartPadding;
    private int mTitleTextColor;
    private int mTitleTextSize;

    public DoubleFeedReserveWidget(@NonNull Context context) {
        this(context, null);
    }

    private boolean calculateLine(int i, TextPaint textPaint, String str, int i2, float f) {
        float f2;
        if (i <= 0) {
            i = maxTitleWidth;
        }
        if (i <= 0 || TextUtils.isEmpty(str)) {
            getLine(i2).size = 0;
            this.mLinesWidth[i2] = 0;
            return false;
        }
        float f3 = (float) i;
        int breakText = textPaint.breakText(str, true, f3, this.mTextWidth);
        if (breakText == str.length()) {
            this.mLinesWidth[i2] = (int) this.mTextWidth[0];
            return true;
        }
        TextLine line = getLine(i2);
        line.size = 0;
        if (this.mTextWidth[0] + f <= f3) {
            line.appendChars(str, 0, breakText);
            f2 = 0.0f;
        } else {
            int i3 = breakText - 1;
            line.appendChars(str, 0, i3);
            f2 = textPaint.measureText(str, i3, breakText);
        }
        if (f > 0.0f) {
            line.appendChar(ELLIPSIZE_TEXT, 0);
            this.mLinesWidth[i2] = (int) ((this.mTextWidth[0] + f) - f2);
        } else {
            this.mLinesWidth[i2] = (int) this.mTextWidth[0];
        }
        return false;
    }

    private boolean calculateTitleLine(int i, boolean z) {
        return calculateLine(i, this.mTitlePaint, this.mTitle, 0, z ? getTitleEllipsizeWidth() : 0.0f);
    }

    private void drawArrow(Canvas canvas) {
        Drawable drawable = this.arrowDrawable;
        if (drawable != null) {
            int[] iArr = this.mLinesWidth;
            int i = iArr[0];
            int i2 = imageWidth;
            int i3 = height;
            int i4 = sArrowWidth;
            int i5 = iArr[0] + i4 + i2;
            int measuredHeight = getMeasuredHeight();
            int i6 = sArrowWidth;
            drawable.setBounds(i + i2, (i3 - i4) / 2, i5, ((measuredHeight - i6) / 2) + i6);
            this.arrowDrawable.draw(canvas);
            return;
        }
        int[] iArr2 = this.mLinesWidth;
        int i7 = iArr2[0];
        int i8 = imageWidth;
        float f = (float) (i7 + i8);
        int i9 = height;
        int i10 = sArrowWidth;
        float f2 = (float) (iArr2[0] + i10 + i8);
        int measuredHeight2 = getMeasuredHeight();
        int i11 = sArrowWidth;
        canvas.drawRect(f, (float) ((i9 - i10) / 2), f2, (float) (((measuredHeight2 - i11) / 2) + i11), mBgPaint);
    }

    private void drawDesc(Canvas canvas) {
        if (!TextUtils.isEmpty(this.mDesc)) {
            drawOneLineDesc(canvas, initDescPaint(), descBaseline);
        }
    }

    private void drawIcon(Canvas canvas) {
        Drawable drawable = this.iconDrawable;
        if (drawable != null) {
            drawable.setBounds(iconRect);
            this.iconDrawable.draw(canvas);
            return;
        }
        canvas.drawRect(iconRect, mBgPaint);
    }

    private void drawOneLineDesc(Canvas canvas, TextPaint textPaint, float f) {
        if (calculateLine(((getWidth() - imageWidth) - sArrowWidth) - this.mLinesWidth[0], textPaint, this.mDesc, 1, getDescEllipsizeWidth())) {
            canvas.drawText(this.mDesc, ((float) getWidth()) - initDescPaint().measureText(this.mDesc), f, textPaint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[1].size > 0) {
            canvas.drawText(textLineArr[1].text, 0, textLineArr[1].size, ((float) getWidth()) - textPaint.measureText(String.valueOf(this.mLines[1].text)), f, textPaint);
        }
    }

    private void drawOneLineTitle(Canvas canvas, Paint paint, float f) {
        if (calculateTitleLine(-1, true)) {
            canvas.drawText(this.mTitle, (float) imageWidth, f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[0].size > 0) {
            canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, (float) imageWidth, f, paint);
        }
    }

    private void drawTitle(Canvas canvas) {
        if (!TextUtils.isEmpty(this.mTitle)) {
            drawOneLineTitle(canvas, initTitlePaint(), titleBaseline);
        }
    }

    private float getDescEllipsizeWidth() {
        if (this.mDescEllipsizeWidth <= 0.0f) {
            this.mDescEllipsizeWidth = this.mDescPaint.measureText(ELLIPSIZE_TEXT);
        }
        return this.mDescEllipsizeWidth;
    }

    private Paint.FontMetrics getDescFontMetrics() {
        if (this.mDescFontMetrics == null) {
            this.mDescFontMetrics = this.mDescPaint.getFontMetrics();
        }
        return this.mDescFontMetrics;
    }

    private TextLine getLine(int i) {
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[i] == null) {
            textLineArr[i] = new TextLine();
        }
        return this.mLines[i];
    }

    private float getTitleEllipsizeWidth() {
        if (this.mTitleEllipsizeWidth <= 0.0f) {
            this.mTitleEllipsizeWidth = this.mTitlePaint.measureText(ELLIPSIZE_TEXT);
        }
        return this.mTitleEllipsizeWidth;
    }

    private Paint.FontMetrics getTitleFontMetrics() {
        if (this.mTitleFontMetrics == null) {
            this.mTitleFontMetrics = this.mTitlePaint.getFontMetrics();
        }
        return this.mTitleFontMetrics;
    }

    private Paint initBgPaint() {
        if (mBgPaint == null) {
            Paint paint = new Paint();
            mBgPaint = paint;
            paint.setColor(mBgColor);
        }
        int color = mBgPaint.getColor();
        int i = mBgColor;
        if (color != i) {
            mBgPaint.setColor(i);
        }
        return mBgPaint;
    }

    private TextPaint initDescPaint() {
        if (this.mDescPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mDescPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mDescPaint.setColor(mDescTextColor);
            this.mDescPaint.setTextSize((float) mDescTextSize);
        }
        return this.mDescPaint;
    }

    private Rect initIconRect() {
        if (iconRect == null) {
            int i = height;
            int i2 = imageHeight;
            iconRect = new Rect(0, (i - i2) / 2, imageWidth, ((i - i2) / 2) + i2);
        }
        return iconRect;
    }

    private void initProps(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PhoneCommonTitlesWidget, 0, 0);
            this.mTitleTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleTextSize, (float) sDefaultTitleTextSize);
            this.mTitleTextColor = obtainStyledAttributes.getColor(R.styleable.PhoneCommonTitlesWidget_titleTextColor, sDefaultTitleTextColor);
            obtainStyledAttributes.recycle();
            initTitlePaint();
            initBgPaint();
            Paint.FontMetrics titleFontMetrics = getTitleFontMetrics();
            float f = titleFontMetrics.bottom;
            float f2 = f - titleFontMetrics.top;
            float f3 = (f2 / 2.0f) - f;
            int i = (int) (f2 + ((float) (sDefaultPadding * 2)));
            height = i;
            titleBaseline = ((float) (i / 2)) + f3;
            initDescPaint();
            Paint.FontMetrics descFontMetrics = getDescFontMetrics();
            float f4 = descFontMetrics.bottom;
            descBaseline = (((float) (height / 2)) + ((f4 - descFontMetrics.top) / 2.0f)) - f4;
            initIconRect();
            mBgColor = getResources().getColor(R.color.ykn_primary_fill_color);
        }
    }

    private TextPaint initTitlePaint() {
        if (this.mTitlePaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTitlePaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTitlePaint.setColor(this.mTitleTextColor);
            this.mTitlePaint.setTextSize((float) this.mTitleTextSize);
        }
        return this.mTitlePaint;
    }

    private void initValues(@NonNull Context context, AttributeSet attributeSet) {
        if (sDefaultTitleTextSize <= 0 || sDefaultTitleTextColor != Color.parseColor("#00B3FA")) {
            Resources resources = context.getResources();
            int i = R.dimen.resource_size_12;
            sDefaultTitleTextSize = resources.getDimensionPixelSize(i);
            sDefaultTitleTextColor = Color.parseColor("#00B3FA");
            int dimensionPixelOffset = resources.getDimensionPixelOffset(i);
            sArrowWidth = dimensionPixelOffset;
            sDefaultPadding = dimensionPixelOffset;
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.resource_size_21);
            imageHeight = dimensionPixelSize;
            imageWidth = dimensionPixelSize;
            mDescTextSize = resources.getDimensionPixelSize(R.dimen.resource_size_11);
            mDescTextColor = Color.parseColor("#999999");
        }
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        drawIcon(canvas);
        drawTitle(canvas);
        drawArrow(canvas);
        drawDesc(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        maxTitleWidth = (size - imageWidth) - sDefaultPadding;
        setMeasuredDimension(size, height);
    }

    @Override // com.youku.css.setter.ICssSetter2
    public void resetCss(String str) {
        int resetColor = CssSetter.resetColor(this, R.id.tag_css_color);
        if (resetColor != 0) {
            setTitleTextColor(resetColor);
        }
    }

    @Override // com.youku.css.setter.ICssSetter
    public void setCss(String str, Css css) {
        str.hashCode();
        if (str.equals(CssConst.CssScenes.CARD_FOOTER_TITLE)) {
            setDescTextColor(ColorUtil.parseColorSafely(css.color, mDescTextColor));
        }
    }

    public void setDesc(String str) {
        if (!TextUtils.equals(str, this.mDesc)) {
            this.mDesc = str;
            invalidate();
        }
    }

    public void setDescTextColor(int i) {
        if (i == 0) {
            i = mDescTextColor;
        }
        mDescTextColor = i;
        TextPaint textPaint = this.mDescPaint;
        if (textPaint != null) {
            textPaint.setColor(i);
        }
    }

    public void setLeftIcon(String str, int i, final int i2, final int i3) {
        this.iconDrawable = null;
        tp1.o().s(str).Q(new IPhenixListener<ug2>() {
            /* class com.youku.resource.widget.DoubleFeedReserveWidget.AnonymousClass1 */

            public boolean onHappen(ug2 ug2) {
                if (ug2.f() == null || ug2.i()) {
                    return true;
                }
                DoubleFeedReserveWidget.this.iconDrawable = Utils.zoomDrawable(ug2.f(), DoubleFeedReserveWidget.this.getResources(), i2, i3);
                DoubleFeedReserveWidget.this.postInvalidate(DoubleFeedReserveWidget.iconRect.left, DoubleFeedReserveWidget.iconRect.top, DoubleFeedReserveWidget.iconRect.right, DoubleFeedReserveWidget.iconRect.bottom);
                return true;
            }
        }).n();
    }

    public void setRightIcon(String str, int i, final int i2, final int i3) {
        this.arrowDrawable = null;
        tp1.o().s(str).Q(new IPhenixListener<ug2>() {
            /* class com.youku.resource.widget.DoubleFeedReserveWidget.AnonymousClass2 */

            public boolean onHappen(ug2 ug2) {
                if (ug2.f() == null || ug2.i()) {
                    return true;
                }
                DoubleFeedReserveWidget.this.arrowDrawable = Utils.zoomDrawable(ug2.f(), DoubleFeedReserveWidget.this.getResources(), i2, i3);
                DoubleFeedReserveWidget doubleFeedReserveWidget = DoubleFeedReserveWidget.this;
                doubleFeedReserveWidget.postInvalidate(doubleFeedReserveWidget.mLinesWidth[0] + DoubleFeedReserveWidget.imageWidth, DoubleFeedReserveWidget.iconRect.top, DoubleFeedReserveWidget.this.mLinesWidth[0] + DoubleFeedReserveWidget.imageWidth + DoubleFeedReserveWidget.sArrowWidth, DoubleFeedReserveWidget.iconRect.bottom);
                return true;
            }
        }).n();
    }

    public void setTitle(String str) {
        if (!TextUtils.equals(str, this.mTitle)) {
            this.mTitle = str;
            invalidate();
        }
    }

    public void setTitleTextColor(int i) {
        if (i == 0) {
            i = sDefaultTitleTextColor;
        }
        if (i != this.mTitleTextColor) {
            this.mTitleTextColor = i;
            TextPaint textPaint = this.mTitlePaint;
            if (textPaint != null) {
                textPaint.setColor(i);
            }
        }
    }

    public DoubleFeedReserveWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleFeedReserveWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleStartPadding = 0;
        this.mLines = new TextLine[3];
        this.mLinesWidth = new int[3];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        this.mDescEllipsizeWidth = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }

    public DoubleFeedReserveWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTitleStartPadding = 0;
        this.mLines = new TextLine[3];
        this.mLinesWidth = new int[3];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        this.mDescEllipsizeWidth = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }
}
