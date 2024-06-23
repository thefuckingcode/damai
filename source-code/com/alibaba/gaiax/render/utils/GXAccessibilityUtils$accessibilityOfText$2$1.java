package com.alibaba.gaiax.render.utils;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/utils/GXAccessibilityUtils$accessibilityOfText$2$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXAccessibilityUtils$accessibilityOfText$2$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ String a;

    GXAccessibilityUtils$accessibilityOfText$2$1(String str) {
        this.a = str;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(@Nullable View view, @Nullable AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat != null) {
            accessibilityNodeInfoCompat.setClassName(GXAccessibilityUtils.INSTANCE.d(this.a));
        }
    }
}
