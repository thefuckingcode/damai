package com.taobao.weex.ui.component.list;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;

@Component(lazyload = false)
/* compiled from: Taobao */
public class HorizontalListComponent extends WXListComponent {
    public HorizontalListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.Scrollable, com.taobao.weex.ui.component.list.BasicListComponent
    public int getOrientation() {
        return 0;
    }
}
