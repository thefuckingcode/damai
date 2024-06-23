package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* compiled from: Taobao */
interface AndroidDescriptorHost extends Descriptor.Host {
    @Nullable
    View getHighlightingView(@Nullable Object obj);
}
