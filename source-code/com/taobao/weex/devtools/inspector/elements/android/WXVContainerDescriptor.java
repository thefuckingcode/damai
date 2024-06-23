package com.taobao.weex.devtools.inspector.elements.android;

import android.view.ViewGroup;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;

/* compiled from: Taobao */
public class WXVContainerDescriptor extends AbstractChainedDescriptor<WXVContainer> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(WXVContainer wXVContainer, Accumulator accumulator) {
        onGetChildren(wXVContainer, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(WXVContainer wXVContainer, Accumulator<Object> accumulator) {
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            WXComponent child = wXVContainer.getChild(i);
            if (child != null) {
                accumulator.store(child);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onGetStyles(WXVContainer wXVContainer, StyleAccumulator styleAccumulator) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup realView = wXVContainer.getRealView();
        if (realView != null && (layoutParams = realView.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = marginLayoutParams.leftMargin;
            if (i != 0 || marginLayoutParams.rightMargin != 0 || marginLayoutParams.topMargin != 0 || marginLayoutParams.bottomMargin != 0) {
                styleAccumulator.store(W3CStyleConstants.MARGIN_LEFT, String.valueOf(i), false);
                styleAccumulator.store(W3CStyleConstants.MARGIN_TOP, String.valueOf(marginLayoutParams.topMargin), false);
                styleAccumulator.store(W3CStyleConstants.MARGIN_RIGHT, String.valueOf(marginLayoutParams.rightMargin), false);
                styleAccumulator.store(W3CStyleConstants.MARGIN_BOTTOM, String.valueOf(marginLayoutParams.bottomMargin), false);
            }
        }
    }
}
