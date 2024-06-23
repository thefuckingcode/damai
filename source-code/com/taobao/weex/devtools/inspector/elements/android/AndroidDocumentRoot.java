package com.taobao.weex.devtools.inspector.elements.android;

import android.app.Application;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.protocol.module.DOM;
import com.taobao.weex.ui.WXRenderManager;
import java.util.List;

/* compiled from: Taobao */
public final class AndroidDocumentRoot extends AbstractChainedDescriptor<AndroidDocumentRoot> {
    private Application mApplication;

    public AndroidDocumentRoot(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(AndroidDocumentRoot androidDocumentRoot, Accumulator accumulator) {
        onGetChildren(androidDocumentRoot, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public String onGetNodeName(AndroidDocumentRoot androidDocumentRoot) {
        return "root";
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(AndroidDocumentRoot androidDocumentRoot, Accumulator<Object> accumulator) {
        List<WXSDKInstance> allInstances;
        if (DOM.isNativeMode()) {
            accumulator.store(this.mApplication);
            return;
        }
        WXRenderManager G = WXSDKManager.v().G();
        if (!(G == null || (allInstances = G.getAllInstances()) == null || allInstances.isEmpty())) {
            for (WXSDKInstance wXSDKInstance : allInstances) {
                accumulator.store(wXSDKInstance);
            }
        }
    }

    /* access modifiers changed from: protected */
    public NodeType onGetNodeType(AndroidDocumentRoot androidDocumentRoot) {
        return NodeType.DOCUMENT_NODE;
    }
}
