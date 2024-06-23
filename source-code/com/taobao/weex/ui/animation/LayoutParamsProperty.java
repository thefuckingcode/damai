package com.taobao.weex.ui.animation;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.IRenderResult;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class LayoutParamsProperty extends Property<View, Integer> {
    LayoutParamsProperty() {
        super(Integer.class, "layoutParams");
    }

    /* access modifiers changed from: protected */
    public abstract Integer getProperty(ViewGroup.LayoutParams layoutParams);

    /* access modifiers changed from: protected */
    public abstract void setProperty(ViewGroup.LayoutParams layoutParams, Integer num);

    public Integer get(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return getProperty(layoutParams);
    }

    public void set(View view, Integer num) {
        ViewGroup.LayoutParams layoutParams;
        WXComponent component;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            setProperty(layoutParams, num);
            if ((view instanceof IRenderResult) && (component = ((IRenderResult) view).getComponent()) != null) {
                component.notifyNativeSizeChanged(layoutParams.width, layoutParams.height);
            }
            view.requestLayout();
        }
    }
}
