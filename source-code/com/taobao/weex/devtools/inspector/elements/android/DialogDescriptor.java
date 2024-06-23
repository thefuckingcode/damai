package com.taobao.weex.devtools.inspector.elements.android;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* compiled from: Taobao */
final class DialogDescriptor extends AbstractChainedDescriptor<Dialog> implements HighlightableDescriptor {
    DialogDescriptor() {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewForHighlighting(Object obj) {
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            return ((AndroidDescriptorHost) host).getHighlightingView(((Dialog) obj).getWindow());
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(Dialog dialog, Accumulator accumulator) {
        onGetChildren(dialog, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(Dialog dialog, Accumulator<Object> accumulator) {
        Window window = dialog.getWindow();
        if (window != null) {
            accumulator.store(window);
        }
    }
}
