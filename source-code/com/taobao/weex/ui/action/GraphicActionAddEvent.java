package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.component.WXComponent;
import tb.se2;

/* compiled from: Taobao */
public class GraphicActionAddEvent extends BasicGraphicAction {
    private final String mEvent;

    public GraphicActionAddEvent(WXSDKInstance wXSDKInstance, String str, Object obj) {
        super(wXSDKInstance, str);
        this.mEvent = WXEvent.getEventName(obj);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        if (wXComponent != null) {
            se2.f();
            if (!wXComponent.getEvents().contains(this.mEvent)) {
                wXComponent.getEvents().addEvent(this.mEvent);
            }
            wXComponent.addEvent(this.mEvent);
            se2.c("addEventToComponent");
        }
    }
}
