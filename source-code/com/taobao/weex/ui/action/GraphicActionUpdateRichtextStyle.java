package com.taobao.weex.ui.action;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.richtext.WXRichText;
import java.util.HashMap;

/* compiled from: Taobao */
public class GraphicActionUpdateRichtextStyle extends BasicGraphicAction {
    public GraphicActionUpdateRichtextStyle(WXSDKInstance wXSDKInstance, String str, HashMap<String, String> hashMap, String str2, String str3) {
        super(wXSDKInstance, str3);
        WXRichText wXRichText = (WXRichText) WXSDKManager.v().G().getWXComponent(getPageId(), str3);
        if (wXRichText != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(hashMap);
            wXRichText.updateChildNodeStyles(str, hashMap2);
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }
}
