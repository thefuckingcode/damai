package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import android.view.Window;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class WindowDescriptor extends AbstractChainedDescriptor<Window> implements HighlightableDescriptor {
    WindowDescriptor() {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewForHighlighting(Object obj) {
        return ((Window) obj).peekDecorView();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(Window window, Accumulator accumulator) {
        onGetChildren(window, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(Window window, Accumulator<Object> accumulator) {
        View peekDecorView = window.peekDecorView();
        if (peekDecorView != null) {
            accumulator.store(peekDecorView);
        }
    }
}
