package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.DXNativeListLayout;

/* compiled from: Taobao */
public class DXListLayout extends DXLinearLayoutWidgetNode {

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXListLayout();
        }
    }

    public DXListLayout() {
        this.propertyInitFlag |= 2;
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXListLayout();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeListLayout(context);
    }
}
