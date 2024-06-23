package com.taobao.weex.devtools.inspector.network;

import com.taobao.weex.devtools.inspector.protocol.module.Page;

/* JADX WARN: Init of enum HTML can be incorrect */
/* JADX WARN: Init of enum TEXT can be incorrect */
/* compiled from: Taobao */
public enum PrettyPrinterDisplayType {
    JSON(Page.ResourceType.XHR),
    HTML(r2),
    TEXT(r2);
    
    private final Page.ResourceType mResourceType;

    static {
        Page.ResourceType resourceType = Page.ResourceType.DOCUMENT;
    }

    private PrettyPrinterDisplayType(Page.ResourceType resourceType) {
        this.mResourceType = resourceType;
    }

    public Page.ResourceType getResourceType() {
        return this.mResourceType;
    }
}
