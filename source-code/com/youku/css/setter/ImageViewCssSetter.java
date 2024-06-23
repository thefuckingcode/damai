package com.youku.css.setter;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.youku.css.R;
import com.youku.css.dto.Css;
import com.youku.css.util.ColorUtil;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ImageViewCssSetter {
    ImageViewCssSetter() {
    }

    static void resetCss(ImageView imageView) {
        if (imageView != null) {
            CssSetter.resetColor(imageView, R.id.tag_css_color);
            imageView.clearColorFilter();
        }
    }

    static void setCss(ImageView imageView, Css css) {
        if (imageView != null && css != null) {
            int parseColorSafely = ColorUtil.parseColorSafely(css.color);
            if (parseColorSafely != 0) {
                CssSetter.saveColor(imageView, R.id.tag_css_color, parseColorSafely);
                imageView.setColorFilter(parseColorSafely, PorterDuff.Mode.SRC_IN);
                return;
            }
            resetCss(imageView);
        }
    }
}
