package com.taobao.weex.ui.component;

import android.view.View;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.utils.ATagUtil;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXA extends WXDiv {
    @Deprecated
    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals("href")) {
            return super.setProperty(str, obj);
        }
        return true;
    }

    public WXA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: protected */
    public void onHostViewInitialized(WXFrameLayout wXFrameLayout) {
        addClickListener(new WXComponent.OnClickListener() {
            /* class com.taobao.weex.ui.component.WXA.AnonymousClass1 */

            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                String str;
                WXAttr attrs = WXA.this.getAttrs();
                if (attrs != null && (str = (String) attrs.get("href")) != null) {
                    ATagUtil.onClick(null, WXA.this.getInstanceId(), str);
                }
            }
        });
        super.onHostViewInitialized((View) wXFrameLayout);
    }
}
