package com.taobao.weex.ui.view.border;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import com.taobao.weex.dom.CSSShorthand;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED;

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.weex.ui.view.border.BorderStyle$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle = iArr;
            iArr[BorderStyle.DOTTED.ordinal()] = 1;
            $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[BorderStyle.DASHED.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Shader getLineShader(float f, int i, CSSShorthand.EDGE edge) {
        int i2 = AnonymousClass1.$SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
        } else if (edge == CSSShorthand.EDGE.LEFT || edge == CSSShorthand.EDGE.RIGHT) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, f * 2.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        } else if (edge == CSSShorthand.EDGE.TOP || edge == CSSShorthand.EDGE.BOTTOM) {
            return new LinearGradient(0.0f, 0.0f, f * 2.0f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        }
        if (edge == CSSShorthand.EDGE.LEFT || edge == CSSShorthand.EDGE.RIGHT) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, f * 6.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        } else if (edge != CSSShorthand.EDGE.TOP && edge != CSSShorthand.EDGE.BOTTOM) {
            return null;
        } else {
            return new LinearGradient(0.0f, 0.0f, 6.0f * f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        }
    }
}
