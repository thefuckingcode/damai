package com.taobao.weex.layout.measurefunc;

import android.graphics.Canvas;
import android.os.Build;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.TextDecorationSpan;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXCustomStyleSpan;
import com.taobao.weex.dom.WXLineHeightSpan;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.layout.MeasureMode;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXTextDecoration;
import com.taobao.weex.utils.WXDomUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public class TextContentBoxMeasurement extends ContentBoxMeasurement {
    private static final Canvas DUMMY_CANVAS = new Canvas();
    private static final String ELLIPSIS = "…";
    private AtomicReference<Layout> atomicReference = new AtomicReference<>();
    private boolean hasBeenMeasured = false;
    @Nullable
    private Layout layout;
    private Layout.Alignment mAlignment;
    private int mColor;
    private String mFontFamily = null;
    private int mFontSize = -1;
    private int mFontStyle = -1;
    private int mFontWeight = -1;
    private boolean mIsColorSet = false;
    private int mLineHeight = -1;
    private int mNumberOfLines = -1;
    private String mText = null;
    private WXTextDecoration mTextDecoration = WXTextDecoration.NONE;
    private TextPaint mTextPaint;
    private float previousWidth = Float.NaN;
    @Nullable
    private Spanned spanned;
    private TextUtils.TruncateAt textOverflow;

    /* compiled from: Taobao */
    class SetSpanOperation {
        protected final int end;
        protected final int flag;
        protected final int start;
        protected final Object what;

        SetSpanOperation(TextContentBoxMeasurement textContentBoxMeasurement, int i, int i2, Object obj) {
            this(i, i2, obj, 17);
        }

        public void execute(Spannable spannable) {
            spannable.setSpan(this.what, this.start, this.end, this.flag);
        }

        SetSpanOperation(int i, int i2, Object obj, int i3) {
            this.start = i;
            this.end = i2;
            this.what = obj;
            this.flag = i3;
        }
    }

    public TextContentBoxMeasurement(WXComponent wXComponent) {
        super(wXComponent);
    }

    private void adjustSpansRange(@NonNull Spanned spanned2, @NonNull Spannable spannable) {
        Object[] spans = spanned2.getSpans(0, spanned2.length(), Object.class);
        for (Object obj : spans) {
            int spanStart = spanned2.getSpanStart(obj);
            int spanEnd = spanned2.getSpanEnd(obj);
            if (spanStart == 0 && spanEnd == spanned2.length()) {
                spannable.removeSpan(obj);
                spannable.setSpan(obj, 0, spannable.length(), spanned2.getSpanFlags(obj));
            }
        }
    }

    @NonNull
    private Layout createLayout(float f, @Nullable Layout layout2) {
        int lineStart;
        int lineEnd;
        SpannableStringBuilder spannableStringBuilder;
        if (this.previousWidth != f || layout2 == null) {
            layout2 = new StaticLayout(this.spanned, this.mTextPaint, (int) Math.ceil((double) f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        int i = this.mNumberOfLines;
        if (i == -1 || i <= 0 || i >= layout2.getLineCount() || (lineStart = layout2.getLineStart(this.mNumberOfLines - 1)) >= (lineEnd = layout2.getLineEnd(this.mNumberOfLines - 1))) {
            return layout2;
        }
        if (lineStart > 0) {
            spannableStringBuilder = new SpannableStringBuilder(this.spanned.subSequence(0, lineStart));
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        double d = (double) f;
        spannableStringBuilder.append((CharSequence) truncate(new SpannableStringBuilder(this.spanned.subSequence(lineStart, lineEnd)), this.mTextPaint, (int) Math.ceil(d), this.textOverflow));
        adjustSpansRange(this.spanned, spannableStringBuilder);
        this.spanned = spannableStringBuilder;
        return new StaticLayout(this.spanned, this.mTextPaint, (int) Math.ceil(d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    private float getTextWidth(TextPaint textPaint, float f, boolean z) {
        if (this.mText == null) {
            if (z) {
                return f;
            }
            return 0.0f;
        } else if (z) {
            return f;
        } else {
            float desiredWidth = Layout.getDesiredWidth(this.spanned, textPaint);
            return (WXUtils.isUndefined(f) || desiredWidth < f) ? desiredWidth : f;
        }
    }

    private void recalculateLayout(float f) {
        float contentWidth = WXDomUtils.getContentWidth(this.mComponent.getPadding(), this.mComponent.getBorder(), f);
        if (contentWidth > 0.0f) {
            Spanned createSpanned = createSpanned(this.mText);
            this.spanned = createSpanned;
            if (createSpanned != null) {
                Layout createLayout = createLayout(contentWidth, this.layout);
                this.layout = createLayout;
                this.previousWidth = (float) createLayout.getWidth();
                return;
            }
            this.previousWidth = 0.0f;
        }
    }

    private void setSpan(Spannable spannable, Object obj, int i, int i2, int i3) {
        spannable.setSpan(obj, i, i2, i3);
    }

    private void swap() {
        Layout layout2 = this.layout;
        if (layout2 != null) {
            this.atomicReference.set(layout2);
            this.layout = null;
        }
        this.hasBeenMeasured = false;
    }

    @NonNull
    private Spanned truncate(@Nullable Editable editable, @NonNull TextPaint textPaint, int i, @Nullable TextUtils.TruncateAt truncateAt) {
        SpannedString spannedString = new SpannedString("");
        if (!TextUtils.isEmpty(editable) && editable.length() > 0) {
            if (truncateAt != null) {
                editable.append(ELLIPSIS);
                Object[] spans = editable.getSpans(0, editable.length(), Object.class);
                for (Object obj : spans) {
                    int spanStart = editable.getSpanStart(obj);
                    int spanEnd = editable.getSpanEnd(obj);
                    if (spanStart == 0 && spanEnd == editable.length() - 1) {
                        editable.removeSpan(obj);
                        editable.setSpan(obj, 0, editable.length(), editable.getSpanFlags(obj));
                    }
                }
            }
            while (editable.length() > 1) {
                int length = editable.length() - 1;
                if (truncateAt != null) {
                    length--;
                }
                editable.delete(length, length + 1);
                if (new StaticLayout(editable, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= 1) {
                    return editable;
                }
            }
        }
        return spannedString;
    }

    private void updateStyleAndText() {
        updateStyleImp(this.mComponent.getStyles());
        this.mText = WXAttr.getValue(this.mComponent.getAttrs());
    }

    private void updateStyleImp(Map<String, Object> map) {
        if (map != null) {
            if (map.containsKey(Constants.Name.LINES)) {
                int lines = WXStyle.getLines(map);
                if (lines <= 0) {
                    lines = -1;
                }
                this.mNumberOfLines = lines;
            }
            if (map.containsKey("fontSize")) {
                this.mFontSize = WXStyle.getFontSize(map, this.mComponent.getViewPortWidth());
            }
            if (map.containsKey(Constants.Name.FONT_WEIGHT)) {
                this.mFontWeight = WXStyle.getFontWeight(map);
            }
            if (map.containsKey(Constants.Name.FONT_STYLE)) {
                this.mFontStyle = WXStyle.getFontStyle(map);
            }
            if (map.containsKey("color")) {
                int color = WXResourceUtils.getColor(WXStyle.getTextColor(map));
                this.mColor = color;
                this.mIsColorSet = color != Integer.MIN_VALUE;
            }
            if (map.containsKey(Constants.Name.TEXT_DECORATION)) {
                this.mTextDecoration = WXStyle.getTextDecoration(map);
            }
            if (map.containsKey(Constants.Name.FONT_FAMILY)) {
                this.mFontFamily = WXStyle.getFontFamily(map);
            }
            this.mAlignment = WXStyle.getTextAlignment(map, this.mComponent.isLayoutRTL());
            this.textOverflow = WXStyle.getTextOverflow(map);
            int lineHeight = WXStyle.getLineHeight(map, this.mComponent.getViewPortWidth());
            if (lineHeight != -1) {
                this.mLineHeight = lineHeight;
            }
        }
    }

    private boolean warmUpTextLayoutCache(Layout layout2) {
        try {
            layout2.draw(DUMMY_CANVAS);
            return true;
        } catch (Exception e) {
            WXLogUtils.eTag("TextWarmUp", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Spanned createSpanned(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        updateSpannable(spannableString, 17);
        return spannableString;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void forceRelayout() {
        layoutBefore();
        measure(this.previousWidth, Float.NaN, MeasureMode.EXACTLY, MeasureMode.UNSPECIFIED);
        layoutAfter(this.previousWidth, Float.NaN);
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void layoutAfter(float f, float f2) {
        WXComponent wXComponent = this.mComponent;
        if (wXComponent != null) {
            if (!this.hasBeenMeasured) {
                updateStyleAndText();
                recalculateLayout(f);
            } else if (!(this.layout == null || WXDomUtils.getContentWidth(wXComponent.getPadding(), this.mComponent.getBorder(), f) == this.previousWidth)) {
                recalculateLayout(f);
            }
            this.hasBeenMeasured = false;
            Layout layout2 = this.layout;
            if (layout2 != null && !layout2.equals(this.atomicReference.get()) && Build.VERSION.SDK_INT >= 19 && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                warmUpTextLayoutCache(this.layout);
            }
            swap();
            WXSDKManager.v().G().postOnUiThread(new Runnable() {
                /* class com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement.AnonymousClass1 */

                public void run() {
                    if (((ContentBoxMeasurement) TextContentBoxMeasurement.this).mComponent != null) {
                        ((ContentBoxMeasurement) TextContentBoxMeasurement.this).mComponent.updateExtra(TextContentBoxMeasurement.this.atomicReference.get());
                    }
                }
            }, this.mComponent.getInstanceId());
        }
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void layoutBefore() {
        this.mTextPaint = new TextPaint(1);
        this.hasBeenMeasured = false;
        updateStyleAndText();
        this.spanned = createSpanned(this.mText);
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void measureInternal(float f, float f2, int i, int i2) {
        boolean z = true;
        this.hasBeenMeasured = true;
        TextPaint textPaint = this.mTextPaint;
        if (i != MeasureMode.EXACTLY) {
            z = false;
        }
        float textWidth = getTextWidth(textPaint, f, z);
        if (textWidth <= 0.0f || this.spanned == null) {
            int i3 = MeasureMode.UNSPECIFIED;
            if (i == i3) {
                f = 0.0f;
            }
            if (i2 == i3) {
                f2 = 0.0f;
            }
        } else {
            Layout createLayout = createLayout(textWidth, null);
            this.layout = createLayout;
            this.previousWidth = (float) createLayout.getWidth();
            if (Float.isNaN(f)) {
                f = (float) this.layout.getWidth();
            } else {
                f = Math.min((float) this.layout.getWidth(), f);
            }
            if (Float.isNaN(f2)) {
                f2 = (float) this.layout.getHeight();
            }
        }
        this.mMeasureWidth = f;
        this.mMeasureHeight = f2;
    }

    /* access modifiers changed from: protected */
    public void updateSpannable(Spannable spannable, int i) {
        int length = spannable.length();
        int i2 = this.mFontSize;
        if (i2 == -1) {
            this.mTextPaint.setTextSize(32.0f);
        } else {
            this.mTextPaint.setTextSize((float) i2);
        }
        int i3 = this.mLineHeight;
        if (i3 != -1) {
            setSpan(spannable, new WXLineHeightSpan(i3), 0, length, i);
        }
        setSpan(spannable, new AlignmentSpan.Standard(this.mAlignment), 0, length, i);
        if (!(this.mFontStyle == -1 && this.mFontWeight == -1 && this.mFontFamily == null)) {
            setSpan(spannable, new WXCustomStyleSpan(this.mFontStyle, this.mFontWeight, this.mFontFamily), 0, length, i);
        }
        if (this.mIsColorSet) {
            this.mTextPaint.setColor(this.mColor);
        }
        WXTextDecoration wXTextDecoration = this.mTextDecoration;
        if (wXTextDecoration == WXTextDecoration.UNDERLINE || wXTextDecoration == WXTextDecoration.LINETHROUGH) {
            setSpan(spannable, new TextDecorationSpan(this.mTextDecoration), 0, length, i);
        }
    }
}
