package com.youku.css.setter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.youku.css.R;
import com.youku.css.dto.Css;
import com.youku.css.util.ColorUtil;
import com.youku.css.util.CssUtils;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TextViewCssSetter {
    TextViewCssSetter() {
    }

    static void resetCss(TextView textView) {
        int resetColor;
        if (textView != null && (resetColor = CssSetter.resetColor(textView, R.id.tag_css_color)) != 0) {
            textView.setTextColor(resetColor);
            setDrawableColorFilter(textView, resetColor, true);
        }
    }

    private static void setColorFilter(Drawable drawable, int i) {
        drawable.mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    static void setCss(TextView textView, Css css) {
        if (textView != null && css != null) {
            int parseColorSafely = ColorUtil.parseColorSafely(css.color);
            if (parseColorSafely != 0) {
                CssSetter.saveColor(textView, R.id.tag_css_color, textView.getCurrentTextColor());
                textView.setTextColor(parseColorSafely);
                setDrawableColorFilter(textView, parseColorSafely, false);
                return;
            }
            resetCss(textView);
        }
    }

    private static void setDrawableColorFilter(TextView textView, int i, boolean z) {
        if (textView != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            for (int i2 = 0; i2 < compoundDrawables.length; i2++) {
                Drawable drawable = compoundDrawables[i2];
                if (drawable != null) {
                    Drawable mutate = drawable.mutate();
                    if (z) {
                        mutate.clearColorFilter();
                    } else {
                        mutate.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
                    }
                    CssUtils.seTextViewDrawable(textView, mutate, i2);
                }
            }
        }
    }
}
