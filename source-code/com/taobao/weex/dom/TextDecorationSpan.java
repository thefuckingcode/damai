package com.taobao.weex.dom;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.component.WXTextDecoration;

/* compiled from: Taobao */
public class TextDecorationSpan extends CharacterStyle implements UpdateAppearance {
    private final WXTextDecoration mTextDecoration;

    /* renamed from: com.taobao.weex.dom.TextDecorationSpan$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[WXTextDecoration.values().length];
            $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration = iArr;
            iArr[WXTextDecoration.LINETHROUGH.ordinal()] = 1;
            $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[WXTextDecoration.UNDERLINE.ordinal()] = 2;
            try {
                $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[WXTextDecoration.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public TextDecorationSpan(@NonNull WXTextDecoration wXTextDecoration) {
        this.mTextDecoration = wXTextDecoration;
    }

    public void updateDrawState(TextPaint textPaint) {
        int i = AnonymousClass1.$SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[this.mTextDecoration.ordinal()];
        if (i == 1) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(true);
        } else if (i == 2) {
            textPaint.setUnderlineText(true);
            textPaint.setStrikeThruText(false);
        } else if (i == 3) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(false);
        }
    }
}
