package com.taobao.weex.ui.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXCircleIndicator;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXIndicator extends WXComponent<WXCircleIndicator> {
    @Deprecated
    public WXIndicator(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @WXComponentProp(name = Constants.Name.ITEM_COLOR)
    public void setItemColor(String str) {
        int color;
        if (!TextUtils.isEmpty(str) && (color = WXResourceUtils.getColor(str)) != Integer.MIN_VALUE) {
            ((WXCircleIndicator) getHostView()).setPageColor(color);
            ((WXCircleIndicator) getHostView()).forceLayout();
            ((WXCircleIndicator) getHostView()).requestLayout();
        }
    }

    @WXComponentProp(name = Constants.Name.ITEM_SELECTED_COLOR)
    public void setItemSelectedColor(String str) {
        int color;
        if (!TextUtils.isEmpty(str) && (color = WXResourceUtils.getColor(str)) != Integer.MIN_VALUE) {
            ((WXCircleIndicator) getHostView()).setFillColor(color);
            ((WXCircleIndicator) getHostView()).forceLayout();
            ((WXCircleIndicator) getHostView()).requestLayout();
        }
    }

    @WXComponentProp(name = Constants.Name.ITEM_SIZE)
    public void setItemSize(int i) {
        if (i >= 0) {
            ((WXCircleIndicator) getHostView()).setRadius(WXViewUtils.getRealPxByWidth((float) i, getInstance().getInstanceViewPortWidth()) / 2.0f);
            ((WXCircleIndicator) getHostView()).forceLayout();
            ((WXCircleIndicator) getHostView()).requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1177488820:
                if (str.equals(Constants.Name.ITEM_SIZE)) {
                    c = 0;
                    break;
                }
                break;
            case 1873297717:
                if (str.equals(Constants.Name.ITEM_SELECTED_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case 2127804432:
                if (str.equals(Constants.Name.ITEM_COLOR)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Integer integer = WXUtils.getInteger(obj, null);
                if (integer != null) {
                    setItemSize(integer.intValue());
                }
                return true;
            case 1:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setItemSelectedColor(string);
                }
                return true;
            case 2:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setItemColor(string2);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    public void setShowIndicators(boolean z) {
        if (getHostView() != null) {
            if (z) {
                ((WXCircleIndicator) getHostView()).setVisibility(0);
            } else {
                ((WXCircleIndicator) getHostView()).setVisibility(8);
            }
        }
    }

    public WXIndicator(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXCircleIndicator initComponentHostView(@NonNull Context context) {
        WXCircleIndicator wXCircleIndicator = new WXCircleIndicator(context);
        if (getParent() instanceof WXSlider) {
            return wXCircleIndicator;
        }
        if (!WXEnvironment.isApkDebugable()) {
            return null;
        }
        throw new WXRuntimeException("WXIndicator initView error.");
    }

    /* access modifiers changed from: protected */
    public void onHostViewInitialized(WXCircleIndicator wXCircleIndicator) {
        super.onHostViewInitialized((View) wXCircleIndicator);
        if (getParent() instanceof WXSlider) {
            ((WXSlider) getParent()).addIndicator(this);
        }
    }

    /* access modifiers changed from: protected */
    public void setHostLayoutParams(WXCircleIndicator wXCircleIndicator, int i, int i2, int i3, int i4, int i5, int i6) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        wXCircleIndicator.setLayoutParams(layoutParams);
    }
}
